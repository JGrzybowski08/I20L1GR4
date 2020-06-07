package Controller;

import Connection.DodajPacjenta;
import Exceptions.RegisterException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;


public class DodajPacjentaController {

    Alert alertBlad = new Alert(Alert.AlertType.ERROR);

    Boolean WysBlad;

    String TrescBledu;

    @FXML
    private TextField ImieTF;
    @FXML
    private TextField PeselTF;
    @FXML
    private TextField NazwiskoTF;
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
    public void handleZarejestrujBTAction(MouseEvent event) {

        if(sprawdzPola()){
            alertBlad.setContentText(TrescBledu);
            alertBlad.showAndWait();
        }else{
            System.out.println("Poszło wszystko!");

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
                if(DodajPacjenta.Rejestruj(Imie, Nazwisko, Pesel, Telefon, Haslo, Miejscowosc, KodPocztowy, Ulica, NumerDomu)){
                    handleBackBTAction(event);
                }
            }catch(Exception e){
                System.err.println(e);
            }
        }
    }

    @FXML
    public void handleBackBTAction(MouseEvent event) throws IOException {
        Parent Re = FXMLLoader.load(getClass().getResource("/GlownaFXML/Logowanie.fxml"));
        Stage logowanie = (Stage)((Node)event.getSource()).getScene().getWindow();
        logowanie.setScene(new Scene(Re));
        logowanie.show();

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
