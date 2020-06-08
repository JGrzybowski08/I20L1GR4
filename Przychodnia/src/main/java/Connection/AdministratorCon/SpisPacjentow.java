package Connection.AdministratorCon;

import Models.ModelSpisPacjentow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.Polaczenie;

/**
 * Klasa SpisPacjentow obsługująca wyświetlanie tabeli z danymi wszystkich pacjentów.
 */

public class SpisPacjentow {

    /**
     * Metoda WszyscyPacjenciGet pobierająca dane pacjentów.
     * @return SpisPacjentowOL - lista wszystkich pacjentów
     */

    public static ObservableList<ModelSpisPacjentow> WszyscyPacjenciGet() {

        /**
         * @param SpisPacjentowOL przechowujący wszystkie informacje o pacjentach pobrane z bazy danych.
         */

        ObservableList<ModelSpisPacjentow> SpisPacjentowOL = FXCollections.observableArrayList();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT pacjenci.Imie, pacjenci.Nazwisko, pacjenci.PESEL, pacjenci.Telefon, adresy.Kod_Pocztowy, adresy.Miejscowosc, adresy.Ulica, adresy.Nr_domu FROM pacjenci, adresy WHERE pacjenci.Adres_ID = adresy.Adres_ID"
            );

            while (rs.next()) {

                /**
                 * SpisPacjentowOL.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy SpisPacjentowOL.
                 */

                SpisPacjentowOL.add(new ModelSpisPacjentow(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SpisPacjentowOL;
    }

    /**
     * Metoda FiltrowaniePacjenciGet odpowiadająca za działanie filtrów w liśćie pacjentów.
     * @param filtrCB
     * @param filtrTF
     * @return SpisPacjentowOL - lista z wybranymi filtrami.
     */

    public static ObservableList<ModelSpisPacjentow> FiltrowaniPacjenciGet(String filtrCB, String filtrTF) {
        ObservableList<ModelSpisPacjentow> SpisPacjentowOL = FXCollections.observableArrayList();
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
                    "SELECT pacjenci.Imie, pacjenci.Nazwisko, pacjenci.PESEL, pacjenci.Telefon, adresy.Kod_Pocztowy, adresy.Miejscowosc, adresy.Ulica, adresy.Nr_domu FROM pacjenci, adresy WHERE pacjenci.Adres_ID = adresy.Adres_ID AND " + filtrCB + " = '" + filtrTF +"'"
            );

            while (rs.next()) {

                /**
                 * SpisPacjentowOL.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy SpisPacjentowOL.
                 */

                SpisPacjentowOL.add(new ModelSpisPacjentow(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getLong(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return SpisPacjentowOL;
    }
}
