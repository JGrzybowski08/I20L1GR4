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

public class PacjentGlownaController implements Initializable {

    int ID;

    @FXML
    private Button LogoutBT;
    @FXML
    private Button DodajWizyteBT;
    @FXML
    private Button ZobaczWizytyBT;
    @FXML
    private Button HistoriaWizytBT;
    @FXML
    private Button EdytujDaneBT;
    @FXML
    private Label IDL;

    @FXML
    Label NazwaPL;

    @FXML
    public void handleDodajWizyteBTAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DodajWizyte.fxml"));
            Parent root = (Parent) loader.load();

            DodajWizyteController DWC = loader.getController();
            DWC.setID(ID);

            Stage DodajWizyte = (Stage) ((Node) event.getSource()).getScene().getWindow();
            DodajWizyte.setScene(new Scene(root));
            DodajWizyte.showAndWait();
        }catch(Exception e){
            System.err.println(e);
        }

    }

    @FXML
    public void handleZobaczWizytyBTAction(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SpisWizytPacjent.fxml"));
            Parent root = (Parent) loader.load();

            //ZobaczWizytyController ZWC = loader.getController();
           // ZWC.setID(ID);

            Stage ZobaczWizyty = (Stage) ((Node) event.getSource()).getScene().getWindow();
            ZobaczWizyty.setScene(new Scene(root));
            ZobaczWizyty.showAndWait();
        }catch(Exception e){
            System.err.println(e);
        }

    }

    @FXML
    public void handleHistoriaWizytBTAction(ActionEvent event) throws IOException {
        FXMLLoader HW = new FXMLLoader(getClass().getResource("/HistoriaWizyt.fxml"));
        Stage HistoriaWizyt = new Stage();
        HistoriaWizyt.initOwner(HistoriaWizytBT.getScene().getWindow());
        HistoriaWizyt.setScene(new Scene((Parent) HW.load()));

        HistoriaWizyt.showAndWait();

    }

    @FXML
    public void handleEdytujDaneBTAction(ActionEvent event) throws IOException {
        FXMLLoader ED = new FXMLLoader(getClass().getResource("/EdytujDane.fxml"));
        Stage EdytujDane = new Stage();
        EdytujDane.initOwner(EdytujDaneBT.getScene().getWindow());
        EdytujDane.setScene(new Scene((Parent) ED.load()));

        EdytujDane.showAndWait();
    }

    @FXML
    public void handleLogoutBTAction(ActionEvent event) throws IOException {
        Parent L = FXMLLoader.load(getClass().getResource("/GlownaFXML/Logowanie.fxml"));
        Stage Logowanie = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Logowanie.setScene(new Scene(L));
        Logowanie.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NazwaPL.setText("");
        NazwaPL.setText(Logowanie.ImieNazwiskopacjentGet(LogowanieController.getKonto_ID()));
    }
}
