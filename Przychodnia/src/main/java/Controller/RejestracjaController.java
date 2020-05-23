package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class RejestracjaController {



    @FXML
    private TextField ImieID;
    @FXML
    private TextField NazwiskoID;
    @FXML
    private TextField PESELID;
    @FXML
    private TextField TelefonID;
    @FXML
    private TextField LoginID;
    @FXML
    private TextField HasloID;
    @FXML
    private Button RejestracjaID;



    @FXML
    public void handleDodawaniePacjentaBTAction(ActionEvent event){

        if(ImieID.getText().isEmpty() || NazwiskoID.getText().isEmpty() || PESELID.getText().isEmpty() || TelefonID.getText().isEmpty() || LoginID.getText().isEmpty() || HasloID.getText().isEmpty()){
            System.out.println("Jedno z pól jest puste");
        }else{

            String Imie = ImieID.getText();
            String Nazwisko = NazwiskoID.getText();
            String PESEL = PESELID.getText();
            String Telefon = TelefonID.getText();
            String Login = LoginID.getText();
            String Haslo = HasloID.getText();

            Connection.Rejestracja.Rejestrowanie(Imie, Nazwisko, PESEL, Telefon, Login, Haslo);

        }




    }


}
