package com.mycompany.zcondo;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    @FXML
    TextField usuarioTextField;
    
    @FXML
    PasswordField senhaPasswordField;
    
    static int nivelAcessoUsuarioLogado;
    
    
    @FXML
    void login() throws IOException{
        MoradorDAO dao = new MoradorDAO();
        Morador usuarioLogin = new Morador (usuarioTextField.getText(), senhaPasswordField.getText());      //Construtor usado no objeto Morador
        boolean usuarioExiste = dao.exists(usuarioLogin);

        if (usuarioExiste) {
            /*
            Caso o usuário exista leva para a tela principal
            */
            
            MoradorDAO login = new MoradorDAO();
            nivelAcessoUsuarioLogado = login.retornarNivel(usuarioTextField.getText(), senhaPasswordField.getText());
            
            MoradorDAO moradorDao = new MoradorDAO();
            boolean switchPassword = moradorDao.firstAcess(usuarioLogin);
                    
            if (switchPassword){
                SwitchPasswordController.setMoradorToSwitchPassword(usuarioLogin);

                App.showModal("switchPassword");
            }
            
            

            Stage stage = (Stage) this.usuarioTextField.getScene().getWindow();
            stage.setWidth(1000);
            stage.setHeight(600);
            stage.setMaximized(false);
            stage.setResizable(false);

            App.setRoot("telaInicial");
        }else{
            
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Usuario ou senha incorreta! ");
            alert.setContentText("Tente novamente");

            alert.showAndWait();
            
        }
    }
    

    @FXML
    public void onUserTyped() {
        //System.out.println("Tecla digitada no campo usuário");
    }
    
}