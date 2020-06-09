package Controller.LekarzController;

import Connection.LekarzCon.EdytujDaneLekarz;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.omg.CORBA.PERSIST_STORE;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class EdytujDaneLekarzController implements Initializable {

    Alert alertBlad = new Alert(Alert.AlertType.ERROR);

    Boolean WysBlad;

    String TrescBledu;

    @FXML
    private TextField ImieTF;
    @FXML
    private TextField EmailTF;
    @FXML
    private TextField PeselTF;
    @FXML
    private TextField NazwiskoTF;
    @FXML
    private TextField TelefonTF;
    @FXML
    private TextField SpecjalizacjaTF;
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
    Label NazwaLL;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NazwaLL.setText("");
        NazwaLL.setText(Logowanie.ImieNazwiskoLekarzGet(LogowanieController.getKonto_ID()));

        wypełnijPola(EdytujDaneLekarz.PobierzDaneLekarz());

    }

    public void wypełnijPola(List<String> DaneLekarza){
        ImieTF.setText(DaneLekarza.get(0));//Imie
        NazwiskoTF.setText(DaneLekarza.get(1));//Nazwisko
        EmailTF.setText(DaneLekarza.get(2));//Email
        PeselTF.setText(DaneLekarza.get(3));//PESEL
        TelefonTF.setText(DaneLekarza.get(4));//Telefon
        SpecjalizacjaTF.setText(DaneLekarza.get(5));//Specjalizacja
        KodPocztowyTF.setText(DaneLekarza.get(6));//Kod_pocztowy
        MiejscowoscTF.setText(DaneLekarza.get(7));//Miejscowosc
        UlicaTF.setText(DaneLekarza.get(8));//Ulica
        NumerDomuTF.setText(DaneLekarza.get(9));//Numer_Domu
        HasloPF.setText(DaneLekarza.get(10));//Haslo
    }

    @FXML
    public void handleEdytujBTAction(ActionEvent event) throws IOException {
        if(sprawdzPola()){
            alertBlad.setContentText(TrescBledu);
            alertBlad.showAndWait();
        }else {
            String Imie = ImieTF.getText();
            String Nazwisko = NazwiskoTF.getText();
            String Email = EmailTF.getText();
            String Pesel = PeselTF.getText();
            String Telefon = TelefonTF.getText();
            String Specjalizacja = SpecjalizacjaTF.getText();
            String Haslo = HasloPF.getText();
            String Miejscowosc = MiejscowoscTF.getText();
            String KodPocztowy = KodPocztowyTF.getText();
            String Ulica = UlicaTF.getText();
            String NumerDomu = NumerDomuTF.getText();
            try {
                EdytujDaneLekarz.EdytujDane(Imie, Nazwisko, Email, Pesel, Telefon, Specjalizacja, Miejscowosc, KodPocztowy, Ulica, NumerDomu, Haslo);
                wypełnijPola(EdytujDaneLekarz.PobierzDaneLekarz());
                NazwaLL.setText(Logowanie.ImieNazwiskoLekarzGet(LogowanieController.getKonto_ID()));
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    @FXML
    public void handleBackBTAction(ActionEvent event) throws IOException {
        Parent LG = FXMLLoader.load(getClass().getResource("/LekarzFXML/LekarzGlowna.fxml"));
        Stage LekarzGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        LekarzGlowna.setScene(new Scene(LG));
        LekarzGlowna.show();

    }

    public Boolean sprawdzPola(){
        WysBlad = false;
        TrescBledu = "";

        alertBlad.setTitle("Błąd przy rejestracji lekarza!");
        alertBlad.setHeaderText("Wystąpiły następujące błędy: ");

        if(ImieTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole imie jest puste!\n");
            WysBlad = true;
        }

        if(NazwiskoTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole nazwisko jest puste!\n");
            WysBlad = true;
        }

        if(EmailTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole e-mail jest puste!\n");
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

        if(SpecjalizacjaTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole specjalizacja jest puste!\n");
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
