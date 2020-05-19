package Przychodnia.Connection;

import Przychodnia.Models.ModelZobaczWizyty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZobaczWizyty {






    public static ObservableList<ModelZobaczWizyty> WizytyGet(int ID) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date czasSys = new Date(System.currentTimeMillis());



        ObservableList<ModelZobaczWizyty> oblist = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT wizyta_ID, data, godzina, lekarze.imie, lekarze.nazwisko, opis, status " +
                            "FROM wizyty, lekarze " +
                            "WHERE (wizyty.Lekarz_ID = Lekarze.Lekarz_ID AND Pacjent_ID = "+ID+" AND data >= '" + formatter.format(czasSys) + "') GROUP BY wizyta_ID"
            );

            while (rs.next()) {
                oblist.add(new ModelZobaczWizyty(
                        rs.getString("Data"),
                        rs.getString("Godzina"),
                        rs.getString("lekarze.imie") + rs.getString("lekarze.nazwisko"),
                        rs.getString("Opis"),
                        rs.getString("Status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oblist;
    }
}
