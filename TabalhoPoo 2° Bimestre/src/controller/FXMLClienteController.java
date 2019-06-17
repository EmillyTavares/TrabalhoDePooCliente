/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Cliente;
import view.Palco;

public class FXMLClienteController implements Initializable {
   
 @FXML
    private TextField textCpf;

    @FXML
    private RadioButton rbF;

    @FXML
    private RadioButton rbM;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textNumero;
     @FXML
    void Limpar(ActionEvent event) {
    Palco.telaPrincipal();
    }
    @FXML
    void salvar(ActionEvent event) {
         ClienteDAO dao = new ClienteDAO();
        Cliente Cliente = new Cliente();
        Cliente.setNumero(Integer.valueOf(textNumero.getText()));
        Cliente.setCpf(Integer.valueOf(textCpf.getText()));
        Cliente.setNome(textNome.getText());
        if(rbM.isSelected()){
             Cliente.setSexo("M");
        }else if(rbF.isSelected()){
            Cliente.setSexo("F");
        }
       
        
       /*Alert dialogoAviso = new Alert(AlertType.INFORMATION);
       dialogoAviso.setHeaderText("Esse é o cabeçalho...");
        dialogoAviso.setContentText(dao.salvar(Cliente));
        dialogoAviso.showAndWait();*/
        dao.salvar(Cliente);
        Palco.telaPrincipal();
    }
    public void limpaCampos(){
        rbM.setSelected(false);
        rbF.setSelected(false);
        textNumero.setText("");
        textNome.setText("");
        textCpf.setText("");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      
    }  }  
    

