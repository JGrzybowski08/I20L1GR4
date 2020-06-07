package Connection.LekarzCon;

import Models.ModelAktualneWizytyLekarz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import Connection.Polaczenie;

public class HistoriaWizytLekarz {
    public static ObservableList<ModelAktualneWizytyLekarz> WszystkieWizytyGet(int LekarzID) {
        ObservableList<ModelAktualneWizytyLekarz> SpisWizytOL = FXCollections.observableArrayList();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        try{
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = "+ LekarzID +" AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND wizyty.Data < '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC"
            );
            while (rs.next()) {
                SpisWizytOL.add(new ModelAktualneWizytyLekarz(
                        rs.getString(1), //Data
                        rs.getString(2), //Godzina
                        rs.getString(3), //Opis
                        rs.getString(4), //Status
                        rs.getString(5) + " " + rs.getString(6)
                ));
            }

        }catch(Exception e){
            System.err.println(e);
        }
        return SpisWizytOL;
    }

    public static ObservableList<ModelAktualneWizytyLekarz> FiltrowaneWizytyGet(String FiltrCB, String FiltrTF, int LekarzID) {
        ObservableList<ModelAktualneWizytyLekarz> SpisWizytOL = FXCollections.observableArrayList();
        ResultSet FWG;
        String[] IiN;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = "+ LekarzID +" AND "+ FiltrCB +" = '"+ FiltrTF +"' AND wizyty.Lekarz_ID = lekarze.Lekarz_ID wizyty.Data < '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";

        switch(FiltrCB){
            case "Pacjent":
                IiN = FiltrTF.split(" ");
                sql = "SELECT wizyty.Data, wizyty.Godzina, wizyty.Opis, wizyty.Status, pacjenci.Imie, pacjenci.Nazwisko, lekarze.Imie, lekarze.Nazwisko FROM wizyty, pacjenci, lekarze WHERE wizyty.Pacjent_ID = pacjenci.Pacjent_ID AND wizyty.Lekarz_ID = "+ LekarzID +" AND pacjenci.Imie = '"+ IiN[0] + "' AND pacjenci.Nazwisko = '"+ IiN[1] +"' AND wizyty.Lekarz_ID = lekarze.Lekarz_ID AND wizyty.Data < '"+ dtf.format(now) +"' ORDER BY wizyty.Data DESC, wizyty.Godzina DESC";
                break;
        }

        try{
            Connection con = Polaczenie.Connect();
            FWG = con.createStatement().executeQuery(sql);

            while (FWG.next()) {
                SpisWizytOL.add(new ModelAktualneWizytyLekarz(
                        FWG.getString(1), //Data
                        FWG.getString(2), //Godzina
                        FWG.getString(3), //Opis
                        FWG.getString(4), //Status
                        FWG.getString(5) + " " + FWG.getString(6)
                ));
            }

        }catch(Exception e){
            System.err.println(e);
        }
        return SpisWizytOL;
    }
}
