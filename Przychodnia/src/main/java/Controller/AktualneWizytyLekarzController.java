package Controller;

import Connection.AdministratorCon.SpisWizyt;
import Connection.LekarzCon.AktualneWizytyLekarz;
import Connection.Logowanie;
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

public class AktualneWizytyLekarzController implements Initializable {
    public TableView<ModelAktualneWizytyLekarz> SpisWizytTV;
    public TableColumn<ModelSpisWizyt, String> DataTC;
    public TableColumn<ModelSpisWizyt, String> GodzinaTC;
    public TableColumn<ModelSpisWizyt, String> OpisTC;
    public TableColumn<ModelSpisWizyt, String> StatusTC;
    public TableColumn<ModelSpisWizyt, String> PacjentTC;

    @FXML
    Label NazwaLL;

    public ComboBox FiltrCB;

    public TextField FiltrTF;

    int LekarzID = LogowanieController.getKonto_ID();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();

        wypelnijCB();

        NazwaLL.setText("");
        NazwaLL.setText(Logowanie.ImieNazwiskoLekarzGet(LogowanieController.getKonto_ID()));
    }

    @FXML
    public void handleFiltrujBTAction(ActionEvent event){
        SpisWizytTV.getItems().clear();

        SpisWizytTV.setItems(AktualneWizytyLekarz.FiltrowaneWizytyGet((String) FiltrCB.getValue(), FiltrTF.getText(), LekarzID ));
    }

    @FXML
    public void handleWyczyscFiltrBTAction(ActionEvent event){
        wypelnijTabele();
        FiltrTF.clear();
    }

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/LekarzFXML/LekarzGlowna.fxml"));
        Stage LekarzGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        LekarzGlowna.setScene(new Scene(AG));
        LekarzGlowna.show();

    }

    public void wypelnijTabele(){
        DataTC.setCellValueFactory(new PropertyValueFactory<>("Data"));
        GodzinaTC.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        OpisTC.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        StatusTC.setCellValueFactory(new PropertyValueFactory<>("Status"));
        PacjentTC.setCellValueFactory(new PropertyValueFactory<>("Pacjent"));

        SpisWizytTV.setItems(AktualneWizytyLekarz.WszystkieWizytyGet(LekarzID));
    }

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
