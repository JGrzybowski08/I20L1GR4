package Controller;

import Connection.Polaczenie;
import Connection.ZobaczWizyty;
import Models.ModelZobaczWizyty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ZobaczWizytyController implements Initializable {


    public TableView<ModelZobaczWizyty> WizytyTV;
    public TableColumn<ModelZobaczWizyty, String> Kol_Data;
    public TableColumn<ModelZobaczWizyty, String> Kol_Godzina;
    public TableColumn<ModelZobaczWizyty, String> Kol_Lekarz;
    public TableColumn<ModelZobaczWizyty, String> Kol_Opis;
    public TableColumn<ModelZobaczWizyty, String> Kol_Status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Kol_Data.setCellValueFactory(new PropertyValueFactory<>("Data"));
        Kol_Godzina.setCellValueFactory(new PropertyValueFactory<>("Godzina"));
        Kol_Lekarz.setCellValueFactory(new PropertyValueFactory<>("Lekarz"));
        Kol_Opis.setCellValueFactory(new PropertyValueFactory<>("Opis"));
        Kol_Status.setCellValueFactory(new PropertyValueFactory<>("Status"));

        WizytyTV.setItems(ZobaczWizyty.WizytyGet());
    }

    @FXML
    private Button Wyjdz;

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Wyjdz.getScene().getWindow().hide();
    }



}
