/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import view.Palco;

    

public class FXMLAtualizarController implements Initializable {
@FXML
    private TextField numero;

    @FXML
    private RadioButton rbF;

    @FXML
    private TextField cpf;

    @FXML
    private TextField nome;

    @FXML
    private RadioButton rbM;
     @FXML
    void Atualizar(ActionEvent event) {

    }

    @FXML
    void Cancelar(ActionEvent event) {

    }
    private Stage stage;
    private boolean btnAtualizar = false;
    
 Cliente cliente = new Cliente();
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isBtnSalvar() {
        return btnAtualizar;
    }

    public void setBtnSalvar(boolean btnSalvar) {
        this.btnAtualizar = btnSalvar;
    }
    @FXML
    void handleSalvar() {        
       cliente.setNumero(Integer.parseInt(numero.getText()));
        cliente.setNome(nome.getText());
        if(rbM.isSelected()){
            cliente.setSexo("M");            
        }else{
            cliente.setSexo("F");
        }        
        btnAtualizar = true;
        stage.close();
        
    }

    @FXML
    void handleCancelar() {
        stage.close();
    }
    
    public void setAluno(Cliente cliente){
        this.cliente = cliente;
        numero.setText(String.valueOf(cliente.getNumero()));
        nome.setText(String.valueOf(cliente.getNome()));
        if(cliente.getSexo().equals("M")){
            rbM.setSelected(true);
        }else{
            rbF.setSelected(true);
        }
    }
    
    @FXML
    void handleRBM() {
        rbF.setSelected(false);        
    }

    @FXML
    void handleRBF() {
        rbM.setSelected(false);
    }
    
    
    
    }    

