package Controller;

import Connection.SpisLekarzy;
import Connection.SpisPacjentow;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();
        wypelnijCB();
    }
    @FXML
    public void handleFiltrujBTAction(ActionEvent event){
        SpisLekarzyTV.getItems().clear();

        SpisLekarzyTV.setItems(SpisPacjentow.FiltrowaniPacjenciGet(FiltrCB.getValue(), FiltrTF.getText() ));
    }

    @FXML
    public void handleWyczyscFiltrBTAction(ActionEvent event){
        wypelnijTabele();
        FiltrTF.clear();
    }

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/AdministratorFXML/AdministratorGlowna.fxml"));
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }

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
