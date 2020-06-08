package Controller;

import Connection.Logowanie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Klasa LekarzGlownaController - kontroler do strony panelu głównego lekarza.
 */

public class LekarzGlownaController implements Initializable {
    @FXML
    public Button LogoutBT;
    @FXML
    public Button EdytujWizytyBT;
    @FXML
    public Button HistoriaWizytBT;
    @FXML
    public Button EdytujDaneBT;
    @FXML
    Label NazwaLL;

    /**
     * Metoda handleAktualneWizytyBTAction obsługująca przycisk do wyświetlania tabeli z przyszłymi wizytami lekarza
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleAktualneWizytyBTAction(ActionEvent event) throws IOException {
        Parent AW = FXMLLoader.load(getClass().getResource("/LekarzFXML/AktualneWizytyLekarz.fxml"));
        Stage AktualneWizyty = (Stage)((Node)event.getSource()).getScene().getWindow();
        AktualneWizyty.setScene(new Scene(AW));
        AktualneWizyty.show();

    }

    /**
     * Metoda handleHistoriaWizytBTAction obsługująca przycisk do wyświetlania tabeli z przeszłymi wizytami lekarza
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleHistoriaWizytBTAction(ActionEvent event) throws IOException {
        Parent HW = FXMLLoader.load(getClass().getResource("/LekarzFXML/HistoriaWizytLekarz.fxml"));
        Stage HistoriaWizyt = (Stage)((Node)event.getSource()).getScene().getWindow();
        HistoriaWizyt.setScene(new Scene(HW));
        HistoriaWizyt.show();
    }

    //TODO niegotowe

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        FXMLLoader ED = new FXMLLoader(getClass().getResource("/EdytujDane.fxml"));
        Stage EdytujDane = new Stage();
        EdytujDane.initOwner(EdytujDaneBT.getScene().getWindow());
        EdytujDane.setScene(new Scene((Parent) ED.load()));

        EdytujDane.showAndWait();
    }

    /**
     * Metoda handleLogoutBTAction obsługująca przycisk wylogowujący lekarza
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/GlownaFXML/Logowanie.fxml"));
        Stage Logowanie = (Stage)((Node)event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    /**
     * Metoda initialize inicjująca wyświetlenie danych lekarza w głównym panelu
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NazwaLL.setText("");
        NazwaLL.setText(Logowanie.ImieNazwiskoLekarzGet(LogowanieController.getKonto_ID()));
    }
}
