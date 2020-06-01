package Controller;

import Connection.Logowanie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LekarzGlownaController implements Initializable {
    @FXML
    public Button LogoutBT;
    @FXML
    public Button EdytujWizytyBT;
    @FXML
    public Button HistoriaWizytBT;
    @FXML
    public Button EdytujDaneBT;
    @FXML
    Label NazwaLL;



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
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/Logowanie.fxml"));
        Stage Logowanie = (Stage)((Node)event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NazwaLL.setText("");
        NazwaLL.setText(Logowanie.ImieNazwiskoLekarzGet(LogowanieController.getKonto_ID()));
    }
}
