package Controller;

import Connection.AdministratorCon.CzyszczenieBazy;
import Connection.AdministratorCon.GenerujRaport;
import Connection.AdministratorCon.WypelnianieBazy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 */
public class AdministratorGlownaController {
    @FXML
    public Button LogoutBT;
    @FXML
    public Button EdytujWizytyBT;
    @FXML
    public Button SpisLekarzyBT;
    @FXML
    public Button ZobaczWizytyBT;
    @FXML
    public Button EdytujDaneBT;


    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void handleSpisPacjentowBTAction(ActionEvent event) throws IOException {
        Parent SP = FXMLLoader.load(getClass().getResource("/AdministratorFXML/SpisPacjentow.fxml"));
        Stage SpisPacjentow = (Stage)((Node)event.getSource()).getScene().getWindow();
        SpisPacjentow.setScene(new Scene(SP));
        SpisPacjentow.show();

    }


    @FXML
    public void handleSpisWizytBTAction(ActionEvent event) throws IOException {
        Parent SW = FXMLLoader.load(getClass().getResource("/AdministratorFXML/SpisWizyt.fxml"));
        Stage SpisWizyt = (Stage)((Node)event.getSource()).getScene().getWindow();
        SpisWizyt.setScene(new Scene(SW));
        SpisWizyt.show();
    }


    @FXML
    public void handleSpisLekarzyBTAction(ActionEvent event) throws IOException {
        Parent SL = FXMLLoader.load(getClass().getResource("/AdministratorFXML/SpisLekarzy.fxml"));
        Stage SpisLekarzy = (Stage)((Node)event.getSource()).getScene().getWindow();
        SpisLekarzy.setScene(new Scene(SL));
        SpisLekarzy.show();

    }

    @FXML
    public void handleDodajLekarzaBTAction(ActionEvent event) throws IOException {
        Parent DL = FXMLLoader.load(getClass().getResource("/AdministratorFXML/DodajLekarza.fxml"));
        Stage DodajLekarza = (Stage)((Node)event.getSource()).getScene().getWindow();
        DodajLekarza.setScene(new Scene(DL));
        DodajLekarza.show();

    }

    @FXML
    public void handleWyczyscBazeBTAction(ActionEvent event){
        CzyszczenieBazy.Wyczysc();
    }

    @FXML
    public void handleWypelnijBazeBTAction(ActionEvent event){
        WypelnianieBazy.Wypelnij();
    }

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/GlownaFXML/Logowanie.fxml"));
        Stage Logowanie = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    public void handleGenerujRaportWizytBTAction(ActionEvent event) {
        GenerujRaport.generujRaportWizyt();
    }
}
