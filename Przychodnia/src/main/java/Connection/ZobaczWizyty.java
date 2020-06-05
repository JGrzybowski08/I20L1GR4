package Connection;

import Models.ModelSpisWizyt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ZobaczWizyty {
    public static ObservableList<ModelSpisWizyt> ZobaczWizytyGet() {
        ObservableList<ModelSpisWizyt> oblist = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT w.Data, w.Godzina, l.Imie, p.Imie, w.Opis, w.Status FROM  wizyty w, lekarze l, pacjenci p WHERE p.Pacjent_ID= w.Pacjent_ID AND l.Lekarz_ID = w.Lekarz_ID"
            );

            while (rs.next()) {
                oblist.add(new ModelSpisWizyt(
                        rs.getString("Data"),
                        rs.getString("Godzina"),
                        rs.getString("Lekarz"),
                        rs.getString("Pacjent"),
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
