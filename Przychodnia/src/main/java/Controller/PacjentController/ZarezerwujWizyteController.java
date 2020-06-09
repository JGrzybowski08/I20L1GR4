package Controller.PacjentController;

import Connection.AdministratorCon.SpisLekarzy;
import Connection.PacjentCon.ZarezerwujWizyte;
import Models.ModelZarezerwujWizyte;
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

public class ZarezerwujWizyteController implements Initializable {
    public TableView<ModelZarezerwujWizyte> SpisLekarzyTV;
    public TableColumn<ModelZarezerwujWizyte, String> ImieTC;
    public TableColumn<ModelZarezerwujWizyte, String> NazwiskoTC;
    public TableColumn<ModelZarezerwujWizyte, String> EMailTC;
    public TableColumn<ModelZarezerwujWizyte, Integer> TelefonTC;
    public TableColumn<ModelZarezerwujWizyte, String> SpecjalizacjaTC;

    public ComboBox<String> FiltrCB;

    public TextField FiltrTF;

    static ModelZarezerwujWizyte Lekarze;

    Alert alertErr = new Alert(Alert.AlertType.ERROR);

    public static ModelZarezerwujWizyte getLekarze() {
        return Lekarze;
    }

    public void setLekarze(ModelZarezerwujWizyte lekarze) {
        Lekarze = lekarze;
    }

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/PacjentFXML/PacjentGlowna.fxml"));
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }
    @FXML
    public void handleWyczyscFiltrBTAction(ActionEvent event){
        wypelnijTabele();
        FiltrTF.clear();
    }

    @FXML
    public void handleFiltrujBTAction(ActionEvent event){
        SpisLekarzyTV.getItems().clear();

        SpisLekarzyTV.setItems(ZarezerwujWizyte.FiltrowaniLekarzeGet(FiltrCB.getValue(), FiltrTF.getText() ));
    }

    @FXML
    public void handleWybierzBTAction(ActionEvent event) throws IOException {
        setLekarze(SpisLekarzyTV.getSelectionModel().getSelectedItem());
        System.out.println(Lekarze);

        if(Lekarze != null) {
            Parent AG = FXMLLoader.load(getClass().getResource("/PacjentFXML/ZarezerwujWizyteForm.fxml"));
            Stage AdministratorGlowna = (Stage) ((Node) event.getSource()).getScene().getWindow();
            AdministratorGlowna.setScene(new Scene(AG));
            AdministratorGlowna.show();
        }else{
            alertErr.setTitle("Niepowodzenie!");
            alertErr.setHeaderText("Nie wybrano żandego lekarza!");
            alertErr.showAndWait();
        }

    }

    public void wypelnijTabele(){
        ImieTC.setCellValueFactory(new PropertyValueFactory<>("Imie"));
        NazwiskoTC.setCellValueFactory(new PropertyValueFactory<>("Nazwisko"));
        EMailTC.setCellValueFactory(new PropertyValueFactory<>("Email"));
        TelefonTC.setCellValueFactory(new PropertyValueFactory<>("Telefon"));
        SpecjalizacjaTC.setCellValueFactory(new PropertyValueFactory<>("Specjalizacja"));

        SpisLekarzyTV.setItems(ZarezerwujWizyte.WszyscyLekarzeGet());
    }

    public void wypelnijCB(){
        FiltrCB.getItems().clear();
        FiltrCB.getItems().addAll(
                "Imie",
                "Nazwisko",
                "Email",
                "Telefon",
                "Specjalizacja");
        FiltrCB.getSelectionModel().select(0);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        wypelnijTabele();
        wypelnijCB();
    }
}
