package Przychodnia.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LekarzGlownaController {
    @FXML
    public Button LogoutBT;
    @FXML
    public Button EdytujWizytyBT;
    @FXML
    public Button HistoriaWizytBT;
    @FXML
    public Button EdytujDaneBT;



    @FXML
    public void handleEdytujWizyteBTAction(ActionEvent event) throws IOException {
        FXMLLoader EW = new FXMLLoader(getClass().getResource("/Przychodnia/FXML/EdytujWizyte.fxml"));
        Stage EdytujWizyte = new Stage();
        EdytujWizyte.initOwner(EdytujWizytyBT.getScene().getWindow());
        EdytujWizyte.setScene(new Scene((Parent) EW.load()));

        EdytujWizyte.showAndWait();

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
