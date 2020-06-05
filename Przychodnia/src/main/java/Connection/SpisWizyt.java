package Connection;

import Models.ModelSpisWizyt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;

public class SpisWizyt {
    public static ObservableList<ModelSpisWizyt> WszystkieWizytyGet() {
        ObservableList<ModelSpisWizyt> SpisWizytOL = FXCollections.observableArrayList();

        try{
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = lekarze.Lekarz_ID ORDER BY wizyty.Data DESC, wizyty.Godzina DESC"
            );
            while (rs.next()) {
                SpisWizytOL.add(new ModelSpisWizyt(
                        rs.getString(1), //Data
                        rs.getString(2), //Godzina
                        rs.getString(3), //Opis
                        rs.getString(4), //Status
                        rs.getString(5) + " " + rs.getString(6),
                        rs.getString(7) + " " + rs.getString(8)
                ));
            }

        }catch(Exception e){
            System.err.println(e);
        }
        return SpisWizytOL;
    }

    public static ObservableList<ModelSpisWizyt> FiltrowaneWizytyGet(String FiltrCB, String FiltrTF) {
        ObservableList<ModelSpisWizyt> SpisWizytOL = FXCollections.observableArrayList();
        ResultSet FWG;
        String[] IiN;
        String sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND "+ FiltrCB +" = '"+ FiltrTF +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";

        switch(FiltrCB){
            case "Pacjent":
                IiN = FiltrTF.split(" ");
                sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND pacjenci.Imie = '"+ IiN[0] + "' AND pacjenci.Nazwisko = '"+ IiN[1] +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";
                break;
            case "Lekarz":
                IiN = FiltrTF.split(" ");
                sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND lekarze.Imie = '"+ IiN[0] + "' AND lekarze.Nazwisko = '"+ IiN[1] +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";
                break;
        }

        try{
            Connection con = Polaczenie.Connect();
            FWG = con.createStatement().executeQuery(sql);

            while (FWG.next()) {
                SpisWizytOL.add(new ModelSpisWizyt(
                        FWG.getString(1), //Data
                        FWG.getString(2), //Godzina
                        FWG.getString(3), //Opis
                        FWG.getString(4), //Status
                        FWG.getString(5) + " " + FWG.getString(6),
                        FWG.getString(7) + " " + FWG.getString(8)
                ));
            }

        }catch(Exception e){
            System.err.println(e);
        }
        return SpisWizytOL;
    }
}
