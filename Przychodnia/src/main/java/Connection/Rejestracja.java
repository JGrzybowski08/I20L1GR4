package Connection;

import Exceptions.RegisterException;
import javafx.scene.control.Alert;

import java.math.BigInteger;
import java.sql.*;
import java.util.Random;

public class Rejestracja {


    public static void Rejestrowanie(String Imie, String Nazwisko, String Email, String Pesel, String Telefon, String Haslo) throws RegisterException {

        Connection con = Polaczenie.Connect();

        try {

            PreparedStatement stt = con.prepareStatement("insert into pacjenci values (NULL, ?, ?, ?, ?, '200', ?, ?)");
            stt.setString(1, Imie);
            stt.setString(2, Nazwisko);
            stt.setString(3, Telefon);
            stt.setString(4, Pesel);
            stt.setString(5, Email);
            stt.execute();

            PreparedStatement stt2 = con.prepareStatement("insert into konta values (?, ?, '0', '0', '1')");
            stt2.setString(1, Pesel);
            stt2.setString(2, Haslo);
            stt2.execute();


            System.out.println("Pacjent dodany");


            con.close();

        }catch (Exception e) {
            throw new RegisterException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }



    }


    public static boolean DodajLekarza(String Imie, String Nazwisko, String Email, String Pesel, String Telefon, String Specjalizacja, String Haslo, String Miejscowosc, String KodPocztowy, String Ulica, String NumerDomu) throws SQLException {
        Connection con = Polaczenie.Connect();

        Alert alertBlad = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

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

            spLekarza = con.createStatement().executeQuery("SELECT * FROM lekarze WHERE PESEL = " + Pesel);
            if(spLekarza.next()) {
                alertBlad.setTitle("Błąd przy rejestracji lekarza!");
                alertBlad.setHeaderText("Lekarz o takim PESELU istnieje już w bazie!");
                alertBlad.showAndWait();
                WysBlad = true;
            }else{
                PreparedStatement stt = con.prepareStatement("insert into lekarze values (NULL, ?, ?, ?, ?, ?, ?, ?, ?)");
                stt.setString(1, Imie);
                stt.setString(2, Nazwisko);
                stt.setString(3, Email);
                stt.setLong(4, Long.parseLong(Pesel));
                stt.setInt(5, Integer.parseInt(Telefon));
                stt.setString(6, Specjalizacja);
                stt.setInt(7, AdresID);
                stt.setInt(8, Integer.parseInt(Login));
                stt.execute();
            }



            PreparedStatement stt2 = con.prepareStatement("insert into konta values (?, ?, 0, 1, 0)");
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
            alertInfo.setHeaderText("Pomyślnie zarejstrowano lekarza!");
            alertBlad.setContentText("Login: "+ Login + ", hasło: "+ Haslo);
            alertInfo.showAndWait();
            return true;
        }else{
            return false;
        }
    }
}
