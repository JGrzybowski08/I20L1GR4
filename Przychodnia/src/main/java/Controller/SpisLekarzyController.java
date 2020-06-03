package Controller;

import Connection.SpisLekarzy;
import Models.ModelZobaczLekarzy;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SpisLekarzyController implements Initializable {

    public TableView<ModelZobaczLekarzy> SpisLekarzyTV;
    public TableColumn<ModelZobaczLekarzy, String> ImieTC;
    public TableColumn<ModelZobaczLekarzy, String> NazwiskoTC;
    public TableColumn<ModelZobaczLekarzy, String> EMailTC;
    public TableColumn<ModelZobaczLekarzy, Long> PeselTC;
    public TableColumn<ModelZobaczLekarzy, Integer> TelefonTC;
    public TableColumn<ModelZobaczLekarzy, String> SpecjalizacjaTC;
    public TableColumn<ModelZobaczLekarzy, String> KodPocztowyTC;
    public TableColumn<ModelZobaczLekarzy, String> MiejscowoscTC;
    public TableColumn<ModelZobaczLekarzy, String> UlicaTC;
    public TableColumn<ModelZobaczLekarzy, String> NumerDomuTC;



    @FXML
    private Button ExitBT;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/AdministratorGlowna.fxml"));
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }
}
