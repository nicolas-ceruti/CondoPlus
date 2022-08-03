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

public class FornecedoresController implements Initializable {
    
    static Fornecedor cadastrofornecedores;
    
    @FXML
    Button Bntalterar;
    
    @FXML
    Button bntDelete;
    
    @FXML
    Button bntCriar;
    
    @FXML
    private TableView <Fornecedor> fornecedoresTabela;
    
    @FXML
    private TableColumn <Fornecedor, String> nomeFornecedorColumn;
    
    @FXML
    private TableColumn <Fornecedor, String> telefoneFornecedorColumn;
    
    @FXML
    private TableColumn <Fornecedor, String> categoriaFornecedorColumn;
    
    @FXML
    private TableColumn <Fornecedor, String> precoFornecedorColumn;  
    
    static ObservableList <Fornecedor> cadastroFornecedores;
    
    @Override
    public void initialize (URL url,ResourceBundle rb){
        
        if(LoginController.nivelAcessoUsuarioLogado == 2 ){
            this.bntDelete.setVisible(false);
            this.Bntalterar.setVisible(false);
            this.bntCriar.setVisible(false);
            
        }else{    
        }  
    
        
        this.nomeFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.telefoneFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        this.categoriaFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.precoFornecedorColumn.setCellValueFactory(new PropertyValueFactory<>("preco"));        
        
        this.cadastroFornecedores = this.fornecedoresTabela.getItems();
        
        FornecedorDAO daoDoFornecedor = new FornecedorDAO();
        List <Fornecedor> fornecedorNoBanco = daoDoFornecedor.getAll();
        
        this.cadastroFornecedores.addAll(fornecedorNoBanco);
        
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        App.setRoot("telaInicial");

    }
    
    @FXML
    void novoFornecedor(ActionEvent event) throws IOException {
        
        CadastroDeFornecedoresController.setFornecedores(null);
        
        App.showModal("cadastroDeFornecedores");
        
        Fornecedor novoFornecedor = CadastroDeFornecedoresController.getFornecedores();
        if (novoFornecedor != null){
            
            this.cadastroFornecedores.add(novoFornecedor);
            
            FornecedorDAO daoDoFornecedor = new FornecedorDAO();
            daoDoFornecedor.save(novoFornecedor);
            
            List<Fornecedor> fornecedores = daoDoFornecedor.getAll();
            this.cadastroFornecedores.clear();
            this.cadastroFornecedores.addAll(fornecedores);

            

            
        }    
    }
    
    @FXML
    void remover() throws IOException{
        
        Fornecedor fornecedorSelecionado = this.fornecedoresTabela.getSelectionModel().getSelectedItem();
        
        // Confirmação de remoção
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remoção");
        alert.setHeaderText("Deseja remover " + fornecedorSelecionado.getNome());
        alert.setContentText("Deseja remover o fornecedor?");

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            
            this.cadastroFornecedores.remove(fornecedorSelecionado);
            
            FornecedorDAO daoDoFornecedor = new FornecedorDAO();
            daoDoFornecedor.delete(fornecedorSelecionado);
        
        }     
    } 
    
    @FXML
    void editar() throws IOException {
        
        Fornecedor fornecedorSelecionado = this.fornecedoresTabela.getSelectionModel().getSelectedItem();
        
        if (fornecedorSelecionado != null) {
            CadastroDeFornecedoresController.setFornecedores(fornecedorSelecionado)  ;
            
            App.showModal("cadastroDeFornecedores");  //EXECUÇÃO PARA E SÓ CONTINUA QUANDO EU FECHAR O MODAL
            
            Fornecedor fornecedorAlterado = CadastroDeFornecedoresController.getFornecedores();
            
            fornecedorSelecionado.setNome (fornecedorAlterado.getNome());
            fornecedorSelecionado.setTelefone (fornecedorAlterado.getTelefone());
            fornecedorSelecionado.setCategoria (fornecedorAlterado.getCategoria());
            fornecedorSelecionado.setPreco (fornecedorAlterado.getPreco());
            
            this.fornecedoresTabela.refresh ();
            
            FornecedorDAO daoDoFornecedor = new FornecedorDAO();
            daoDoFornecedor.update(fornecedorAlterado);
            
        }
    }
}