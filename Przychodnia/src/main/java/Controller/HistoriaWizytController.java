package Controller;

import Connection.HistoriaWizyt;
import Models.ModelSpisWizyt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoriaWizytController implements Initializable {

    public TableView<ModelSpisWizyt> WizytyTV;
    public TableColumn<ModelSpisWizyt, String> Kol_Data;
    public TableColumn<ModelSpisWizyt, String> Kol_Godzina;
    public TableColumn<ModelSpisWizyt, String> Kol_Lekarz;
    public TableColumn<ModelSpisWizyt, String> Kol_Opis;
    public TableColumn<ModelSpisWizyt, String> Kol_Status;

    int ID=6;
    //TODO  historia wizyt dziala tylko dla recznie wpisanego id

    public void setID(int IDGet) {

        ID = IDGet;

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Kol_Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
        Kol_Godzina.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        Kol_Lekarz.setCellValueFactory(new PropertyValueFactory<>("Lekarz"));
        Kol_Opis.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        Kol_Status.setCellValueFactory(new PropertyValueFactory<>("Status"));

        WizytyTV.setItems(HistoriaWizyt.ZobaczWizytyGet());
    }

    @FXML
    private Button Wyjdz;

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Wyjdz.getScene().getWindow().hide();

    }
}
