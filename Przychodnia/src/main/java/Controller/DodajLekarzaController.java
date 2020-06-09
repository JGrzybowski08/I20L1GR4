package Controller;


import Connection.AdministratorCon.DodajLekarza;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * Klasa DodajLekarzaController - kontroler do obsługi rejestracji lekarza
 */

public class DodajLekarzaController {

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

    /**
     * Metoda handleDodawanieLekarzaBTAction obsługująca przycisk dodawania lekarza
     * @param event
     */

    @FXML
    public void handleDodawanieLekarzaBTAction(MouseEvent event) {

        if(sprawdzPola()){
            alertBlad.setContentText(TrescBledu);
            alertBlad.showAndWait();
        }else{
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
                if(DodajLekarza.Rejestruj(Imie, Nazwisko, Email, Pesel, Telefon, Specjalizacja, Haslo, Miejscowosc, KodPocztowy, Ulica, NumerDomu)){
                    handleBackBTAction(event);
                }
            }catch(Exception e){
                System.err.println(e);
            }
        }
    }

    /**
     * Metoda handleBackBTAction obsługująca przycisk odpowiadający za powrót do panelu głównego administratora
     * @param event
     * @throws IOException
     */

    @FXML
    public void handleBackBTAction(MouseEvent event) throws IOException {
        Parent AG = FXMLLoader.load(getClass().getResource("/AdministratorFXML/AdministratorGlowna.fxml"));
        Stage AdministratorGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        AdministratorGlowna.setScene(new Scene(AG));
        AdministratorGlowna.show();

    }

    /**
     * Metoda sprawdzPola odpowiadająca za sprawdzenie poprawności danych wprowadzonych przez administratora przy rejestracji lekarza
     * @return WysBlad - true, jeżeli wszystkie dane są wprowadzone poprawnie, w przeciwnym wypadku false z odpowiednim komunikatem
     */

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
