package Przychodnia.Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DodawanieLekarza {
    public static void Dodawanie(String id, String spec) {
        Connection con = Polaczenie.Connect();

        try {
            String sql2 = "insert into Lekarze values";
            String sql = "select * from pacjenci WHERE Pacjent_ID = "+id;
            Statement stt = con.createStatement();
            ResultSet rs=stt.executeQuery(sql);
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));



            con.close();
        } catch (Exception e) {
            System.err.println(e);

        }
    }
}
