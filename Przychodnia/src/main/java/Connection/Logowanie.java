package Connection;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.Connection;
import java.sql.ResultSet;

public class Logowanie {

    static int pacjent_ID_Get;
    static String uprawnienia_Get;
    static String ImieNazwisko;

    public static int IdGet(int Login, String Haslo){
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT pacjenci.pacjent_id " +
                    "FROM pacjenci, konta " +
                     "WHERE (pacjenci.login = konta.login AND konta.login = "+ Login + " AND konta.haslo = '" + Haslo +"')"
            );
            while(rs.next()) {
                pacjent_ID_Get = rs.getInt(1);
            }
            rs.close();
            con.close();
        }catch(Exception e){
            System.err.println(e);
        }
    return pacjent_ID_Get;
    }

    public static String UprawnieniaGet(int Login, String Haslo){
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery("SELECT Administrator, Lekarz, Pacjent " +
                    "FROM Konta " +
                    "WHERE (Konta.Login = " + Login + " AND konta.haslo = '" + Haslo +"')"
            );
            while(rs.next()){
                if(rs.getInt(1) == 1){
                    uprawnienia_Get = "Administrator";
                    break;
                }
                if(rs.getInt(2) == 1){
                    uprawnienia_Get = "Lekarz";
                    break;
                }
                if(rs.getInt(3) == 1){
                    uprawnienia_Get = "Pacjent";
                    break;
                }
            }
        }catch(Exception e){
            System.err.println(e);
        }
     return uprawnienia_Get;
    }

    public static String ImieNazwiskopacjentGet(int idp){
        try{
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery("SELECT Imie, Nazwisko FROM pacjenci WHERE Pacjent_ID = " + idp);
            while(rs.next()){
               ImieNazwisko =  rs.getString(1) + " " + rs.getString(2);
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return ImieNazwisko;
    }

    public static String ImieNazwiskoLekarzGet(int idl){
        System.out.print("Testtowo: " + idl);
        try{
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery("SELECT Imie, Nazwisko FROM lekarze WHERE Lekarz_ID = " + idl);
            while(rs.next()){
                ImieNazwisko =  rs.getString(1) + " " + rs.getString(2);
            }
        }catch(Exception e){
            System.err.println(e);
        }
        System.out.println(ImieNazwisko);
        return ImieNazwisko;
    }
}
