package Controller.PacjentController;

import Connection.PacjentCon.EdytujDanePacjent;
import Connection.Logowanie;
import Controller.LogowanieController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Klasa EdytujDanePacjentController - kontroler obsługujący panel edytowania danych pacjenta
 */

public class EdytujDanePacjentController implements Initializable {

    /**
     * @param alertBlad
     * @param WysBlad
     * @param TrescBledu
     */

    Alert alertBlad = new Alert(Alert.AlertType.ERROR);

    Boolean WysBlad;

    String TrescBledu;

    @FXML
    private TextField ImieTF;
    @FXML
    private TextField NazwiskoTF;
    @FXML
    private TextField PeselTF;
    @FXML
    private TextField TelefonTF;
    @FXML
    private PasswordField HasloPF;
    @FXML
    private PasswordField PotHasloPF;
    @FXML
    private TextField MiejscowoscTF;
    @FXML
    private TextField KodPocztowyTF;
    @FXML
    private TextField UlicaTF;
    @FXML
    private TextField NumerDomuTF;
    @FXML
    Label NazwaPL;

    /**
     * Metoda initialize inicjująca wypełnienie tabel danymi oraz wyświetlanie danych pacjenta
     * @param location
     * @param resources
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NazwaPL.setText("");
        NazwaPL.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));

        wypelnijPola(EdytujDanePacjent.PobierzDanePacjent());

    }

    public void wypelnijPola(List<String> DanePacjenta){
        ImieTF.setText(DanePacjenta.get(0));//Imie
        NazwiskoTF.setText(DanePacjenta.get(1));//Nazwisko
        PeselTF.setText(DanePacjenta.get(2));//PESEL
        TelefonTF.setText(DanePacjenta.get(3));//Telefon
        KodPocztowyTF.setText(DanePacjenta.get(4));//Kod_pocztowy
        MiejscowoscTF.setText(DanePacjenta.get(5));//Miejscowosc
        UlicaTF.setText(DanePacjenta.get(6));//Ulica
        NumerDomuTF.setText(DanePacjenta.get(7));//Numer_Domu
        HasloPF.setText(DanePacjenta.get(8));//Haslo
    }

    @FXML
    public void handleEdytujBTAction(ActionEvent event) throws IOException {
        if(sprawdzPola()){
            alertBlad.setContentText(TrescBledu);
            alertBlad.showAndWait();
        }else {
            String Imie = ImieTF.getText();
            String Nazwisko = NazwiskoTF.getText();
            String Pesel = PeselTF.getText();
            String Telefon = TelefonTF.getText();
            String Haslo = HasloPF.getText();
            String Miejscowosc = MiejscowoscTF.getText();
            String KodPocztowy = KodPocztowyTF.getText();
            String Ulica = UlicaTF.getText();
            String NumerDomu = NumerDomuTF.getText();
            try {
                EdytujDanePacjent.EdytujDane(Imie, Nazwisko, Pesel, Telefon, Miejscowosc, KodPocztowy, Ulica, NumerDomu, Haslo);
                wypelnijPola(EdytujDanePacjent.PobierzDanePacjent());
                NazwaPL.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    @FXML
    public void handleBackBTAction(ActionEvent event) throws IOException {
        Parent PG = FXMLLoader.load(getClass().getResource("/PacjentFXML/PacjentGlowna.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(PG));
        PacjentGlowna.show();

    }

    public Boolean sprawdzPola(){
        WysBlad = false;
        TrescBledu = "";

        alertBlad.setTitle("Błąd przy edytowaniu danych pacjenta");
        alertBlad.setHeaderText("Wystąpiły następujące błędy: ");

        if(ImieTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole imie jest puste!\n");
            WysBlad = true;
        }

        if(NazwiskoTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole nazwisko jest puste!\n");
            WysBlad = true;
        }

        if(TelefonTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole numer jest puste!\n");
            WysBlad = true;
        }

        if(TelefonTF.getText().length() != 9){
            TrescBledu = TrescBledu + ("Pole numer ma złą długość!\n");
            WysBlad = true;
        }

        if(PeselTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole PESEL jest puste!\n");
            WysBlad = true;
        }

        if(PeselTF.getText().length() != 11){
            TrescBledu = TrescBledu + ("Pole PESEL ma złą długość!\n");
            WysBlad = true;
        }

        if(HasloPF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole hasło jest puste!\n");
            WysBlad = true;
        }

        if(PotHasloPF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole potwierdź hasło jest puste!\n");
            WysBlad = true;
        }

        if(!(PotHasloPF.getText().equals(HasloPF.getText()))){
            TrescBledu = TrescBledu + ("Wpisane hasła są różne!\n");
            WysBlad = true;
        }

        if(MiejscowoscTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole miejscowosc jest puste!\n");
            WysBlad = true;
        }

        if(KodPocztowyTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole kod pocztowy jest puste!\n");
            WysBlad = true;
        }

        if(KodPocztowyTF.getText().length() != 6){
            TrescBledu = TrescBledu + ("Pole kod pocztowy ma złą długość!\n");
            WysBlad = true;
        }

        if(UlicaTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole ulica jest puste!\n");
            WysBlad = true;
        }

        if(NumerDomuTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole numer domu jest puste!\n");
            WysBlad = true;
        }

        return WysBlad;

    }
}
