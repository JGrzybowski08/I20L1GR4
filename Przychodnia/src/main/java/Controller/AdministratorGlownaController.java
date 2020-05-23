package Controller;

import Connection.GenerujRaport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AdministratorGlownaController {
    @FXML
    public Button LogoutBT;
    @FXML
    public Button EdytujWizytyBT;
    @FXML
    public Button HistoriaWizytBT;
    @FXML
    public Button EdytujDaneBT;
    @FXML
    private Button DodajWizyteBT;
    @FXML
    private Button DodajLekarzaBT;




    @FXML
    public void handleEdytujWizyteBTAction(ActionEvent event) throws IOException {
        FXMLLoader EW = new FXMLLoader(getClass().getResource("/EdytujWizyte.fxml"));
        Stage EdytujWizyte = new Stage();
        EdytujWizyte.initOwner(EdytujWizytyBT.getScene().getWindow());
        EdytujWizyte.setScene(new Scene((Parent) EW.load()));

        EdytujWizyte.showAndWait();

    }


    @FXML
    public void handleHistoriaWizytBTAction(ActionEvent event) throws IOException {
        FXMLLoader HW = new FXMLLoader(getClass().getResource("/HistoriaWizyt.fxml"));
        Stage HistoriaWizyt = new Stage();
        HistoriaWizyt.initOwner(HistoriaWizytBT.getScene().getWindow());
        HistoriaWizyt.setScene(new Scene((Parent) HW.load()));

        HistoriaWizyt.showAndWait();

    }

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        FXMLLoader ED = new FXMLLoader(getClass().getResource("/EdytujDane.fxml"));
        Stage EdytujDane = new Stage();
        EdytujDane.initOwner(EdytujDaneBT.getScene().getWindow());
        EdytujDane.setScene(new Scene((Parent) ED.load()));

        EdytujDane.showAndWait();
    }

    @FXML
    public void handleDodajWizyteBTAction(ActionEvent event) throws IOException {
        FXMLLoader DW = new FXMLLoader(getClass().getResource("/DodajWizyte.fxml"));
        Stage DodajWizyte = new Stage();
        DodajWizyte.initOwner(DodajWizyteBT.getScene().getWindow());
        DodajWizyte.setScene(new Scene((Parent) DW.load()));

        DodajWizyte.showAndWait();

    }

    @FXML
    public void handleDodajLekarzaBTAction(ActionEvent event) throws IOException {
        FXMLLoader DL = new FXMLLoader(getClass().getResource("/DodajLekarza.fxml"));
        Stage DodajLekarza = new Stage();
        DodajLekarza.initOwner(DodajWizyteBT.getScene().getWindow());
        DodajLekarza.setScene(new Scene((Parent) DL.load()));

        DodajLekarza.showAndWait();

    }

    @FXML
        public void handleWyczyscBazeBTAction(ActionEvent event){
        Connection.CzyszczenieBazy.Wyczysc();
    }

    @FXML
    public void handleWypelnijBazeBTAction(ActionEvent event){
        Connection.WypelnianieBazy.Wypelnij();
    }

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/Logowanie.fxml"));
        Stage Logowanie = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    public void handleGenerujRaportWizytBTAction(ActionEvent event) {
        GenerujRaport.generujRaportWizyt();
    }
}
