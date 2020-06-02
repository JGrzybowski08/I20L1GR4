package Connection;
import java.sql.*;

public class Polaczenie {

    public static Connection Connect() {
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting database...");
//            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia?useUnicode=true&characterEncoding=utf8","root", "");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/przychodnia?useUnicode=yes&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
            System.out.println("Database connected!");

            //Statement stmt=con.createStatement();
           // ResultSet rs=stmt.executeQuery("select * from konta");
           // while(rs.next())
             //   System.out.println(rs.getInt(1)+"  "+rs.getString(2));
           // con.close();

            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
