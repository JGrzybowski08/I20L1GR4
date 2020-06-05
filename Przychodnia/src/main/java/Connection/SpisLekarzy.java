package Connection;

import Models.ModelSpisLekarzy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SpisLekarzy {
    public static ObservableList<ModelSpisLekarzy> WszyscyLekarzeGet() {
        ObservableList<ModelSpisLekarzy> SpisLekarzyOL = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT lekarze.Imie, lekarze.Nazwisko, lekarze.Email, lekarze.PESEL, lekarze.Telefon, lekarze.Specjalizacja, adresy.Kod_Pocztowy, adresy.Miejscowosc, adresy.Ulica, adresy.Nr_domu FROM lekarze, adresy WHERE lekarze.Adres_ID = adresy.Adres_ID"
            );

            while (rs.next()) {
                SpisLekarzyOL.add(new ModelSpisLekarzy(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SpisLekarzyOL;
    }

    public static ObservableList<ModelSpisLekarzy> FiltrowaniLekarzeGet(String filtrCB, String filtrTF) {
        ObservableList<ModelSpisLekarzy> SpisLekarzyOL = FXCollections.observableArrayList();
        switch (filtrCB){
            case "Kod pocztowy":
                filtrCB = "Kod_Pocztowy";
                break;
            case "Numer domu":
                filtrCB = "Nr_domu";
                break;
            case "Miejscowość":
                filtrCB = "Miejscowosc";
                break;
        }
        System.out.println(filtrCB);
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT lekarze.Imie, lekarze.Nazwisko, lekarze.Email, lekarze.PESEL, lekarze.Telefon, lekarze.Specjalizacja, adresy.Kod_Pocztowy, adresy.Miejscowosc, adresy.Ulica, adresy.Nr_domu FROM lekarze, adresy WHERE lekarze.Adres_ID = adresy.Adres_ID AND " + filtrCB + " = '" + filtrTF +"'"
            );

            while (rs.next()) {
                SpisLekarzyOL.add(new ModelSpisLekarzy(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SpisLekarzyOL;
    }
}
