package Controller.PacjentController;

import Connection.Logowanie;
import Controller.LogowanieController;
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

//TODO niegotowe

public class PacjentGlownaController implements Initializable {

    int ID;

    @FXML
    private Button LogoutBT;
    @FXML
    private Button DodajWizyteBT;
    @FXML
    private Button ZobaczWizytyBT;
    @FXML
    private Button HistoriaWizytBT;
    @FXML
    private Button btnUpdate;
    @FXML
    private Label IDL;

    @FXML
    Label NazwaPL;

    @FXML
    public void handleDodajWizyteBTAction(ActionEvent event) throws IOException {
        Parent ZW = FXMLLoader.load(getClass().getResource("/PacjentFXML/ZarezerwujWizyte.fxml"));
        Stage ZarezerwujWizyte = (Stage)((Node)event.getSource()).getScene().getWindow();
        ZarezerwujWizyte.setScene(new Scene(ZW));
        ZarezerwujWizyte.show();

    }

    @FXML
    public void handleZobaczWizytyBTAction(ActionEvent event) throws IOException {
        Parent AWP = FXMLLoader.load(getClass().getResource("/PacjentFXML/AktulaneWizytyPacjent.fxml"));
        Stage AktualneWizyty = (Stage)((Node)event.getSource()).getScene().getWindow();
        AktualneWizyty.setScene(new Scene(AWP));
        AktualneWizyty.show();

    }

    @FXML
    public void handleHistoriaWizytBTAction(ActionEvent event) throws IOException {
        Parent HWP = FXMLLoader.load(getClass().getResource("/PacjentFXML/HistoriaWizytPacjent.fxml"));
        Stage HistoriaWizyt = (Stage)((Node)event.getSource()).getScene().getWindow();
        HistoriaWizyt.setScene(new Scene(HWP));
        HistoriaWizyt.show();

    }

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        Parent EDP = FXMLLoader.load(getClass().getResource("/PacjentFXML/EdytujDanePacjent.fxml"));
        Stage EdytujDanePacjent = (Stage)((Node)event.getSource()).getScene().getWindow();
        EdytujDanePacjent.setScene(new Scene(EDP));
        EdytujDanePacjent.show();
    }

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/GlownaFXML/Logowanie.fxml"));
        Stage Logowanie = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NazwaPL.setText("");
        NazwaPL.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));
    }
}
