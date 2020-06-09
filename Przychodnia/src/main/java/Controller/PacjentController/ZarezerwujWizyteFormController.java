package Controller.PacjentController;

import Connection.Logowanie;
import Connection.PacjentCon.ZarezerwujWizyte;
import Connection.Polaczenie;
import Controller.LogowanieController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ZarezerwujWizyteFormController implements Initializable {
    public DatePicker DataDP;

    public ComboBox GodzinaCB;

    public TextField OpisTF;

    LocalDate Dzis = LocalDate.now();

    Boolean Powodzenie = false;

    public Label NazwaPP;


    @FXML
    public void handleExitBTAction(ActionEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/PacjentFXML/PacjentGlowna.fxml"));
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NazwaPP.setText("");
        NazwaPP.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));

        DataDP.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate Dzis = LocalDate.now();

                setDisable(empty || date.compareTo(Dzis) < 0 );
            }
        });

        DataDP.valueProperty().addListener((ov, oldValue, newValue) -> {
            System.err.println(getDzienTygodnia());
            System.err.println(getDataWizyty());

            GodzinaCB.getItems().clear();
            GodzinaCB.getItems().addAll(ZarezerwujWizyte.Godziny(getDataWizyty(), getDzienTygodnia(), ZarezerwujWizyteController.getLekarze()));
            GodzinaCB.getSelectionModel().select(0);

        });


    }

        @FXML
        public void handleZarezerwujBTAction(ActionEvent event) throws IOException {
            ZarezerwujWizyte.Zarezerwuj(getDataWizyty(), (String)GodzinaCB.getValue(), OpisTF.getText(), ZarezerwujWizyteController.getLekarze());

            Parent AG = FXMLLoader.load(getClass().getResource("/PacjentFXML/PacjentGlowna.fxml"));
            Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
            AdministratorGlowna.setScene(new Scene(AG));
            AdministratorGlowna.show();

        }

    public String getDataWizyty(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate DataLD = DataDP.getValue();

        String Data = formatter.format(DataLD);
        return Data;
    }

    public String getDzienTygodnia(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE");
        LocalDate DataLD = DataDP.getValue();

        String DzienTygodnia = formatter.format(DataLD);

        switch (DzienTygodnia){
            case "Pn":
                DzienTygodnia = "Poniedziałek";
                break;
            case "Wt":
                DzienTygodnia = "Wtorek";
                break;
            case "Śr":
                DzienTygodnia = "Środa";
                break;
            case "Cz":
                DzienTygodnia = "Czwartek";
                break;
            case "Pt":
                DzienTygodnia = "Piątek";
                break;
            case "So":
                DzienTygodnia = "Sobota";
                break;
            case "N":
                DzienTygodnia = "Niedziela";
                break;
        }

        return DzienTygodnia;
    }
}
