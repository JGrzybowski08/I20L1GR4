package Przychodnia.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EdytujWizyteController {
    @FXML
    public void handleEdytujBTAction(ActionEvent event) throws IOException {
        Parent DW = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/EdytujWizyteForm.fxml"));
        Stage DodajWizyte = (Stage)((Node)event.getSource()).getScene().getWindow();
        DodajWizyte.setScene(new Scene(DW));
        DodajWizyte.show();

    }
    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent PG = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/LekarzGlowna.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(PG));
        PacjentGlowna.show();

    }
}
