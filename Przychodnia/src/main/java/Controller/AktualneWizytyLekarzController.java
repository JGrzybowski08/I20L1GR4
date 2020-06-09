package Controller;

import Connection.AdministratorCon.SpisWizyt;
import Connection.LekarzCon.AktualneWizytyLekarz;
import Models.ModelAktualneWizytyLekarz;
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

public class AktualneWizytyLekarzController implements Initializable {
    public TableView<ModelAktualneWizytyLekarz> SpisWizytTV;
    public TableColumn<ModelSpisWizyt, String> DataTC;
    public TableColumn<ModelSpisWizyt, String> GodzinaTC;
    public TableColumn<ModelSpisWizyt, String> OpisTC;
    public TableColumn<ModelSpisWizyt, String> StatusTC;
    public TableColumn<ModelSpisWizyt, String> PacjentTC;

    public ComboBox FiltrCB;

    public TextField FiltrTF;

    int LekarzID = LogowanieController.getKonto_ID();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();

        wypelnijCB();
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
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }

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
