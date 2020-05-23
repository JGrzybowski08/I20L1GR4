package Connection;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;

public class WypelnianieBazy {
    public static void Wypelnij() {
        Connection con = Polaczenie.Connect();
        try {
            ScriptRunner runner = new ScriptRunner(con);
            InputStreamReader reader = new InputStreamReader(new FileInputStream("src/main/java/Scripts/Wypelnianie.sql"));
            runner.runScript(reader);
            reader.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);

        }
    }
}
