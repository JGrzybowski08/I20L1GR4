package Controller.PacjentController;

import Connection.Logowanie;
import Connection.PacjentCon.HistoriaWizytPacjent;
import Controller.LogowanieController;
import Models.ModelAktualneWizytyPacjent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Klasa HistoriaWizytPacjentController - kontroler odpowiadający za wyświetlanie spisu przeszłych wizyt pacjenta
 */

public class HistoriaWizytPacjentController implements Initializable {
    public TableView<ModelAktualneWizytyPacjent> SpisWizytTV;
    public TableColumn<ModelAktualneWizytyPacjent, String> DataTC;
    public TableColumn<ModelAktualneWizytyPacjent, String> GodzinaTC;
    public TableColumn<ModelAktualneWizytyPacjent, String> OpisTC;
    public TableColumn<ModelAktualneWizytyPacjent, String> StatusTC;
    public TableColumn<ModelAktualneWizytyPacjent, String> LekarzTC;

    /**
     * @param NazwaPL
     * @param FiltrCB
     * @param FiltrTF
     * @param LekarzID
     */

    @FXML
    Label NazwaPL;

    public ComboBox FiltrCB;

    public TextField FiltrTF;

    int PacjentID = LogowanieController.getKonto_ID();

    /**
     * Metoda initialize inicjująca wypełnienie tabel danymi oraz wyświetlanie danych pacjenta
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();

        wypelnijCB();

        NazwaPL.setText("");
        NazwaPL.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));
    }

    /**
     * Metoda handleFiltrujBTAction czyszcząca listę z obecnymi danymi i wypełniająca je danymi z odpowiednim filtrem
     * @param event
     */

    @FXML
    public void handleFiltrujBTAction(ActionEvent event){
        SpisWizytTV.getItems().clear();

        SpisWizytTV.setItems(HistoriaWizytPacjent.FiltrowaneWizytyGet((String) FiltrCB.getValue(), FiltrTF.getText(), PacjentID ));
    }

    /**
     * Metoda handleWyczyscFiltrBTAction usuwająca filtry nałożone na tabelę
     * @param event
     */

    @FXML
    public void handleWyczyscFiltrBTAction(ActionEvent event){
        wypelnijTabele();
        FiltrTF.clear();
    }

    /**
     * Metoda handleExitBTAction obsługująca wyjście do panelu głównego pacjenta
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/PacjentFXML/PacjentGlowna.fxml"));
        Stage LekarzGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        LekarzGlowna.setScene(new Scene(AG));
        LekarzGlowna.show();

    }

    /**
     * Metoda wypelnijTabele inicjalizująca wyświetlaną tabelę
     */


    public void wypelnijTabele(){
        SpisWizytTV.getItems().clear();

        DataTC.setCellValueFactory(new PropertyValueFactory<>("Data"));
        GodzinaTC.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        OpisTC.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("Status"));
        LekarzTC.setCellValueFactory(new PropertyValueFactory<>("Lekarz"));

        SpisWizytTV.setItems(HistoriaWizytPacjent.WszystkieWizytyGet(PacjentID));
    }

    /**
     * Metoda wypelnijCB dodająca dane do wyświetlanej tabeli
     */

    public void wypelnijCB(){
        FiltrCB.getItems().clear();
        FiltrCB.getItems().addAll(
                "Data",
                "Godzina",
                "Opis",
                "Status",
                "Lekarz");
        FiltrCB.getSelectionModel().select(0);

    }
}
