package Przychodnia.Controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PacjentGlownaController {

    @FXML
    private Button DodajWizyteBT;
    @FXML
    private Button ZobaczWizytyBT;
    @FXML
    private Button HistoriaWizytBT;
    @FXML
    private Button EdytujDaneBT;



    @FXML
    public void handleDodajWizyteBTAction(ActionEvent event) throws IOException {
        FXMLLoader DW = new FXMLLoader(getClass().getResource("/Przychodnia/FXML/DodajWizyte.fxml"));
        Stage DodajWizyte = new Stage();
        DodajWizyte.initOwner(DodajWizyteBT.getScene().getWindow());
        DodajWizyte.setScene(new Scene((Parent) DW.load()));

        DodajWizyte.showAndWait();

    }

    @FXML
    public void handleZobaczWizytyBTAction(ActionEvent event) throws IOException {
        FXMLLoader ZW = new FXMLLoader(getClass().getResource("/Przychodnia/FXML/ZobaczWizyty.fxml"));
        Stage ZobaczWizyty = new Stage();
        ZobaczWizyty.initOwner(ZobaczWizytyBT.getScene().getWindow());
        ZobaczWizyty.setScene(new Scene((Parent) ZW.load()));

        ZobaczWizyty.showAndWait();

    }

    @FXML
    public void handleHistoriaWizytBTAction(ActionEvent event) throws IOException {
        FXMLLoader HW = new FXMLLoader(getClass().getResource("/Przychodnia/FXML/HistoriaWizyt.fxml"));
        Stage HistoriaWizyt = new Stage();
        HistoriaWizyt.initOwner(HistoriaWizytBT.getScene().getWindow());
        HistoriaWizyt.setScene(new Scene((Parent) HW.load()));

        HistoriaWizyt.showAndWait();

    }

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        FXMLLoader ED = new FXMLLoader(getClass().getResource("/Przychodnia/FXML/EdytujDane.fxml"));
        Stage EdytujDane = new Stage();
        EdytujDane.initOwner(EdytujDaneBT.getScene().getWindow());
        EdytujDane.setScene(new Scene((Parent) ED.load()));

        EdytujDane.showAndWait();
    }

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/Logowanie.fxml"));
        Stage Logowanie = (Stage)((Node)event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

}
