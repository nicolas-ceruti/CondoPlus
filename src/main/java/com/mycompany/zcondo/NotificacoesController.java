package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class NotificacoesController implements Initializable {
    
    static Notificacao notificacao;
    
    @FXML
    Button bntDelete;
    
    @FXML 
    Button Bntalterar;
    
    
    @FXML
    private TableView<Notificacao> notificacaoTabela;
     
    @FXML
    private TableColumn<Notificacao, String> moradorNotificacaoColumn;
    
    @FXML
    private TableColumn<Notificacao, String> mensagemNotificacaoColumn;      //Declaração da tabela
    
    @FXML
    private TableColumn<Notificacao, String> dataNotificacaoColumn;
     
    static ObservableList<Notificacao> notificacoes;
     
    @Override
    public void initialize (URL url,ResourceBundle rb){
        
        if(LoginController.nivelAcessoUsuarioLogado == 2 ){
            this.bntDelete.setVisible(false);
            this.Bntalterar.setVisible(false);

        }else{    
        }  

        
        this.moradorNotificacaoColumn.setCellValueFactory(new PropertyValueFactory<>("emissor"));
        this.mensagemNotificacaoColumn.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.dataNotificacaoColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
 
        NotificacoesController.notificacoes = this.notificacaoTabela.getItems();
         
                
        NotificacaoDAO notificaDAO = new NotificacaoDAO();
        List<Notificacao> notificacoesDatabase = notificaDAO.getAll();
        
        this.notificacoes.addAll(notificacoesDatabase);
        

    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
       
        App.setRoot("telaInicial");
        
    }
    
    
    @FXML
    void remover() throws IOException{
        
        Notificacao notificacaoSelecionada = this.notificacaoTabela.getSelectionModel().getSelectedItem();
        
        // Confirmação de remoção
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remoção");
        alert.setHeaderText(notificacaoSelecionada.getEmissor() + "/n " + notificacaoSelecionada.getDescricao());
        alert.setContentText("Deseja remover a notificação?");

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            
            this.notificacoes.remove(notificacaoSelecionada);
            
            NotificacaoDAO daoDaNotificacao = new NotificacaoDAO();
            daoDaNotificacao.delete(notificacaoSelecionada);
        }       
    }
    
    @FXML
    void editar() throws IOException {
       
        Notificacao notificacaoSelecionada = this.notificacaoTabela.getSelectionModel().getSelectedItem();
        
        if (notificacaoSelecionada != null) {
            NovaNotificacaoController.setNotificacao(notificacaoSelecionada)  ;
            
            App.showModal("novaNotificacao");  //EXECUÇÃO PARA E SÓ CONTINUA QUANDO EU FECHAR O MODAL
            
            Notificacao notificacaoAlterada = NovaNotificacaoController.getNotificacao();
            
            notificacaoSelecionada.setEmissor (notificacaoAlterada.getEmissor());
            notificacaoSelecionada.setDescricao (notificacaoAlterada.getDescricao());
            
            this.notificacaoTabela.refresh();
            
            NotificacaoDAO daoDaNotificacao = new NotificacaoDAO();
            daoDaNotificacao.update(notificacaoSelecionada);
        }
    }
    
    @FXML
    void novaNotificacao(ActionEvent event) throws IOException {
        
        NovaNotificacaoController.setNotificacao(null);
        
        App.showModal("novaNotificacao");
        
        Notificacao novaNotificacao = NovaNotificacaoController.getNotificacao();
        if (novaNotificacao != null){
            
            this.notificacoes.add(novaNotificacao);
            
            NotificacaoDAO daoDaNotificacao = new NotificacaoDAO();
            daoDaNotificacao.save(novaNotificacao);
            
            List<Notificacao> notificacoes = daoDaNotificacao.getAll();
            this.notificacoes.clear();
            this.notificacoes.addAll(notificacoes);

            
        }    
    }
        
} 
