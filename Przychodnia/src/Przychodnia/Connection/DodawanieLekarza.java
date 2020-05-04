package Przychodnia.Connection;

import java.sql.*;



public class DodawanieLekarza {
    public static void Dodawanie(String id, String spec) {

        Connection con = Polaczenie.Connect();

        try {

            String sql = "select Imie, Nazwisko, PESEL, Telefon, Adres_ID, Login from pacjenci WHERE Pacjent_ID = "+id;
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);

            while (rs.next()){

                String imie = rs.getString(1);
                String nazwisko = rs.getString(2);
                String pesel = rs.getString(3);
                int telefon = rs.getInt(4);
                int adres_id = rs.getInt(5);
                String login = rs.getString(6);

                PreparedStatement stt = con.prepareStatement("insert into Lekarze values (NULL, ?, ?, ?, ?, ?, ?, ?)");
                stt.setString(1, imie);
                stt.setString(2, nazwisko);
                stt.setString(3, pesel);
                stt.setInt(4, telefon);
                stt.setString(5, spec);
                stt.setInt(6, adres_id);
                stt.setString(7, login);
                stt.execute();

                Statement delete = con.createStatement();
                String sql3 = "delete from Pacjenci WHERE Pacjent_ID = "+id;
                delete.execute(sql3);

                Statement update = con.createStatement();
                String sql4 = "update konta set Lekarz = '1', Pacjent = '0' where Login = "+login;
                update.execute(sql4);

                System.out.println("Lekarz dodany");

            }



            con.close();

        } catch (Exception e) {
            System.err.println(e);

        }
    }
}
