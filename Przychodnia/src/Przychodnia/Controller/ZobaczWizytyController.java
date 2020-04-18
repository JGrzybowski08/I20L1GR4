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

public class ZobaczWizytyController {
    @FXML
    private Button Wyjdz;

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Wyjdz.getScene().getWindow().hide();

    }
}
