package Connection.LekarzCon;

import Controller.LogowanieController;
import Models.ModelAktualneWizytyLekarz;
import Models.ModelSpisWizyt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Connection.Polaczenie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 * Klasa AktualneWizytyLekarz odpowiadająca za wyświetlanie zbliżających się wizyt w panelu lekarza.
 */

public class AktualneWizytyLekarz {

    /**
     * Metoda WszystkieWizytyGet pobierające dane odpowiednich wizyt.
     * @param LekarzID przechowuje ID lekarza
     * @return SpisWizytOL
     */

    public static ObservableList<ModelAktualneWizytyLekarz> WszystkieWizytyGet(int LekarzID) {

        /**
         * @param SpisWizytOL przechowujący wszystkie informacje o wizytach pobrane z bazy danych.
         */

        ObservableList<ModelAktualneWizytyLekarz> SpisWizytOL = FXCollections.observableArrayList();

        /**
         * @param dtf
         * @param now
         */

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        try{
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = "+ LekarzID +" AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND wizyty.Data >= '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC"
            );
            while (rs.next()) {

                /**
                 * SpisWizytOL.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy SpisWizytOL.
                 */

                SpisWizytOL.add(new ModelAktualneWizytyLekarz(
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

    public static ObservableList<ModelAktualneWizytyLekarz> FiltrowaneWizytyGet(String FiltrCB, String FiltrTF, int LekarzID) {
        ObservableList<ModelAktualneWizytyLekarz> SpisWizytOL = FXCollections.observableArrayList();
        ResultSet FWG;
        String[] IiN;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = "+ LekarzID +" AND "+ FiltrCB +" = '"+ FiltrTF +"' AND wizyty.Lekarz_ID = lekarze.Lekarz_ID wizyty.Data >= '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";


        switch(FiltrCB){
            case "Pacjent":
                IiN = FiltrTF.split(" ");
                sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = "+ LekarzID +" AND pacjenci.Imie = '"+ IiN[0] + "' AND pacjenci.Nazwisko = '"+ IiN[1] +"' AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND wizyty.Data >= '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";
                break;
        }

        try{
            Connection con = Polaczenie.Connect();
            FWG = con.createStatement().executeQuery(sql);

            while (FWG.next()) {

                /**
                 * SpisWizytOL.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy SpisWizytOL.
                 */

                SpisWizytOL.add(new ModelAktualneWizytyLekarz(
                        FWG.getString(1), //Data
                        FWG.getString(2), //Godzina
                        FWG.getString(3), //Opis
                        FWG.getString(4), //Status
                        FWG.getString(5) + " " + FWG.getString(6)
                ));
            }

        }catch(Exception e){
            System.err.println(e);
        }
        return SpisWizytOL;
    }

    public static void ZaakceptujWizyte(String Data, String Godzina){
        int LekarzID = LogowanieController.getKonto_ID();
        int WizytaID = 0;
        Connection con = Polaczenie.Connect();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT Wizyta_ID FROM wizyty WHERE Data = '" + Data + "' AND Godzina = '" + Godzina + "' AND Lekarz_ID = " + LekarzID);
            while(rs.next()){
                WizytaID = rs.getInt(1);
            }

            PreparedStatement ZW = con.prepareStatement("UPDATE wizyty SET Status = ? WHERE Wizyta_ID = " + WizytaID);
            ZW.setString(1,"Zaakceptowana");
            ZW.executeUpdate();
        }catch(SQLException e){
            System.err.println(e);
        }
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

    public static void ZakonczWizyte(String Data, String Godzina){
        int LekarzID = LogowanieController.getKonto_ID();
        int WizytaID = 0;
        Connection con = Polaczenie.Connect();
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT Wizyta_ID FROM wizyty WHERE Data = '" + Data + "' AND Godzina = '" + Godzina + "' AND Lekarz_ID = " + LekarzID);
            while(rs.next()){
                WizytaID = rs.getInt(1);
            }

            PreparedStatement ZW = con.prepareStatement("UPDATE wizyty SET Status = ? WHERE Wizyta_ID = " + WizytaID);
            ZW.setString(1,"Zakończona");
            ZW.executeUpdate();
        }catch(SQLException e){
            System.err.println(e);
        }
    }
}
