package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.io.IOException;

public class DodajLekarzaController {


    @FXML
    private TextField LabelId;
    @FXML
    private TextField LabelSpec;
    @FXML
    private Button Wyjdz;
    @FXML
    private Button DodawanieLekarza;
    @FXML
    public void handleWyjdzBTAction(ActionEvent event) throws IOException {
        Wyjdz.getScene().getWindow().hide();
    }
    @FXML
    public void handleDodawanieLekarzaBTAction(ActionEvent event){
       if(LabelId.getText().isEmpty() || LabelSpec.getText().isEmpty()){
           System.out.println("Jedno z pól jest puste");
       }else {
           String specText = LabelSpec.getText();
           String idText = LabelId.getText();

           Connection.DodawanieLekarza.Dodawanie(idText, specText);

       }

    }



}
