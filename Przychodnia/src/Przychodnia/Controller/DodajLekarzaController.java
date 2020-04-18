package Przychodnia.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class DodajLekarzaController {
    @FXML
    private Button Wyjdz;
    @FXML
    public void handleWyjdzBTAction(ActionEvent event) throws IOException {
        Wyjdz.getScene().getWindow().hide();

    }
}
