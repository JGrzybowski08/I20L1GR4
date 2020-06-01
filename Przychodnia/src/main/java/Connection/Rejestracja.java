package Connection;

import java.sql.*;

public class Rejestracja {
    public static void Rejestrowanie(String Imie, String Nazwisko, String PESEL, String Telefon, String Login, String Haslo){

        Connection con = Polaczenie.Connect();

        try {

            PreparedStatement stt = con.prepareStatement("insert into pacjenci values (NULL, ?, ?, ?, ?, '200', ?)");
            stt.setString(1, Imie);
            stt.setString(2, Nazwisko);
            stt.setString(3, PESEL);
            stt.setString(4, Telefon);
            stt.setString(5, Login);
            stt.execute();

            PreparedStatement stt2 = con.prepareStatement("insert into konta values (?, ?, '0', '0', '1')");
            stt2.setString(1, Login);
            stt2.setString(2, Haslo);
            stt2.execute();


            System.out.println("Pacjent dodany");


            con.close();

        }catch (Exception e) {
            System.err.println(e);
        }



    }


}
