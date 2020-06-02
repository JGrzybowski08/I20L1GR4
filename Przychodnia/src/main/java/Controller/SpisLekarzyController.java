package Controller;

import Connection.SpisLekarzy;
import Models.ModelZobaczLekarzy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SpisLekarzyController implements Initializable {

    public TableView<ModelZobaczLekarzy> LekarzeTV;
    public TableColumn<ModelZobaczLekarzy, String> Kol_Imie;
    public TableColumn<ModelZobaczLekarzy, String> Kol_Nazwisko;
    public TableColumn<ModelZobaczLekarzy, String> Kol_Telefon;
    public TableColumn<ModelZobaczLekarzy, String> Kol_Specjalizacja;
    public TableColumn<ModelZobaczLekarzy, String> Kol_Pesel;
    public TableColumn<ModelZobaczLekarzy, String> Kol_Email;

    @FXML
    private Button Wyjdz;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Kol_Imie.setCellValueFactory(new PropertyValueFactory<>("Imie"));
        Kol_Nazwisko.setCellValueFactory(new PropertyValueFactory<>("Nazwisko"));
        Kol_Telefon.setCellValueFactory(new PropertyValueFactory<>("Telefon"));
        Kol_Specjalizacja.setCellValueFactory(new PropertyValueFactory<>("Specjalizacja"));
        Kol_Pesel.setCellValueFactory(new PropertyValueFactory<>("Pesel"));
        Kol_Email.setCellValueFactory(new PropertyValueFactory<>("e_mail"));

        LekarzeTV.setItems(SpisLekarzy.WszyscyLekarzeGet());
    }

    @FXML
    public void handleExitBTAction(ActionEvent event) {
        Wyjdz.getScene().getWindow().hide();
    }
}
