package Controller;

import Connection.ZobaczWizyty;
import Models.ModelZobaczWizyty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ZobaczWizytyController implements Initializable {


    public TableView<ModelZobaczWizyty> WizytyTV;
    public TableColumn<ModelZobaczWizyty, String> Kol_Data;
    public TableColumn<ModelZobaczWizyty, String> Kol_Godzina;
    public TableColumn<ModelZobaczWizyty, String> Kol_Lekarz;
    public TableColumn<ModelZobaczWizyty, String> Kol_Pacjent;
    public TableColumn<ModelZobaczWizyty, String> Kol_Opis;
    public TableColumn<ModelZobaczWizyty, String> Kol_Status;

    @FXML
    private Button Wyjdz;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Kol_Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
        Kol_Godzina.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        Kol_Lekarz.setCellValueFactory(new PropertyValueFactory<>("Lekarz"));
        Kol_Pacjent.setCellValueFactory(new PropertyValueFactory<>("Pacjent"));
        Kol_Opis.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        Kol_Status.setCellValueFactory(new PropertyValueFactory<>("Status"));

        WizytyTV.setItems(ZobaczWizyty.ZobaczWizytyGet());
    }



    @FXML
    public void handleExitBTAction(ActionEvent event) {
        Wyjdz.getScene().getWindow().hide();
    }
}




