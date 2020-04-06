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
    public Button DodajWizyteBT;
    public Button ZobaczWizytyBT;

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/Logowanie.fxml"));
        Stage Logowanie = (Stage)((Node)event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    @FXML
    public void handleEdytujWizyteBTAction(ActionEvent event) throws IOException {
        Parent DW = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/EdytujWizyte.fxml"));
        Stage DodajWizyte = (Stage)((Node)event.getSource()).getScene().getWindow();
        DodajWizyte.setScene(new Scene(DW));
        DodajWizyte.show();

    }

    @FXML
    public void handleZobaczWizytyBTAction(ActionEvent event) throws IOException {
        Parent ZW = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/ZobaczWizyty.fxml"));
        Stage ZobaczWizyty = (Stage)((Node)event.getSource()).getScene().getWindow();
        ZobaczWizyty.setScene(new Scene(ZW));
        ZobaczWizyty.show();

    }

    @FXML
    public void handleHistoriaWizytBTAction(ActionEvent event) throws IOException {
        Parent HW = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/HistoriaWizyt.fxml"));
        Stage HistoriaWizyt = (Stage)((Node)event.getSource()).getScene().getWindow();
        HistoriaWizyt.setScene(new Scene(HW));
        HistoriaWizyt.show();

    }

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        Parent HW = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/EdytujDane.fxml"));
        Stage HistoriaWizyt = (Stage)((Node)event.getSource()).getScene().getWindow();
        HistoriaWizyt.setScene(new Scene(HW));
        HistoriaWizyt.show();

    }
}
