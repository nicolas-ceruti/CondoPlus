package com.mycompany.zcondo;

import static com.mycompany.zcondo.CadastroDeMoradoresController.morador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroDeFornecedoresController implements Initializable {
   
    static Fornecedor fornecedor;

    @FXML
    TextField nomeTextField;
    
    @FXML
    TextField categoriaTextField;      
    
    @FXML
    TextField CPFTextField;
    
    @FXML
    TextField RGTextField;
    
    @FXML
    TextField precoTextField;
    
    @FXML
    TextField telefoneTextfield;
    
    @FXML
    TextField emailTextField;  
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
       
        if (fornecedor != null){
          
            nomeTextField.setText(fornecedor.getNome());
            categoriaTextField.setText(fornecedor.getCategoria());
            CPFTextField.setText(fornecedor.getCpf());
            RGTextField.setText(fornecedor.getRg());
            precoTextField.setText(Double.toString(fornecedor.getPreco()));
            telefoneTextfield.setText(fornecedor.getTelefone());
            emailTextField.setText(fornecedor.getEmail());
            
        }
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) nomeTextField.getScene().getWindow();
        App.closeWindow(stage);
    }
    
    static Fornecedor getFornecedores (){ 
        return fornecedor;  
    }

    static void setFornecedores (Fornecedor cadastrofornecedores){  
        CadastroDeFornecedoresController.fornecedor = cadastrofornecedores;      
    }
    
    @FXML
    void btnSalvar(ActionEvent event) {
        
        if(!this.nomeTextField.getText().isEmpty()//
                && !this.CPFTextField.getText().isEmpty()//
                    && !this.categoriaTextField.getText().isEmpty()   
                        && !this.RGTextField.getText().isEmpty()
                            && !this.precoTextField.getText().isEmpty()//
                                && !this.telefoneTextfield.getText().isEmpty()//
                                    && !this.emailTextField.getText().isEmpty()){
            
            Fornecedor fornecedorEditado = new Fornecedor (
                    
                fornecedor == null ? 0 : fornecedor.id,
                this.nomeTextField.getText(),
                this.categoriaTextField.getText(),
                this.CPFTextField.getText(),
                this.RGTextField.getText(),
                Double.parseDouble(this.precoTextField.getText()),
                this.telefoneTextfield.getText(),
                this.emailTextField.getText());
            
            fornecedor = fornecedorEditado;
            
            Stage stage = (Stage) nomeTextField.getScene().getWindow();
            App.closeWindow(stage);
        
        }
    }        
}