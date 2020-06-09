package Controller.LekarzController;

import Connection.AdministratorCon.SpisWizyt;
import Connection.LekarzCon.AktualneWizytyLekarz;
import Connection.Logowanie;
import Controller.LogowanieController;
import Models.ModelAktualneWizytyLekarz;
import Models.ModelSpisWizyt;
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
 * Klasa AktualneWizytyLekarzController - kontroler do wyświetlania spisu aktualnych wizyt lekarza
 */

public class AktualneWizytyLekarzController implements Initializable {
    public TableView<ModelAktualneWizytyLekarz> SpisWizytTV;
    public TableColumn<ModelAktualneWizytyLekarz, String> DataTC;
    public TableColumn<ModelAktualneWizytyLekarz, String> GodzinaTC;
    public TableColumn<ModelAktualneWizytyLekarz, String> OpisTC;
    public TableColumn<ModelAktualneWizytyLekarz, String> StatusTC;
    public TableColumn<ModelAktualneWizytyLekarz, String> PacjentTC;

    /**
     * @param NazwaLL
     * @param FiltrCB
     * @param FiltrTF
     * @param LekarzID
     */

    @FXML
    Label NazwaLL;

    public ComboBox FiltrCB;

    public TextField FiltrTF;

    int LekarzID = LogowanieController.getKonto_ID();

    /**
     * Metoda initialize inicjująca wypełnienie tabel danymi oraz wyświetlanie danych lekarza
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();

        wypelnijCB();

        NazwaLL.setText("");
        NazwaLL.setText(Logowanie.ImieNazwiskoLekarzGet(LogowanieController.getKonto_ID()));
    }

    /**
     * Metoda handleFiltrujBTAction czyszcząca listę z obecnymi danymi i wypełniająca je danymi z odpowiednim filtrem
     * @param event
     */

    @FXML
    public void handleFiltrujBTAction(ActionEvent event){
        SpisWizytTV.getItems().clear();

        SpisWizytTV.setItems(AktualneWizytyLekarz.FiltrowaneWizytyGet((String) FiltrCB.getValue(), FiltrTF.getText(), LekarzID ));
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
     * Metoda handleExitBTAction obsługująca wyjście do panelu głównego lekarza
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/LekarzFXML/LekarzGlowna.fxml"));
        Stage LekarzGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        LekarzGlowna.setScene(new Scene(AG));
        LekarzGlowna.show();

    }

    /**
     * Metoda wypelnijTabele inicjalizująca wyświetlaną tabelę
     */
    @FXML
    public void handleZaakceptujBTAction(ActionEvent event){
        ModelAktualneWizytyLekarz Wizyta = SpisWizytTV.getSelectionModel().getSelectedItem();
        AktualneWizytyLekarz.ZaakceptujWizyte(Wizyta.getData(), Wizyta.getGodzina());

        wypelnijTabele();
    }

    @FXML
    public void handleOdwolajBTAction(ActionEvent event){
        ModelAktualneWizytyLekarz Wizyta = SpisWizytTV.getSelectionModel().getSelectedItem();
        AktualneWizytyLekarz.OdwolajWizyte(Wizyta.getData(), Wizyta.getGodzina());

        wypelnijTabele();
    }

    @FXML
    public void handleZakonczBTAction(ActionEvent event){
        ModelAktualneWizytyLekarz Wizyta = SpisWizytTV.getSelectionModel().getSelectedItem();
        AktualneWizytyLekarz.ZakonczWizyte(Wizyta.getData(), Wizyta.getGodzina());

        wypelnijTabele();
    }


    public void wypelnijTabele(){
        SpisWizytTV.getItems().clear();

        DataTC.setCellValueFactory(new PropertyValueFactory<>("Data"));
        GodzinaTC.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        OpisTC.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("Status"));
        PacjentTC.setCellValueFactory(new PropertyValueFactory<>("Pacjent"));

        SpisWizytTV.setItems(AktualneWizytyLekarz.WszystkieWizytyGet(LekarzID));
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
                "Pacjent");
        FiltrCB.getSelectionModel().select(0);

    }


}
