package Connection;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;

public class CzyszczenieBazy {
    public static void Wyczysc(){
        Connection con = Polaczenie.Connect();
        try {
            ScriptRunner runner = new ScriptRunner(con);
            InputStreamReader reader = new InputStreamReader(new FileInputStream("src/main/java/Scripts/Czyszczenie.sql"));
            runner.runScript(reader);
            reader.close();
            con.close();
        } catch(Exception e){
            System.err.println(e);

        }
    }
}
