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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MoradoresController implements Initializable {
    
    static Morador cadastromoradores;
    
    @FXML
    private TableView <Morador> moradoresTabela;
    
    @FXML
    private TableColumn <Morador, String> nomeMoradorColumn;
    
    @FXML
    private TableColumn <Morador, String> apartamentoMoradorColumn;
    
    static ObservableList <Morador> cadastroMoradores;
    
    @Override
    public void initialize (URL url,ResourceBundle rb){
        
        this.nomeMoradorColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.apartamentoMoradorColumn.setCellValueFactory(new PropertyValueFactory<>("apartamento"));
        
        this.cadastroMoradores = this.moradoresTabela.getItems();
        
        // Bucar os produtos do banco de dados e adiciona na lista gráfica
        
        MoradorDAO moradorDAO = new MoradorDAO();
        List<Morador> moradoresDatabase = moradorDAO.getAll();
        
        this.cadastroMoradores.addAll(moradoresDatabase);
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        
        App.setRoot("telaInicial");
        
    }
    
    @FXML
    void editar() throws IOException {
        Morador moradorSelecionado = this.moradoresTabela.getSelectionModel().getSelectedItem();
        
        if (moradorSelecionado != null) {
            CadastroDeMoradoresController.setMorador(moradorSelecionado)  ;
            
            App.showModal("cadastroDeMoradores");  //EXECUÇÃO PARA E SÓ CONTINUA QUANDO EU FECHAR O MODAL
            
            Morador moradoresAlterado = CadastroDeMoradoresController.getMorador();
            
            moradorSelecionado.setId(moradoresAlterado.getId());
            moradorSelecionado.setNome(moradoresAlterado.getNome());
            moradorSelecionado.setDataDeNascimento(moradoresAlterado.getDataDeNascimento());
            moradorSelecionado.setCpf(moradoresAlterado.getCpf());
            moradorSelecionado.setRg(moradoresAlterado.getRg());
            moradorSelecionado.setApartamento(moradoresAlterado.getApartamento());
            moradorSelecionado.setTelefone(moradoresAlterado.getTelefone());
            moradorSelecionado.setEmail(moradoresAlterado.getEmail());
            moradorSelecionado.setNivel(2);
            
            
            this.moradoresTabela.refresh();
            
            MoradorDAO moradorDAO = new MoradorDAO();
            moradorDAO.update(moradorSelecionado);   //Alterar produtos no banco
            
   
        }
    }
    
    @FXML
    void remover() throws IOException{
        
        Morador moradorSelecionado = this.moradoresTabela.getSelectionModel().getSelectedItem();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remoção");
        alert.setHeaderText("Deseja remover : " + moradorSelecionado.getNome());
        alert.setContentText("Deseja remover mesmo remover o morador?");

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK){
             
            this.cadastroMoradores.remove(moradorSelecionado);
            
            MoradorDAO daoDoMorador = new MoradorDAO();
            daoDoMorador.delete(moradorSelecionado);

            
        }      
    }
    
    @FXML
    void novoMorador(ActionEvent event) throws IOException {
        
        CadastroDeMoradoresController.setMorador(null);
        
        App.showModal("cadastroDeMoradores");
        
        Morador novoMorador = CadastroDeMoradoresController.getMorador();
        if (novoMorador != null){
            
//            this.cadastroMoradores.add(novoMorador);
            
            MoradorDAO daoDoMorador = new MoradorDAO();
            daoDoMorador.save(novoMorador);
            
            List<Morador> moradores = daoDoMorador.getAll();
            this.cadastroMoradores.clear();
            this.cadastroMoradores.addAll(moradores);

            
        }    
    }
}