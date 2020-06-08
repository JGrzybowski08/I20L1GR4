package Controller;


import Connection.AdministratorCon.SpisWizyt;
import Connection.Logowanie;
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

public class SpisWizytPacjentController implements Initializable {

    public TableView<ModelSpisWizyt> SpisWizytTV;
    public TableColumn<ModelSpisWizyt, String> DataTC;
    public TableColumn<ModelSpisWizyt, String> GodzinaTC;
    public TableColumn<ModelSpisWizyt, String> OpisTC;
    public TableColumn<ModelSpisWizyt, String> StatusTC;
    public TableColumn<ModelSpisWizyt, String> PacjentTC;
    public TableColumn<ModelSpisWizyt, String> LekarzTC;

    @FXML
    Label NazwaPL;

    public ComboBox FiltrCB;

    public TextField FiltrTF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();

        wypelnijCB();

        NazwaPL.setText("");
        NazwaPL.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));
    }

    @FXML
    public void handleFiltrujBTAction(ActionEvent event){
        SpisWizytTV.getItems().clear();

        SpisWizytTV.setItems(SpisWizyt.FiltrowaneWizytyGet((String) FiltrCB.getValue(), FiltrTF.getText() ));
    }

    @FXML
    public void handleWyczyscFiltrBTAction(ActionEvent event){
        wypelnijTabele();
        FiltrTF.clear();
    }

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/PacjentGlowna.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(AG));
        PacjentGlowna.show();

    }

    public void wypelnijTabele(){
        DataTC.setCellValueFactory(new PropertyValueFactory<>("Data"));
        GodzinaTC.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        OpisTC.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("Status"));
        PacjentTC.setCellValueFactory(new PropertyValueFactory<>("Pacjent"));
        LekarzTC.setCellValueFactory(new PropertyValueFactory<>("Lekarz"));

        SpisWizytTV.setItems(SpisWizyt.WszystkieWizytyGet());
    }

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
