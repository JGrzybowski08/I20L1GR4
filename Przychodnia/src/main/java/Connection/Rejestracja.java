package Connection;

import Exceptions.RegisterException;

import java.sql.*;

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


    public static void DodajLekarza(String Imie, String Nazwisko, String Email, String Pesel, String Telefon, String Specjalizacja, String Haslo) throws RegisterException {

        Connection con = Polaczenie.Connect();

        try {

            PreparedStatement stt = con.prepareStatement("insert into lekarze values (NULL, ?, ?, ?, ?, '200', ?, ?)");
            stt.setString(1, Imie);
            stt.setString(2, Nazwisko);
            stt.setString(3, Telefon);
            stt.setString(4, Specjalizacja);
            stt.setString(5, Pesel);
            stt.setString(6, Email);
            stt.execute();

            PreparedStatement stt2 = con.prepareStatement("insert into konta values (?, ?, '0', '1', '0')");
            stt2.setString(1, Pesel);
            stt2.setString(2, Haslo);
            stt2.execute();


            System.out.println("Lekarz dodany");


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
}
