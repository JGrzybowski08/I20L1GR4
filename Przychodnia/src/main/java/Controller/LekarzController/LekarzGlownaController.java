package Controller.LekarzController;

import Connection.LekarzCon.GodzinyPracy;
import Connection.Logowanie;
import Controller.LogowanieController;
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
    @FXML
    Label poniedzialekGP;
    @FXML
    Label wtorekGP;
    @FXML
    Label srodaGP;
    @FXML
    Label czwartekGP;
    @FXML
    Label piatekGP;
    @FXML
    Label sobotaGP;


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

    /**
     * Metoda handleGodzinyPracyBTAction obsługująca przycisk do dodawania godzin pracy lekarza
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleGodzinyPracyBTAction(ActionEvent event) throws IOException {
        Parent GP = FXMLLoader.load(getClass().getResource("/LekarzFXML/DodajGodzinyPracy.fxml"));
        Stage GodzinyPracy = (Stage)((Node)event.getSource()).getScene().getWindow();
        GodzinyPracy.setScene(new Scene(GP));
        GodzinyPracy.show();
    }

    /**
     * Metoda handleEdytujDaneBTAction obsługująca przycisk do edytowania danych lekarza
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        Parent EDL = FXMLLoader.load(getClass().getResource("/LekarzFXML/EdytujDaneLekarz.fxml"));
        Stage EdytujDaneLekarz = (Stage)((Node)event.getSource()).getScene().getWindow();
        EdytujDaneLekarz.setScene(new Scene(EDL));
        EdytujDaneLekarz.show();
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



        poniedzialekGP.setText("");
        poniedzialekGP.setText(GodzinyPracy.WysGPPon());

        wtorekGP.setText("");
        wtorekGP.setText(GodzinyPracy.WysGPWt());

        srodaGP.setText("");
        srodaGP.setText(GodzinyPracy.WysGPSr());

        czwartekGP.setText("");
        czwartekGP.setText(GodzinyPracy.WysGPCzw());

        piatekGP.setText("");
        piatekGP.setText(GodzinyPracy.WysGPPt());

        sobotaGP.setText("");
        sobotaGP.setText(GodzinyPracy.WysGPSob());

        GodzinyPracy.SprawdzGodzinyPracy();
    }
}
