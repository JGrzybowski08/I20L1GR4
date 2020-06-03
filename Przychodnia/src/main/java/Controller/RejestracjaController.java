package Controller;

import Exceptions.RegisterException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class RejestracjaController {



    @FXML
    private TextField ImieID;
    @FXML
    private TextField EmailID;
    @FXML
    private TextField PeselID;
    @FXML
    private TextField NazwiskoID;
    @FXML
    private TextField TelefonID;
    @FXML
    private TextField LoginID;
    @FXML
    private PasswordField HasloID;



    @FXML
    public void handleDodawaniePacjentaBTAction(MouseEvent event) throws IOException, RegisterException {

        if(ImieID.getText().isEmpty() || NazwiskoID.getText().isEmpty() || EmailID.getText().isEmpty() || TelefonID.getText().isEmpty() || LoginID.getText().isEmpty() || HasloID.getText().isEmpty() || PeselID.getText().isEmpty()){
            System.out.println("Jedno z pól jest puste");
        }else{

            String Imie = ImieID.getText();
            String Nazwisko = NazwiskoID.getText();
            String Email = EmailID.getText();
            String Pesel = PeselID.getText();
            String Telefon = TelefonID.getText();
            String Haslo = HasloID.getText();

            Connection.Rejestracja.Rejestrowanie(Imie, Nazwisko, Email, Pesel, Telefon, Haslo);
            handleBackBTAction(event);
        }
    }

    @FXML
    public void handleBackBTAction(MouseEvent event) throws IOException {
        Parent Re = FXMLLoader.load(getClass().getResource("/Logowanie.fxml"));
        Stage logowanie = (Stage)((Node)event.getSource()).getScene().getWindow();
        logowanie.setScene(new Scene(Re));
        logowanie.show();

    }
}
