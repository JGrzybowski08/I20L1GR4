package Connection.AdministratorCon;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import Connection.Polaczenie;

/**
 * Klasa WypelnianieBazy, odpowiedzialna za dodawanie rekordów do bazy.
 */

public class WypelnianieBazy {

    /**
     * Metoda Wypelnij, wywołująca skrypt dodający rekordy do bazy.
     *
     */

    public static void Wypelnij() {

        /**
         * @param con umożliwiający połączenie się z bazą danych.
         */

        Connection con = Polaczenie.Connect();
        try {

            /**
             * @param runner
             * @param reader
             */

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
