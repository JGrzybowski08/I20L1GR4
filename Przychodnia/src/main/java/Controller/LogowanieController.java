package Controller;

import Connection.Logowanie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogowanieController {

    Alert alertBlad = new Alert(Alert.AlertType.ERROR);

    Boolean WysBlad;

    String TrescBledu;

    @FXML
    public Button ExitBT;
    public Button LoginBT;
    public GridPane PacjentGlownaFXML;

    @FXML
    public void handleExitBTAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public TextField LoginTF;

    @FXML
    public PasswordField HasloTF;

    static String Login;
    static String Haslo;
    private static int Konto_ID;
    public String Konto_Up;

    public static int getKonto_ID() {
        return Konto_ID;
    }

    public static void setKonto_ID(int konto_ID) {
        Konto_ID = Logowanie.IdGet(Integer.parseInt(Login), Haslo);
    }

    @FXML
    public void handleLoginBTAction(ActionEvent event) {
        Login = LoginTF.getText();
        Haslo = HasloTF.getText();

        if(sprawdzPola()) {
            alertBlad.setContentText(TrescBledu);
            alertBlad.showAndWait();
        }else{

            Konto_ID = Logowanie.IdGet(Integer.parseInt(Login), Haslo);
            Konto_Up = Logowanie.UprawnieniaGet(Integer.parseInt(Login), Haslo);

            System.out.println(Konto_ID);
            System.out.println(Konto_Up);


            switch (Konto_Up) {
                case "Administrator":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AdministratorFXML/AdministratorGlowna.fxml"));
                        Parent root = (Parent) loader.load();
                        Stage AdministratorGlowna = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        AdministratorGlowna.setScene(new Scene(root));
                        AdministratorGlowna.show();
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "Lekarz":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LekarzFXML/LekarzGlowna.fxml"));
                        Parent root = (Parent) loader.load();
                        Stage LekarzGlowna = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        LekarzGlowna.setScene(new Scene(root));
                        LekarzGlowna.show();
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "Pacjent":
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/PacjentGlowna.fxml"));
                        Parent root = (Parent) loader.load();
                        Stage PacjentGlowna = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        PacjentGlowna.setScene(new Scene(root));
                        PacjentGlowna.show();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
            }
        }
    }

    @FXML
    public void handleRejestracjaBTAction(MouseEvent event) throws IOException {
        Parent Re = FXMLLoader.load(getClass().getResource("/GlownaFXML/DodajPacjenta.fxml"));
        Stage Rejestracja = (Stage)((Node)event.getSource()).getScene().getWindow();
        Rejestracja.setScene(new Scene(Re));
        Rejestracja.show();

    }

    public Boolean sprawdzPola(){
        WysBlad = false;
        TrescBledu = "";

        alertBlad.setTitle("Błąd przy rejestracji lekarza!");
        alertBlad.setHeaderText("Wystąpiły następujące błędy: ");

        if(LoginTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole login jest puste!\n");
            WysBlad = true;
        }

        if(HasloTF.getText().isEmpty()){
            TrescBledu = TrescBledu + ("Pole hasło jest puste!\n");
            WysBlad = true;
        }

        if(!Logowanie.SprawdzHaslo(Login, Haslo)){
            TrescBledu = TrescBledu + ("Złe hasło!\n");
            WysBlad = true;
        }
        return WysBlad;
    }
}
