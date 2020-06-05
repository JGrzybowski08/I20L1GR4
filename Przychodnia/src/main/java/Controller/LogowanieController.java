package Controller;

import Connection.Logowanie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogowanieController {
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

    static int Login;
    static String Haslo;
    private static int Konto_ID;
    public String Konto_Up;

    public static int getKonto_ID() {
        return Konto_ID;
    }

    public static void setKonto_ID(int konto_ID) {
        Konto_ID = Logowanie.IdGet(Login, Haslo);
    }

    @FXML
    public void handleLoginBTAction(ActionEvent event) {
        Login = Integer.parseInt(LoginTF.getText());
        Haslo = HasloTF.getText();

        Konto_ID = Logowanie.IdGet(Login, Haslo);
        Konto_Up = Logowanie.UprawnieniaGet(Login, Haslo);

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
                }catch(Exception e){
                    System.err.println(e);
                }
                break;
            case "Lekarz":
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/LekarzGlowna.fxml"));
                    Parent root = (Parent) loader.load();
                    Stage LekarzGlowna = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    LekarzGlowna.setScene(new Scene(root));
                    LekarzGlowna.show();
                }catch(Exception e){
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
                }catch(Exception e){
                    System.out.println(e);
                }
                break;
        }

    }

    @FXML
    public void handleRejestracjaBTAction(MouseEvent event) throws IOException {
        Parent Re = FXMLLoader.load(getClass().getResource("/Rejestracja.fxml"));
        Stage Rejestracja = (Stage)((Node)event.getSource()).getScene().getWindow();
        Rejestracja.setScene(new Scene(Re));
        Rejestracja.show();

    }
}
