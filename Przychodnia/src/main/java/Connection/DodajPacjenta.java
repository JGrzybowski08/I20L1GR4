package Connection;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import Connection.Polaczenie;

/**
 * Klasa DodajPacjenta odpowiadająca za rejestrowanie pacjenta i dodawanie go do bazy danych.
 */

public class DodajPacjenta {

    /**
     * Metoda Rejestruj zczytująca dane wprowadzone przez pacjenta i dodająca go do bazy danych.
     * @param Imie
     * @param Nazwisko
     * @param Pesel
     * @param Telefon
     * @param Haslo
     * @param Miejscowosc
     * @param KodPocztowy
     * @param Ulica
     * @param NumerDomu
     * @return true jeżeli wszystkie dane są poprawnie uzupełnione, w przeciwnym wypadku false.
     * @throws SQLException
     */

    public static boolean Rejestruj(String Imie, String Nazwisko, String Pesel, String Telefon, String Haslo, String Miejscowosc, String KodPocztowy, String Ulica, String NumerDomu) throws SQLException {

        /**
         * @param con - umożliwia połączenie się z bazą danych
         * @param alertBlad - alert jeżeli dane są niepełne lub niepoprawne
         * @param alertInfo - informacja które dane są niepoprawne
         */

        Connection con = Polaczenie.Connect();

        Alert alertBlad = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        /**
         * @param Login
         * @param generator
         */

        String Login = "";
        Random generator = new Random();
        ResultSet spLogin;
        ResultSet spAdres;
        ResultSet spLekarza;

        Boolean WysBlad = false;
        int AdresID = 0;
        do {
            for (int i = 0; i <= 5; i++) {

                Login = Login + Pesel.charAt(generator.nextInt(11));
            }

            spLogin = con.createStatement().executeQuery("Select * from Konta where Login = " + Integer.parseInt(Login));

        }while(spLogin.next());

        System.out.println("Login: " + Login);

        try {
            spAdres = con.createStatement().executeQuery("SELECT Adres_ID FROM Adresy WHERE Kod_Pocztowy = '" + KodPocztowy + "' AND Ulica = '" + Ulica + "' AND Nr_Domu = '" + NumerDomu +"'");
            if(spAdres.next()){
                AdresID =  spAdres.getInt(1);
            }else{
                PreparedStatement DodajAdres = con.prepareStatement("INSERT into Adresy values(NULL, ?, ?, ?, ?)");
                DodajAdres.setString(1, Ulica);
                DodajAdres.setString(2, NumerDomu);
                DodajAdres.setString(3, KodPocztowy);
                DodajAdres.setString(4, Miejscowosc);
                DodajAdres.execute();

                spAdres = con.createStatement().executeQuery("SELECT Adres_ID FROM Adresy WHERE Kod_Pocztowy = '" + KodPocztowy + "' AND Ulica = '" + Ulica + "' AND Nr_Domu = '" + NumerDomu +"'");
                while(spAdres.next()) {
                    AdresID = spAdres.getInt(1);
                }
            }

            spLekarza = con.createStatement().executeQuery("SELECT * FROM pacjenci WHERE PESEL = " + Pesel);
            if(spLekarza.next()) {
                alertBlad.setTitle("Błąd przy rejestracji!");
                alertBlad.setHeaderText("Pacjent o takim PESELU istnieje już w bazie!");
                alertBlad.showAndWait();
                WysBlad = true;
            }else{
                PreparedStatement stt = con.prepareStatement("insert into pacjenci values (NULL, ?, ?, ?, ?, ?, ?)");
                stt.setString(1, Imie);
                stt.setString(2, Nazwisko);
                stt.setLong(3, Long.parseLong(Pesel));
                stt.setInt(4, Integer.parseInt(Telefon));
                stt.setInt(5, AdresID);
                stt.setInt(6, Integer.parseInt(Login));
                stt.execute();
            }



            PreparedStatement stt2 = con.prepareStatement("insert into konta values (?, ?, 0, 0, 1)");
            stt2.setInt(1, Integer.parseInt(Login));
            stt2.setString(2, Haslo);
            stt2.execute();



            con.close();

        }catch (Exception e) {
            //throw new RegisterException(e);
            System.err.println(e);
        } /*finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/

        if (!WysBlad) {

            alertInfo.setTitle("Zakończono!");
            alertInfo.setHeaderText("Pomyślnie zarejstrowano!");
            alertInfo.setContentText("Login: "+ Login + ", hasło: "+ Haslo);
            alertInfo.showAndWait();
            return true;
        }else{
            return false;
        }
    }
}
