package Controller.AdministratorController;

import Connection.AdministratorCon.SpisPacjentow;
import Models.ModelSpisPacjentow;
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
 * Klasa SpisPacjentowController - kontroler do obsługi wyświetlania wszystkich pacjentów
 */

public class SpisPacjentowController implements Initializable {

    public TableView<ModelSpisPacjentow> SpisLekarzyTV;
    public TableColumn<ModelSpisPacjentow, String> ImieTC;
    public TableColumn<ModelSpisPacjentow, String> NazwiskoTC;
    public TableColumn<ModelSpisPacjentow, Long> PeselTC;
    public TableColumn<ModelSpisPacjentow, Integer> TelefonTC;
    public TableColumn<ModelSpisPacjentow, String> KodPocztowyTC;
    public TableColumn<ModelSpisPacjentow, String> MiejscowoscTC;
    public TableColumn<ModelSpisPacjentow, String> UlicaTC;
    public TableColumn<ModelSpisPacjentow, String> NumerDomuTC;

    public ComboBox<String> FiltrCB;

    public TextField FiltrTF;

    /**
     * Metoda initialize inicjująca wypełnienie tabel danymi oraz wyświetlanie danych pacjentów
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
        SpisLekarzyTV.getItems().clear();

        SpisLekarzyTV.setItems(SpisPacjentow.FiltrowaniPacjenciGet(FiltrCB.getValue(), FiltrTF.getText() ));
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
        ImieTC.setCellValueFactory(new PropertyValueFactory<>("Imie"));
        NazwiskoTC.setCellValueFactory(new PropertyValueFactory<>("Nazwisko"));
        PeselTC.setCellValueFactory(new PropertyValueFactory<>("Pesel"));
        TelefonTC.setCellValueFactory(new PropertyValueFactory<>("Telefon"));
        KodPocztowyTC.setCellValueFactory(new PropertyValueFactory<>("Kod_Pocztowy"));
        MiejscowoscTC.setCellValueFactory(new PropertyValueFactory<>("Miejscowosc"));
        UlicaTC.setCellValueFactory(new PropertyValueFactory<>("Ulica"));
        NumerDomuTC.setCellValueFactory(new PropertyValueFactory<>("Numer_Domu"));


        SpisLekarzyTV.setItems(SpisPacjentow.WszyscyPacjenciGet());
    }

    /**
     * Metoda wypelnijCB dodająca dane do wyświetlanej tabeli
     */

    public void wypelnijCB(){
        FiltrCB.getItems().clear();
        FiltrCB.getItems().addAll(
                "Imie",
                "Nazwisko",
                "PESEL",
                "Telefon",
                "Kod pocztowy",
                "Miejscowość",
                "Ulica",
                "Numer domu");
        FiltrCB.getSelectionModel().select(0);

    }
}
