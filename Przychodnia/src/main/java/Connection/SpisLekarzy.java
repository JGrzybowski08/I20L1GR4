package Connection;

import Models.ModelZobaczLekarzy;
import Models.ModelZobaczWizyty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpisLekarzy {
    public static ObservableList<ModelZobaczLekarzy> WszyscyLekarzeGet() {
        ObservableList<ModelZobaczLekarzy> oblist = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT Imie,Nazwisko,Telefon,Specjalizacja,PESEL,e_mail " +
                            "FROM lekarze "
            );

            while (rs.next()) {
                oblist.add(new ModelZobaczLekarzy(
                        rs.getString("Imie"),
                        rs.getString("Nazwisko"),
                        rs.getString("Telefon"),
                        rs.getString("Specjalizacja"),
                        rs.getString("PESEL"),
                        rs.getString("e_mail")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oblist;
    }
}
