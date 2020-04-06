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

public class DodajWizyteController {
    @FXML
    public Button WyjdzBT;

    @FXML
    public void handleWyjdzBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/PacjentGlowna.fxml"));
        Stage Logowanie = (Stage)((Node)event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

}
