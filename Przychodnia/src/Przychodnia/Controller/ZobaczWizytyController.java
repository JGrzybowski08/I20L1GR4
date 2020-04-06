package Przychodnia.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZobaczWizytyController {

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent PG = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/PacjentGlowna.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(PG));
        PacjentGlowna.show();

    }
}
