package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FinanceiroController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        App.setRoot("telaInicial");
        
    }
    
}
