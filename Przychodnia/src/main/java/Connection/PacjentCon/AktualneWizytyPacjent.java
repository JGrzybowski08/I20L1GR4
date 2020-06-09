package Connection.PacjentCon;

import Controller.LogowanieController;
import Models.ModelAktualneWizytyPacjent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Connection.Polaczenie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AktualneWizytyPacjent {

    /**
     * Metoda WszystkieWizytyGet pobierające dane odpowiednich wizyt.
     * @param PacjentID przechowuje ID pacjenta
     * @return SpisWizytOL
     */

    public static ObservableList<ModelAktualneWizytyPacjent> WszystkieWizytyGet(int PacjentID) {

        /**
         * @param SpisWizytOL przechowujący wszystkie informacje o wizytach pobrane z bazy danych.
         */

        ObservableList<ModelAktualneWizytyPacjent> SpisWizytOL = FXCollections.observableArrayList();

        /**
         * @param dtf
         * @param now
         */

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        try{
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Pacjent_ID = "+ PacjentID +" AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND wizyty.Data >= '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC"
            );
            while (rs.next()) {

                /**
                 * SpisWizytOL.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy SpisWizytOL.
                 */

                SpisWizytOL.add(new ModelAktualneWizytyPacjent(
                        rs.getString(1), //Data
                        rs.getString(2), //Godzina
                        rs.getString(3), //Opis
                        rs.getString(4), //Status
                        rs.getString(5) + " " + rs.getString(6)
                ));
            }

        }catch(Exception e){
            System.err.println(e);
        }
        return SpisWizytOL;
    }

    /**
     * Metoda FiltrowaneWizytyGet odpowiadająca za działanie filtrów w liśćie wizyt.
     * @param FiltrCB
     * @param FiltrTF
     * @return SpisWizytOL - lista z wybranymi filtrami.
     */

    public static ObservableList<ModelAktualneWizytyPacjent> FiltrowaneWizytyGet(String FiltrCB, String FiltrTF, int PacjentID) {
        ObservableList<ModelAktualneWizytyPacjent> SpisWizytOL = FXCollections.observableArrayList();
        ResultSet FWG;
        String[] IiN;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Pacjent_ID = "+ PacjentID +" AND "+ FiltrCB +" = '"+ FiltrTF +"' AND wizyty.Lekarz_ID = lekarze.Lekarz_ID wizyty.Data >= '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";


        switch(FiltrCB){
            case "Lekarz":
                IiN = FiltrTF.split(" ");
                sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = "+ PacjentID +" AND lekarze.Imie = '"+ IiN[0] + "' AND lekarze.Nazwisko = '"+ IiN[1] +"' AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND wizyty.Data >= '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";
                break;
        }

        try{
            Connection con = Polaczenie.Connect();
            FWG = con.createStatement().executeQuery(sql);

            while (FWG.next()) {

                /**
                 * SpisWizytOL.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy SpisWizytOL.
                 */

                SpisWizytOL.add(new ModelAktualneWizytyPacjent(
                        FWG.getString(1), //Data
                        FWG.getString(2), //Godzina
                        FWG.getString(3), //Opis
                        FWG.getString(4), //Status
                        FWG.getString(7) + " " + FWG.getString(8)
                ));
            }

        }catch(Exception e){
            System.err.println(e);
        }
        return SpisWizytOL;
    }

    public static void OdwolajWizyte(String Data, String Godzina){
        int LekarzID = LogowanieController.getKonto_ID();
        int WizytaID = 0;
        Connection con = Polaczenie.Connect();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT Wizyta_ID FROM wizyty WHERE Data = '" + Data + "' AND Godzina = '" + Godzina + "' AND Lekarz_ID = " + LekarzID);
            while(rs.next()){
                WizytaID = rs.getInt(1);
            }

            PreparedStatement ZW = con.prepareStatement("UPDATE wizyty SET Status = ? WHERE Wizyta_ID = " + WizytaID);
            ZW.setString(1,"Odwołana");
            ZW.executeUpdate();
        }catch(SQLException e){
            System.err.println(e);
        }
    }


}
