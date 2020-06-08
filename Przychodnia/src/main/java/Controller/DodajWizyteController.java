package Controller;

import Connection.Polaczenie;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;
import org.controlsfx.control.PrefixSelectionChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

//TODO niegotowe

public class DodajWizyteController implements Initializable {

    int ID;
    int IdLekarza;

    public void setID(int IDGet) {
        ID = IDGet;
    }


    @FXML
    private Button Wyjdz;


    @FXML
    private PrefixSelectionChoiceBox godzinaCB;

    @FXML
    private PrefixSelectionChoiceBox lekarzeCB;
    @FXML
    private TextField opisTF;
    @FXML
    private JFXDatePicker dataDP;



    @FXML
    public void handleWyjdzBTAction(ActionEvent event) throws IOException {
        Wyjdz.getScene().getWindow().hide();
    }

    public void setCB(){
        godzinaCB.getItems().clear();
        godzinaCB.getItems().addAll("08:00", "08:15", "08:30", "08:45",
                "09:00", "09:15", "09:30", "09:45",
                "10:00", "10:15", "10:30", "10:45",
                "11:00", "11:15", "11:30", "11:45",
                "12:00", "12:15", "12:30", "12:45",
                "13:00", "13:15", "13:30", "13:45",
                "14:00", "14:15", "14:30", "14:45",
                "15:00", "15:15", "15:30", "15:45");
    }

    public void getLekarze(){
        lekarzeCB.getItems().clear();
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT Imie, Nazwisko FROM lekarze"
            );
            while(rs.next()){
                lekarzeCB.getItems().add(rs.getString(1) + " " +rs.getString(2));
            }
            con.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }

    public int getLekarz(Object IM){
        String str = String.valueOf(IM);
        String[] splited = str.split("\\s+");
        try {
            Connection con = Polaczenie.Connect();
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT Lekarz_ID FROM lekarze WHERE (Imie = '" + splited[0] + "' AND nazwisko = '" + splited[1] +"')"
            );
            while(rs.next()){
               IdLekarza = rs.getInt(1);
            }
            con.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return IdLekarza;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCB();
        getLekarze();
    }

    public void dodajWizyteBT(ActionEvent event) {
        System.out.println(ID);

        try {
            Connection con = Polaczenie.Connect();
            String SQL = "INSERT INTO Wizyty (Data, Godzina, Opis, Status, Pacjent_ID, Lekarz_ID) VALUES (?,?,?,?,?,?)";
            PreparedStatement pstat = con.prepareStatement(SQL);
            pstat.setString(1, dataDP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            pstat.setObject(2, godzinaCB.getValue());
            pstat.setString(3, opisTF.getText());
            pstat.setString(4, "Oczekująca");
            pstat.setInt(5, ID);
            pstat.setInt(6, getLekarz(lekarzeCB.getValue()));
            pstat.executeUpdate();
            pstat.close();
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
