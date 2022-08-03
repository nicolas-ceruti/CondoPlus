package com.mycompany.zcondo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroDeMoradoresController implements Initializable {

    static Morador morador;

    @FXML
    TextField nomeTextField;

    @FXML
    DatePicker dataDeNascimentoDatePicker;

    @FXML
    TextField cpfTextField;

    @FXML
    TextField rgTextField;

    @FXML
    TextField apartamentoTextField;

    @FXML
    TextField telefoneTextfield;

    @FXML
    TextField emailTextField;

    /**
     * Método executado todas as vezes que a tela é aberta, antes de qualquer
     * outro método.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (morador != null) {

            nomeTextField.setText(morador.getNome());
            dataDeNascimentoDatePicker.setUserData(morador.getDataDeNascimento());
            cpfTextField.setText(morador.getCpf());
            rgTextField.setText(morador.getRg());
            apartamentoTextField.setText(Integer.toString(morador.getApartamento()));
            telefoneTextfield.setText(morador.getTelefone());
            emailTextField.setText(morador.getEmail());

        }
    }

    static Morador getMorador() {

        return morador;

    }

    static void setMorador(Morador cadastromoradores) {

        CadastroDeMoradoresController.morador = cadastromoradores;

    }

    @FXML
    void btnSalvar() {

        if (!this.nomeTextField.getText().isEmpty()//
                && !this.cpfTextField.getText().isEmpty()//
                && !this.rgTextField.getText().isEmpty()
                && !this.apartamentoTextField.getText().isEmpty()//
                && !this.telefoneTextfield.getText().isEmpty()//
                && !this.emailTextField.getText().isEmpty()) {

            Morador moradorEditado = new Morador(
                    morador == null ? 0 : morador.id,
                    this.nomeTextField.getText(),
                    this.dataDeNascimentoDatePicker.getValue().toString(),
                    this.cpfTextField.getText(),
                    this.rgTextField.getText(),
                    Integer.parseInt(this.apartamentoTextField.getText()),
                    this.telefoneTextfield.getText(),
                    this.emailTextField.getText(),
                    2 //nivel de condômino
            );

            morador = moradorEditado;

            Stage stage = (Stage) nomeTextField.getScene().getWindow();
            App.closeWindow(stage);

        }
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {

        Stage stage = (Stage) nomeTextField.getScene().getWindow();
        App.closeWindow(stage);

    }
}
