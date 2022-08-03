
package com.mycompany.zcondo;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class SwitchPasswordController {
    
    static Morador moradorToSwitchPassword;
    
    @FXML
    PasswordField senhaPasswordField;
    
    @FXML
    PasswordField confrimacaoDeSenhaPasswordField;

    public static Morador getMoradorToSwitchPassword() {
        return moradorToSwitchPassword;
    }

    public static void setMoradorToSwitchPassword(Morador moradorToSwitchPassword) {
        SwitchPasswordController.moradorToSwitchPassword = moradorToSwitchPassword;
    }
    

    @FXML
    void switchPassword() throws IOException{

        
        if (senhaPasswordField.getText().equals(confrimacaoDeSenhaPasswordField.getText())){ 
        
            MoradorDAO moradorDAO = new MoradorDAO(); 
            moradorDAO.switchPassword(moradorToSwitchPassword, senhaPasswordField.getText());

            Stage stage = (Stage) senhaPasswordField.getScene().getWindow();
            App.closeWindow(stage);

        }else{
            // Confirmação de remoção
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erro");
    //        alert.setHeaderText("As senhas não coincidem");
            alert.setContentText("As senhas não coincidem");
            
            alert.showAndWait();
        }
    }       

    
}
    

