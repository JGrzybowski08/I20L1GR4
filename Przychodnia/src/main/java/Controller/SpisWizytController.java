package Controller;

import Connection.AdministratorCon.SpisWizyt;
import Models.ModelSpisWizyt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Klasa SpisWizytController - kontroler do obsługi wyświetlania wszystkich wizyt
 */

public class SpisWizytController implements Initializable {

    public TableView<ModelSpisWizyt> SpisWizytTV;
    public TableColumn<ModelSpisWizyt, String> DataTC;
    public TableColumn<ModelSpisWizyt, String> GodzinaTC;
    public TableColumn<ModelSpisWizyt, String> OpisTC;
    public TableColumn<ModelSpisWizyt, String> StatusTC;
    public TableColumn<ModelSpisWizyt, String> PacjentTC;
    public TableColumn<ModelSpisWizyt, String> LekarzTC;

    public ComboBox FiltrCB;

    public TextField FiltrTF;

    /**
     * Metoda initialize inicjująca wypełnienie tabel danymi oraz wyświetlanie danych wizyt
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();

        wypelnijCB();
    }

    /**
     * Metoda handleFiltrujBTAction czyszcząca listę z obecnymi danymi i wypełniająca je danymi z odpowiednim filtrem
     * @param event
     */

    @FXML
    public void handleFiltrujBTAction(ActionEvent event){
        SpisWizytTV.getItems().clear();

        SpisWizytTV.setItems(SpisWizyt.FiltrowaneWizytyGet((String) FiltrCB.getValue(), FiltrTF.getText() ));
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
     * Metoda handleExitBTAction obsługująca wyjście do panelu głównego administratora
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/AdministratorFXML/AdministratorGlowna.fxml"));
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }

    /**
     * Metoda wypelnijTabele inicjalizująca wyświetlaną tabelę
     */

    public void wypelnijTabele(){
        DataTC.setCellValueFactory(new PropertyValueFactory<>("Data"));
        GodzinaTC.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        OpisTC.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("Status"));
        PacjentTC.setCellValueFactory(new PropertyValueFactory<>("Pacjent"));
        LekarzTC.setCellValueFactory(new PropertyValueFactory<>("Lekarz"));

        SpisWizytTV.setItems(SpisWizyt.WszystkieWizytyGet());
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
                "Pacjent",
                "Lekarz");
        FiltrCB.getSelectionModel().select(0);

    }

}
