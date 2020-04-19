package Przychodnia.Connection;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class CzyszczenieBazy {
    public static void Wyczysc() {
        Connection con = Polaczenie.Connect();
        String script = "/Przychodnia//Scripts//Czyszczenie.sql";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            new ScriptRunner(Polaczenie.Connect()).runScript(new BufferedReader(new FileReader(script)));
            //new ScriptRunner(DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root`")).runScript(new BufferedReader(new FileReader(script)));
        } catch(Exception e){
            System.err.println(e);
        }
    }
}
