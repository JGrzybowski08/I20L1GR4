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

/**
 * Klasa PacjentGlownaController - kontroler obsługujący panel główny pacjenta
 */

public class PacjentGlownaController implements Initializable {


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

    /**
     * Metoda handleDodajWizyteBTAction - metoda obsługująca przycisk do rezerwacji nowych wizyt
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleDodajWizyteBTAction(ActionEvent event) throws IOException {
        Parent ZW = FXMLLoader.load(getClass().getResource("/PacjentFXML/ZarezerwujWizyte.fxml"));
        Stage ZarezerwujWizyte = (Stage)((Node)event.getSource()).getScene().getWindow();
        ZarezerwujWizyte.setScene(new Scene(ZW));
        ZarezerwujWizyte.show();

    }

    /**
     * Metoda handleZobaczWizytyBTAction - metoda obsługująca przycisk do zobaczenia spisu wizyt danego pacjenta
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleZobaczWizytyBTAction(ActionEvent event) throws IOException {
        Parent AWP = FXMLLoader.load(getClass().getResource("/PacjentFXML/AktulaneWizytyPacjent.fxml"));
        Stage AktualneWizyty = (Stage)((Node)event.getSource()).getScene().getWindow();
        AktualneWizyty.setScene(new Scene(AWP));
        AktualneWizyty.show();

    }

    /**
     * Metoda handleHistoriaWizytBTAction - metoda obsługująca przycisk do sprawdzenia spisu przeszłych wizyt pacjenta
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleHistoriaWizytBTAction(ActionEvent event) throws IOException {
        Parent HWP = FXMLLoader.load(getClass().getResource("/PacjentFXML/HistoriaWizytPacjent.fxml"));
        Stage HistoriaWizyt = (Stage)((Node)event.getSource()).getScene().getWindow();
        HistoriaWizyt.setScene(new Scene(HWP));
        HistoriaWizyt.show();

    }

    /**
     * Metoda handleEdytujDaneBTAction - metoda obsługująca przycisk przekierowujący do okienka edycji danych pacjenta
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        Parent EDP = FXMLLoader.load(getClass().getResource("/PacjentFXML/EdytujDanePacjent.fxml"));
        Stage EdytujDanePacjent = (Stage)((Node)event.getSource()).getScene().getWindow();
        EdytujDanePacjent.setScene(new Scene(EDP));
        EdytujDanePacjent.show();
    }

    /**
     * Metoda handleLogooutBTAction - metoda obsługująca wylogowywanie pacjenta z serwisu
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/GlownaFXML/Logowanie.fxml"));
        Stage Logowanie = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    /**
     * Metoda initialize - metoda inicjująca wyświetlanie imienia i nazwiska pacjenta w panelu pacjenta
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NazwaPL.setText("");
        NazwaPL.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));
    }
}
