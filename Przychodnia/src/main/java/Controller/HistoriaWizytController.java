package Controller;

import Connection.HistoriaWizyt;
import Connection.ZobaczWizyty;
import Models.ModelZobaczWizyty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoriaWizytController implements Initializable {

    public TableView<ModelZobaczWizyty> WizytyTV;
    public TableColumn<ModelZobaczWizyty, String> Kol_Data;
    public TableColumn<ModelZobaczWizyty, String> Kol_Godzina;
    public TableColumn<ModelZobaczWizyty, String> Kol_Lekarz;
    public TableColumn<ModelZobaczWizyty, String> Kol_Opis;
    public TableColumn<ModelZobaczWizyty, String> Kol_Status;

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

        WizytyTV.setItems(HistoriaWizyt.WizytyGet(ID));
    }

    @FXML
    private Button Wyjdz;

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Wyjdz.getScene().getWindow().hide();

    }
}
