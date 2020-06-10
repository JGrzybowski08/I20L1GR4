package Connection.LekarzCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

import Connection.Polaczenie;
import Controller.LogowanieController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Klasa GodzinyPracy odpowiadająca za wszelkie operacje z godzinami pracy lekarzy
 */

public class GodzinyPracy {

    /**
     * Metoda DodajGodzinyPracy - metoda obsługująca dodawanie nowych godzin pracy dla lekarza
     * @param godzinaRPI - godzina rozpoczęcia nowa
     * @param godzinaZPI - godzina zakończenia nowa
     * @param godzinaRP - godzina rozpoczęcia
     * @param godzinaZP - godzina zakończenia
     * @param dzienTygodznia - dzień tygodnia
     */

    public static void DodajGodzinyPracy(int godzinaRPI, int godzinaZPI, String godzinaRP, String godzinaZP, String dzienTygodznia) {

        /**
         * @param LekarzID
         * @param alertBlad
         * @param alertInfo
         * @param alertConfirm
         * @param WysGP
         * @param GodzinaID
         */

        int LekarzID = LogowanieController.getKonto_ID();
        Alert alertBlad = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION);
        Boolean WysGP = false;
        int GodzinaID = 0;

        Connection con = Polaczenie.Connect();
        try {
            ResultSet SGP = con.createStatement().executeQuery("SELECT Godzina_ID FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = '" + dzienTygodznia + "'");
            if (SGP.next()) {
                WysGP = true;
                GodzinaID = SGP.getInt(1);
            } else {
                WysGP = false;
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        if (WysGP) {
            alertConfirm.setTitle("Edycja godzin pracy.");
            alertConfirm.setHeaderText("Wykryto godziny pracy dla: " + dzienTygodznia + "!");
            alertConfirm.setContentText("Czy chcesz zmienić godziny pracy dla: " + dzienTygodznia + "?");

            Optional<ButtonType> result = alertConfirm.showAndWait();

            if (result.get() == ButtonType.OK) {
                if (godzinaZPI >= godzinaRPI) {
                    try {
                        PreparedStatement DGP = con.prepareStatement("update godziny set Dzien_tygodnia = '"+ dzienTygodznia +"', Godzina_rozpoczecia = '" + godzinaRP + "', Godzina_zakonczenia = '" + godzinaZP + "' WHERE Godzina_ID = " + GodzinaID);
                        DGP.execute();
                        alertInfo.setTitle("Zakończono pomyślnie");
                        alertInfo.setHeaderText("Edytowano godziny pracy dla: " + dzienTygodznia + ", godzina rozpoczęcia: " + godzinaRP + ", godzina zakończenia: " + godzinaZP);
                        alertInfo.showAndWait();


                    } catch (Exception e) {
                        System.err.println(e);
                    }
                } else {
                    alertBlad.setTitle("Błąd przy edytowaniu godzin pracy!");
                    alertBlad.setHeaderText("Godzina zakończenia nie może być wcześniejsza niż godzina rozpoczęcia!");
                    alertBlad.showAndWait();
                }

            } else {
                alertConfirm.close();
            }
        }else{
            if (godzinaZPI >= godzinaRPI) {
                try {
                    PreparedStatement DGP = con.prepareStatement("insert into godziny values (NULL, ?, ?, ?, ?)");
                    DGP.setInt(1, LekarzID);
                    DGP.setString(2, dzienTygodznia);
                    DGP.setString(3, godzinaRP);
                    DGP.setString(4, godzinaZP);
                    DGP.execute();
                    alertInfo.setTitle("Zakończono pomyślnie");
                    alertInfo.setHeaderText("Dodano godziny pracy dla: " + dzienTygodznia + ", godzina rozpoczęcia: " + godzinaRP + ", godzina zakończenia: " + godzinaZP);
                    alertInfo.showAndWait();


                } catch (Exception e) {
                    System.err.println(e);
                }
            } else {
                alertBlad.setTitle("Błąd przy dodawaniu godzin pracy!");
                alertBlad.setHeaderText("Godzina zakończenia nie może być wcześniejsza niż godzina rozpoczęcia!");
                alertBlad.showAndWait();
            }
        }
    }

    public static String WysGPPon(){
        String PonGP = "";
        int LekarzID = LogowanieController.getKonto_ID();

        Connection con = Polaczenie.Connect();

        try {
            ResultSet SGP = con.createStatement().executeQuery("SELECT Godzina_rozpoczecia, Godzina_zakonczenia FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = 'Poniedziałek'");
            if (SGP.next()) {
                PonGP = SGP.getString(1) + " - " + SGP.getString(2);
            } else {
                PonGP = "Dzień wolny";
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return PonGP;
    }

    public static String WysGPWt(){
        String PonGP = "";
        int LekarzID = LogowanieController.getKonto_ID();

        Connection con = Polaczenie.Connect();

        try {
            ResultSet SGP = con.createStatement().executeQuery("SELECT Godzina_rozpoczecia, Godzina_zakonczenia FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = 'Wtorek'");
            if (SGP.next()) {
                PonGP = SGP.getString(1) + " - " + SGP.getString(2);
            } else {
                PonGP = "Dzień wolny";
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return PonGP;
    }

    public static String WysGPSr(){
        String PonGP = "";
        int LekarzID = LogowanieController.getKonto_ID();

        Connection con = Polaczenie.Connect();

        try {
            ResultSet SGP = con.createStatement().executeQuery("SELECT Godzina_rozpoczecia, Godzina_zakonczenia FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = 'Środa'");
            if (SGP.next()) {
                PonGP = SGP.getString(1) + " - " + SGP.getString(2);
            } else {
                PonGP = "Dzień wolny";
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return PonGP;
    }

    public static String WysGPCzw(){
        String PonGP = "";
        int LekarzID = LogowanieController.getKonto_ID();

        Connection con = Polaczenie.Connect();

        try {
            ResultSet SGP = con.createStatement().executeQuery("SELECT Godzina_rozpoczecia, Godzina_zakonczenia FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = 'Czwartek'");
            if (SGP.next()) {
                PonGP = SGP.getString(1) + " - " + SGP.getString(2);
            } else {
                PonGP = "Dzień wolny";
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return PonGP;
    }

    public static String WysGPPt(){
        String PonGP = "";
        int LekarzID = LogowanieController.getKonto_ID();

        Connection con = Polaczenie.Connect();

        try {
            ResultSet SGP = con.createStatement().executeQuery("SELECT Godzina_rozpoczecia, Godzina_zakonczenia FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = 'Piątek'");
            if (SGP.next()) {
                PonGP = SGP.getString(1) + " - " + SGP.getString(2);
            } else {
                PonGP = "Dzień wolny";
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return PonGP;
    }

    public static String WysGPSob(){
        String PonGP = "";
        int LekarzID = LogowanieController.getKonto_ID();

        Connection con = Polaczenie.Connect();

        try {
            ResultSet SGP = con.createStatement().executeQuery("SELECT Godzina_rozpoczecia, Godzina_zakonczenia FROM godziny WHERE Lekarz_ID = " + LekarzID + " AND Dzien_tygodnia = 'Sobota'");
            if (SGP.next()) {
                PonGP = SGP.getString(1) + " - " + SGP.getString(2);
            } else {
                PonGP = "Dzień wolny";
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return PonGP;
    }

    /**
     * Metoda SprawdzGodzinyPracy wyciągająca z bazy danych informacje o godzinach pracy lekarzy
     */

    public static void SprawdzGodzinyPracy(){
        int LekarzID = LogowanieController.getKonto_ID();
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
        Connection con = Polaczenie.Connect();

        try{
            ResultSet SGP = con.createStatement().executeQuery("SELECT * FROM godziny WHERE Lekarz_ID = " + LekarzID);
            if(!SGP.next()){
                alertInfo.setTitle("Proszę uzupełnić dane!");
                alertInfo.setHeaderText("Brak godzin pracy!");
                alertInfo.showAndWait();
            }
        }catch (Exception e){
            System.err.println(e);
        }
    }


}
