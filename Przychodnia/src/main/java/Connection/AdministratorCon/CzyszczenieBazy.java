package Connection.AdministratorCon;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;

import Connection.Polaczenie;

/**
 * Klasa CzyszczenieBazy, odpowiedzialna za usuwanie rekordów z bazy.
 */

public class CzyszczenieBazy {

    /**
     * Metoda Wyczysc, wywołująca skrypt usuwający wszystkie rekordy z bazy, oprócz rekordu zawierającego konto administratora.
     *
     */

    public static void Wyczysc(){

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
            InputStreamReader reader = new InputStreamReader(new FileInputStream("src/main/java/Scripts/Czyszczenie.sql"));
            runner.runScript(reader);
            reader.close();
            con.close();
        } catch(Exception e){
            System.err.println(e);

        }
    }
}
