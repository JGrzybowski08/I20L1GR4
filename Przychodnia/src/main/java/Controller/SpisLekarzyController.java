package Controller;

import Connection.AdministratorCon.SpisLekarzy;
import Models.ModelSpisLekarzy;
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

public class SpisLekarzyController implements Initializable {

    public TableView<ModelSpisLekarzy> SpisLekarzyTV;
    public TableColumn<ModelSpisLekarzy, String> ImieTC;
    public TableColumn<ModelSpisLekarzy, String> NazwiskoTC;
    public TableColumn<ModelSpisLekarzy, String> EMailTC;
    public TableColumn<ModelSpisLekarzy, Long> PeselTC;
    public TableColumn<ModelSpisLekarzy, Integer> TelefonTC;
    public TableColumn<ModelSpisLekarzy, String> SpecjalizacjaTC;
    public TableColumn<ModelSpisLekarzy, String> KodPocztowyTC;
    public TableColumn<ModelSpisLekarzy, String> MiejscowoscTC;
    public TableColumn<ModelSpisLekarzy, String> UlicaTC;
    public TableColumn<ModelSpisLekarzy, String> NumerDomuTC;

    private Button ExitBT;

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

        SpisLekarzyTV.setItems(SpisLekarzy.FiltrowaniLekarzeGet(FiltrCB.getValue(), FiltrTF.getText() ));
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
        EMailTC.setCellValueFactory(new PropertyValueFactory<>("Email"));
        PeselTC.setCellValueFactory(new PropertyValueFactory<>("Pesel"));
        TelefonTC.setCellValueFactory(new PropertyValueFactory<>("Telefon"));
        SpecjalizacjaTC.setCellValueFactory(new PropertyValueFactory<>("Specjalizacja"));
        KodPocztowyTC.setCellValueFactory(new PropertyValueFactory<>("Kod_Pocztowy"));
        MiejscowoscTC.setCellValueFactory(new PropertyValueFactory<>("Miejscowosc"));
        UlicaTC.setCellValueFactory(new PropertyValueFactory<>("Ulica"));
        NumerDomuTC.setCellValueFactory(new PropertyValueFactory<>("Numer_Domu"));


        SpisLekarzyTV.setItems(SpisLekarzy.WszyscyLekarzeGet());
    }

    public void wypelnijCB(){
        FiltrCB.getItems().clear();
        FiltrCB.getItems().addAll(
                "Imie",
                "Nazwisko",
                "Email",
                "PESEL",
                "Telefon",
                "Specjalizacja",
                "Kod pocztowy",
                "Miejscowość",
                "Ulica",
                "Numer domu");
        FiltrCB.getSelectionModel().select(0);

    }

}
