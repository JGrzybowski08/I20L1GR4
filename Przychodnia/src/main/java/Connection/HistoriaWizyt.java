package Connection;

import Models.ModelSpisWizyt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Klasa HistoriaWizyt umożliwiająca wyświetlanie listy przeszłych wizyt.
 */

public class HistoriaWizyt {

    /**
     * Metoda ZobaczWizytyGet pobierająca dane przeszłych wizyt
     * @return oblist
     */

    public static ObservableList<ModelSpisWizyt> ZobaczWizytyGet() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date czasSys = new Date(System.currentTimeMillis());

        /**
         * @param oblist przechowujący informacje o przeszłych wizytach pobranych z bazy danych.
         */

        ObservableList<ModelSpisWizyt> oblist = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT wizyta_ID, data, godzina, lekarze.imie, lekarze.nazwisko, opis, status " +
                            "FROM wizyty, lekarze " +
                            "WHERE (wizyty.Lekarz_ID = Lekarze.Lekarz_ID AND wizyty.Pacjent_ID=  AND data <= '" + formatter.format(czasSys) + "') GROUP BY wizyta_ID"
            );

            while (rs.next()) {

                /**
                 * oblist.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy oblist.
                 */

                oblist.add(new ModelSpisWizyt(
                        rs.getString("Data"),
                        rs.getString("Godzina"),
                        rs.getString("lekarze.imie") + rs.getString("lekarze.nazwisko"),
                        rs.getString("pacjenci.imie") + rs.getString("pacjenci.nazwisko"),
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
