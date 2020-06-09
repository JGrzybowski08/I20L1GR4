package Connection.LekarzCon;

import Controller.LogowanieController;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Connection.Polaczenie;

public class EdytujDaneLekarz {
    public static boolean EdytujDane(String Imie, String Nazwisko, String Email, String Pesel, String Telefon, String Specjalizacja, String Miejscowosc, String KodPocztowy, String Ulica, String NumerDomu, String Haslo) throws SQLException {
        Connection con = Polaczenie.Connect();

        Alert alertBlad = new Alert(Alert.AlertType.ERROR);
        Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);

        ResultSet spAdres;
        ResultSet spLekarza;

        int LekarzID = LogowanieController.getKonto_ID();
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
            ResultSet spPesel = con.createStatement().executeQuery("SELECT PESEL, Login FROM lekarze WHERE Lekarz_ID = " + LekarzID);
            while(spPesel.next()) {
                OldPesel = spPesel.getLong(1);
                Login = spPesel.getInt(2);
            }

            spLekarza = con.createStatement().executeQuery("SELECT * FROM lekarze WHERE PESEL = " + Pesel);
            if(spLekarza.next() && OldPesel != Long.parseLong(Pesel)) {
                alertBlad.setTitle("Błąd przy rejestracji lekarza!");
                alertBlad.setHeaderText("Lekarz o takim PESELU istnieje już w bazie!");
                alertBlad.showAndWait();
                WysBlad = true;
            }else{
                PreparedStatement stt = con.prepareStatement("UPDATE lekarze SET Imie = ?, Nazwisko = ?, Email = ?, PESEL = ?, Telefon = ?, Specjalizacja = ?, Adres_ID = ? WHERE Lekarz_ID = " + LekarzID);
                stt.setString(1, Imie);
                stt.setString(2, Nazwisko);
                stt.setString(3, Email);
                stt.setLong(4, Long.parseLong(Pesel));
                stt.setInt(5, Integer.parseInt(Telefon));
                stt.setString(6, Specjalizacja);
                stt.setInt(7, AdresID);
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

    public static List<String> PobierzDaneLekarz(){
        int LekarzID = LogowanieController.getKonto_ID();
        List<String> DaneLekarza = new ArrayList<>();

        Connection con = Polaczenie.Connect();
        try {
            ResultSet PDLekarza = con.createStatement().executeQuery("SELECT lekarze.Imie, lekarze.Nazwisko, lekarze.Email, lekarze.PESEL, lekarze.Telefon, lekarze.Specjalizacja, adresy.Kod_Pocztowy, adresy.Miejscowosc, adresy.Ulica, adresy.Nr_domu, konta.Haslo FROM lekarze, adresy, konta WHERE lekarze.Adres_ID = adresy.Adres_ID AND lekarze.Login = konta.Login AND lekarze.Lekarz_ID = " + LekarzID);

            while(PDLekarza.next()){
                DaneLekarza.add(PDLekarza.getString(1));//Imie
                DaneLekarza.add(PDLekarza.getString(2));//Nazwisko
                DaneLekarza.add(PDLekarza.getString(3));//Email
                DaneLekarza.add(String.valueOf(PDLekarza.getLong(4)));//PESEL
                DaneLekarza.add(String.valueOf(PDLekarza.getInt(5)));//Telefon
                DaneLekarza.add(PDLekarza.getString(6));//Specjalizacja
                DaneLekarza.add(PDLekarza.getString(7));//Kod_Pocztowy
                DaneLekarza.add(PDLekarza.getString(8));//Miejscowosc
                DaneLekarza.add(PDLekarza.getString(9));//Ulica
                DaneLekarza.add(PDLekarza.getString(10));//Numer_Domu
                DaneLekarza.add(PDLekarza.getString(11));//Haslo

            }

        }catch(Exception e){
            System.err.println(e);
        }
        return DaneLekarza;
    }
}
