package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

//TODO niegotowe

public class EdytujWizyteFormController {
    @FXML
    private Button WyjdzBT;
    @FXML
    public void handleWyjdzBTAction(ActionEvent event) throws IOException {
        Parent PG = FXMLLoader.load(getClass().getResource("/Przychodnia/FXML/EdytujWizyte.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(PG));
        PacjentGlowna.show();

    }
}
