package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class TelaInicialController implements Initializable   {

    @FXML
    private AnchorPane rootPane;
    
    @FXML
    MenuButton sindico;
   
    
    @Override
    public void initialize (URL url,ResourceBundle rb){
        
        if(LoginController.nivelAcessoUsuarioLogado == 2 ){
            this.sindico.setVisible(false);
            
        }else{  
            
            this.sindico.setVisible(true); 
            
        }  
    }
    
    @FXML
    private void agenda(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("agenda" + ".fxml")).load();

        rootPane.getChildren().add(newLoadedPane);
        

    }

    @FXML
    private void fornecedores(ActionEvent event) throws IOException {
       
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("fornecedores" + ".fxml")).load();    

        rootPane.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void notificacoes(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("notificacoes" + ".fxml")).load();    

        rootPane.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void espacos(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("espacos" + ".fxml")).load();  //Sem tela ainda

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void financeiropendencias(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("financeiropendencias" + ".fxml")).load();  //Sem tela ainda

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void financeiroextrato(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("financeiroextrato" + ".fxml")).load();  //Sem tela ainda

        rootPane.getChildren().add(newLoadedPane);
        
    }
     
        
    @FXML
    private void CadastroMoradores(ActionEvent event) throws IOException {
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("moradores" + ".fxml")).load();  

        rootPane.getChildren().add(newLoadedPane);
    }
    
    @FXML
    private void CadastroFornecedores(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("fornecedores" + ".fxml")).load();  

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void UpdateNotificacoes(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("notificacoes" + ".fxml")).load();  

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void moradores(ActionEvent event) throws IOException {
        
        Pane newLoadedPane = new FXMLLoader(App.class.getResource("moradores" + ".fxml")).load();

        rootPane.getChildren().add(newLoadedPane);
        
    }
    
    @FXML
    private void sair(ActionEvent event) throws IOException {
        
        App.closeCurrentWindow();
              
    }
}