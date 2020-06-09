package Controller;

import Connection.LekarzCon.GodzinyPracy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DodajGodzinyPracyController implements Initializable {
    public ComboBox<String> DzienTygodniaCB;
    public ComboBox<String> GodzinaRPCB;
    public ComboBox<String> GodzinaZPCB;


    int godzinaRPI, godzinaZPI;
    String dzienTygodnia, godzinaRP, godzinaZP;

    public void wypelnijDzienTygodniaCB(){
        DzienTygodniaCB.getItems().clear();
        DzienTygodniaCB.getItems().addAll(
                "Poniedziałek",
                "Wtorek",
                "Środa",
                "Czwartek",
                "Piątek",
                "Sobota");
        DzienTygodniaCB.getSelectionModel().select(0);
    }

    public void wypelnijGodzinaRPCB(){
        GodzinaRPCB.getItems().clear();
        GodzinaRPCB.getItems().addAll(
                "8:00",
                "9:00",
                "10:00",
                "11:00",
                "12:00",
                "13:00",
                "14:00",
                "15:00",
                "16:00");
        GodzinaRPCB.getSelectionModel().select(0);
    }

    public void wypelnijGodzinaZPCB(){
        GodzinaZPCB.getItems().clear();
        GodzinaZPCB.getItems().addAll(
                "9:00",
                "10:00",
                "11:00",
                "12:00",
                "13:00",
                "14:00",
                "15:00",
                "16:00");
        GodzinaZPCB.getSelectionModel().select("9:00");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijDzienTygodniaCB();
        wypelnijGodzinaRPCB();
        wypelnijGodzinaZPCB();


    }

    @FXML
    public void handleDodajGPBTAction(ActionEvent event) throws IOException {
        System.out.println(GodzinaRPCB.getSelectionModel().getSelectedIndex());
        System.out.println(GodzinaZPCB.getSelectionModel().getSelectedIndex());

        godzinaRPI = GodzinaRPCB.getSelectionModel().getSelectedIndex();
        godzinaZPI = GodzinaZPCB.getSelectionModel().getSelectedIndex();
        godzinaRP = GodzinaRPCB.getValue();
        godzinaZP = GodzinaZPCB.getValue();
        dzienTygodnia = DzienTygodniaCB.getValue();

        GodzinyPracy.DodajGodzinyPracy(godzinaRPI, godzinaZPI, godzinaRP, godzinaZP, dzienTygodnia);



    }

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/LekarzFXML/LekarzGlowna.fxml"));
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }
}
