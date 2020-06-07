package Connection.AdministratorCon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import PdfGenerator.Generator;
import Connection.Polaczenie;


public class GenerujRaport {
    public static final String FONT = "Amble-Bold.ttf";
    public static void generujRaportWizyt() {
        List<String> ListaWizyt = new ArrayList<>();

        try{
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT pacjenci.imie, pacjenci.nazwisko, lekarze.imie, lekarze.nazwisko, wizyty.data, wizyty.godzina, wizyty.opis, wizyty.status FROM pacjenci, lekarze, wizyty WHERE pacjenci.Pacjent_ID = wizyty.Pacjent_ID AND lekarze.Lekarz_ID = wizyty.Lekarz_ID ORDER BY wizyty.data");
            while(rs.next()){
                ListaWizyt.add(
                                rs.getString(1) + ";" +
                                rs.getString(2) + ";" +
                                rs.getString(3) + ";" +
                                rs.getString(4) + ";" +
                                rs.getString(5) + ";" +
                                rs.getString(6) + ";" +
                                rs.getString(7) + ";" +
                                rs.getString(8)
                );
            }
        }catch (Exception e){
            System.err.println(e);
        }
        try {
            Generator.Generuj(ListaWizyt);
        }catch(Exception e){
            System.err.println("Tutaj:"+e);
        }
        System.out.println(ListaWizyt);

}
}
