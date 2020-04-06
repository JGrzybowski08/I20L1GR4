package Przychodnia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Logowanie.fxml"));
        primaryStage.setTitle("Przychodnia");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public Button ExitBT;
    public Button LoginBT;
    public GridPane PacjentGlownaFXML;

    @FXML
    public void handleExitBTAction(ActionEvent event) {
        System.exit(0);
    }



    @FXML
    public void handleLoginBTAction(ActionEvent event) throws IOException {
        Parent PG = FXMLLoader.load(getClass().getResource("FXML/PacjentGlowna.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(PG));
        PacjentGlowna.show();

    }
    @FXML
    public void handleLoginLekarzBTAction(ActionEvent event) throws IOException {
        Parent PG = FXMLLoader.load(getClass().getResource("FXML/LekarzGlowna.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(PG));
        PacjentGlowna.show();

    }
    @FXML
    public void handleLoginAdministratorBTAction(ActionEvent event) throws IOException {
        Parent PG = FXMLLoader.load(getClass().getResource("FXML/AdministratorGlowna.fxml"));
        Stage PacjentGlowna = (Stage)((Node)event.getSource()).getScene().getWindow();
        PacjentGlowna.setScene(new Scene(PG));
        PacjentGlowna.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
