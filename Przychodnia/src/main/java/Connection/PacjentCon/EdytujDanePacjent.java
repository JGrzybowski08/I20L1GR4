package Connection.PacjentCon;

import Controller.LogowanieController;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connection.Polaczenie;

/**
 * Klasa EdytujDanePacjent odpowiadająca za wyświetlanie pacjentowi okienka z jego danymi i umożliwiająca modyfikowanie ich.
 */

public class EdytujDanePacjent {

    /**
     * Metoda EdytujDane - metoda zczytująca dane i podmieniające je, jeżeli są poprawne.
     * @param Imie
     * @param Nazwisko
     * @param Pesel
     * @param Telefon
     * @param Miejscowosc
     * @param KodPocztowy
     * @param Ulica
     * @param NumerDomu
     * @param Haslo
     * @return true jeżeli dane są poprawne, w przeciwnym wypadku false
     * @throws SQLException
     */

    public static boolean EdytujDane(String Imie, String Nazwisko, String Pesel, String Telefon, String Miejscowosc, String KodPocztowy, String Ulica, String NumerDomu, String Haslo) throws SQLException {
        Connection con = Polaczenie.Connect();

        Alert alertBlad = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        ResultSet spAdres;
        ResultSet spPacjenta;

        int PacjentID = LogowanieController.getKonto_ID();
        Boolean WysBlad = false;
        int AdresID = 0;

        try {
            spAdres = con.createStatement().executeQuery("SELECT Adres_ID FROM Adresy WHERE Kod_Pocztowy = '" + KodPocztowy + "' AND Ulica = '" + Ulica + "' AND Nr_Domu = '" + NumerDomu +"'");
            if(spAdres.next()){
                AdresID =  spAdres.getInt(1);
            }else{
                PreparedStatement DodajAdres = con.prepareStatement("INSERT into Adresy values(NULL, ?, ?, ?, ?)");
                DodajAdres.setString(1, Ulica);
                DodajAdres.setString(2, NumerDomu);
                DodajAdres.setString(3, KodPocztowy);
                DodajAdres.setString(4, Miejscowosc);
                DodajAdres.execute();

                spAdres = con.createStatement().executeQuery("SELECT Adres_ID FROM Adresy WHERE Kod_Pocztowy = '" + KodPocztowy + "' AND Ulica = '" + Ulica + "' AND Nr_Domu = '" + NumerDomu +"'");
                while(spAdres.next()) {
                    AdresID = spAdres.getInt(1);
                }
            }

            Long OldPesel = Long.valueOf(1);
            int Login = 0;
            ResultSet spPesel = con.createStatement().executeQuery("SELECT PESEL, Login FROM pacjenci WHERE Pacjent_ID = " + PacjentID);
            while(spPesel.next()) {
                OldPesel = spPesel.getLong(1);
                Login = spPesel.getInt(2);
            }

            spPacjenta = con.createStatement().executeQuery("SELECT * FROM pacjenci WHERE PESEL = " + Pesel);
            if(spPacjenta.next() && OldPesel != Long.parseLong(Pesel)) {
                alertBlad.setTitle("Błąd przy edycji danych pacjenta!");
                alertBlad.setHeaderText("Pacjent o takim PESELU istnieje już w bazie!");
                alertBlad.showAndWait();
                WysBlad = true;
            }else{



                PreparedStatement stt = con.prepareStatement("UPDATE pacjenci SET Imie = ?, Nazwisko = ?, PESEL = ?, Telefon = ?, Adres_ID = ? WHERE Pacjent_ID = " + PacjentID);
                stt.setString(1, Imie);
                stt.setString(2, Nazwisko);
                stt.setLong(3, Long.parseLong(Pesel));
                stt.setInt(4, Integer.parseInt(Telefon));
                stt.setInt(5, AdresID);
                stt.executeUpdate();

                PreparedStatement EdytujHaslo = con.prepareStatement("UPDATE konta SET Haslo = ? WHERE Login = " + Login);
                EdytujHaslo.setString(1, Haslo);
                EdytujHaslo.executeUpdate();
            }

            con.close();

        }catch (SQLException e) {
            //throw new RegisterException(e);
            System.err.println(e);
        } /*finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }*/
        if (!WysBlad) {

            alertInfo.setTitle("Zakończono!");
            alertInfo.setHeaderText("Pomyślnie edytowano dane!");
            alertInfo.showAndWait();
            return true;
        }else{
            return false;
        }
    }

    /**
     * Metoda PobierzDanePacjent - pobiera dane pacjenta i umieszcza w liście
     * @return DanePacjenta
     */

    public static List<String> PobierzDanePacjent(){

        /**
         * @param PacjentID
         * @param DanePacjenta - lista przechowująca informacje o pacjencie
         */

        int PacjentID = LogowanieController.getKonto_ID();
        List<String> DanePacjenta = new ArrayList<>();

        Connection con = Polaczenie.Connect();
        try {


            /**
             * @param PDPacjenta - zapytanie sql wyciąające z bazy danych informacje o danych pacjenta
             */

            ResultSet PDPacjenta = con.createStatement().executeQuery("SELECT pacjenci.Imie, pacjenci.Nazwisko, pacjenci.PESEL, pacjenci.Telefon, adresy.Kod_Pocztowy, adresy.Miejscowosc, adresy.Ulica, adresy.Nr_domu, konta.Haslo FROM pacjenci, adresy, konta WHERE pacjenci.Adres_ID = adresy.Adres_ID AND pacjenci.Login = konta.Login AND pacjenci.Pacjent_ID = " + PacjentID);

            while(PDPacjenta.next()){

                /**
                 * DanePacjenta.add funkcja dodająca dane wyciągnięte za pomocą zapytania SQL do listy DanePacjenta.
                 */

                DanePacjenta.add(PDPacjenta.getString(1));//Imie
                DanePacjenta.add(PDPacjenta.getString(2));//Nazwisko
                DanePacjenta.add(String.valueOf(PDPacjenta.getLong(3)));//PESEL
                DanePacjenta.add(String.valueOf(PDPacjenta.getInt(4)));//Telefon
                DanePacjenta.add(PDPacjenta.getString(5));//Kod_Pocztowy
                DanePacjenta.add(PDPacjenta.getString(6));//Miejscowosc
                DanePacjenta.add(PDPacjenta.getString(7));//Ulica
                DanePacjenta.add(PDPacjenta.getString(8));//Numer_Domu
                DanePacjenta.add(PDPacjenta.getString(9));//Haslo

            }

        }catch(Exception e){
            System.err.println(e);
        }
        return DanePacjenta;
    }
}
