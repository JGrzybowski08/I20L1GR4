package Connection.PacjentCon;

import Controller.LogowanieController;
import Models.ModelSpisLekarzy;
import Models.ModelZarezerwujWizyte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Connection.Polaczenie;
import javafx.scene.control.Alert;
import org.apache.ibatis.jdbc.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ZarezerwujWizyte {



    public static ObservableList<ModelZarezerwujWizyte> WszyscyLekarzeGet() {

        ObservableList<ModelZarezerwujWizyte> SpisLekarzyOL = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT lekarze.Imie, lekarze.Nazwisko, lekarze.Email, lekarze.Telefon, lekarze.Specjalizacja FROM lekarze"
            );

            while (rs.next()) {

                SpisLekarzyOL.add(new ModelZarezerwujWizyte(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SpisLekarzyOL;
    }

    public static ObservableList<ModelZarezerwujWizyte> FiltrowaniLekarzeGet(String filtrCB, String filtrTF) {
        ObservableList<ModelZarezerwujWizyte> SpisLekarzyOL = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT lekarze.Imie, lekarze.Nazwisko, lekarze.Email, lekarze.Telefon, lekarze.Specjalizacja FROM lekarze WHERE " + filtrCB + " = '" + filtrTF +"'"
            );

            while (rs.next()) {

                /**
                 * SpisLekarzyOL.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy SpisLekarzyOL.
                 */

                SpisLekarzyOL.add(new ModelZarezerwujWizyte(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SpisLekarzyOL;
    }

    public static void Zarezerwuj(String Data, String Godzina, String Opis, ModelZarezerwujWizyte Lekarz){

        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        Alert alertErr = new Alert(Alert.AlertType.ERROR);


        int PacjentID = LogowanieController.getKonto_ID();
        int LekarzID = GetLekarzID(Lekarz);

        Connection con = Polaczenie.Connect();
        try{
            PreparedStatement DodajWizyte = con.prepareStatement("INSERT into wizyty values(NULL, ?, ?, ?, ?, ?, ?)");
            DodajWizyte.setString(1, Data);
            DodajWizyte.setString(2, Godzina);
            DodajWizyte.setString(3, Opis);
            DodajWizyte.setString(4, "Oczekująca");//Status
            DodajWizyte.setInt(5, PacjentID);
            DodajWizyte.setInt(6, LekarzID);
            DodajWizyte.executeUpdate();

            alertInfo.setTitle("Powodzenie!");
            alertInfo.setHeaderText("Dodano rezerwacje, proszę czekać na zaakceptowanie!");
            alertInfo.showAndWait();

        }catch (Exception e){
            System.err.println(e);
            alertErr.setTitle("Niepowodzenie!");
            alertErr.setHeaderText("Nie udało się dodać wizyty!");
            alertErr.showAndWait();
        }


    }

    public static List<String> Godziny(String Data, String DzienTygodnia, ModelZarezerwujWizyte Lekarze){

        List<String> Godziny = new LinkedList<>(Arrays.asList(
                "08:00", "08:20", "08:40",
                "09:00", "09:20", "09:40",
                "10:00", "10:20", "10:40",
                "11:00", "11:20", "11:40",
                "12:00", "12:20", "12:40",
                "13:00", "13:20", "13:40",
                "14:00", "14:20", "14:40",
                "15:00", "15:20", "15:40"));

        Connection con = Polaczenie.Connect();

        String GodzinaRozpoczecia = "";
        String GodzinaZakonczenia = "";

        int LekarzID = GetLekarzID(Lekarze);
        int DlugoscListy = Godziny.size();
        int GRIndex = 0;
        int GZIndex = 0;

        Boolean DzienWolny = false;

        try{
           ResultSet getGodzinyPracy = con.createStatement().executeQuery("SELECT Godzina_rozpoczecia, Godzina_zakonczenia FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = '" + DzienTygodnia + "'");

           if(getGodzinyPracy.next()){
               GodzinaRozpoczecia = getGodzinyPracy.getString(1);
               GodzinaZakonczenia = getGodzinyPracy.getString(2);
           }else{
               DzienWolny = true;
           }
        }catch(SQLException e){
            System.err.println(e);
        }

        for(int i = 0; i < DlugoscListy; i++){

            if(Godziny.get(i).equals(GodzinaRozpoczecia)){
                GRIndex = i;
            }
            if(Godziny.get(i).equals(GodzinaZakonczenia)){
                GZIndex = i;
            }
        }

        Godziny = Godziny.subList(GRIndex, GZIndex);
        DlugoscListy = Godziny.size();

        try{
            ResultSet getZajeteGodziny = con.createStatement().executeQuery("SELECT godzina FROM wizyty WHERE Lekarz_ID = " + LekarzID + " AND Data = '" + Data + "'");
            while(getZajeteGodziny.next()){
                for(int i = 0; i < DlugoscListy-1; i++){
                    System.out.println(i + " | " +Godziny.get(i).equals(getZajeteGodziny.getString(1)));
                    if(Godziny.get(i).equals(getZajeteGodziny.getString(1))){
                        System.out.println(Godziny.get(i));
                        Godziny.remove(i);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        if(Godziny.isEmpty()){
            if(DzienWolny) {
                Godziny.add("Lekarz nie pracuje tego dnia!");
            }else{
                Godziny.add("Brak wolnych godzin tego dnia!");
            }
        }

        System.out.println(Godziny);

        return Godziny;
    }

    public static int GetLekarzID(ModelZarezerwujWizyte Lekarze){
        int LekarzID = 0;
        String Imie = Lekarze.getImie();
        String Nazwisko = Lekarze.getNazwisko();
        String Email = Lekarze.getEmail();
        int Telefon = Lekarze.getTelefon();
        String Specjalizacja = Lekarze.getSpecjalizacja();

        Connection con = Polaczenie.Connect();

        try{
            ResultSet GetLekarzID = con.createStatement().executeQuery("SELECT Lekarz_ID FROM lekarze WHERE Imie = '" + Imie + "' AND Nazwisko = '" + Nazwisko + "' AND Email = '" + Email + "' AND Telefon = " + Telefon + " AND Specjalizacja = '" + Specjalizacja + "'");

            if(GetLekarzID.next()){
                LekarzID = GetLekarzID.getInt(1);
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return LekarzID;
    }
}
