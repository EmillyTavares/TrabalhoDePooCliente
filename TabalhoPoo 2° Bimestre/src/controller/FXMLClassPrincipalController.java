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
import view.Palco;

/**
 * FXML Controller class
 *
 * @author 1º INF
 */
public class FXMLClassPrincipalController implements Initializable {
    @FXML
    void Sair(ActionEvent event) {

    }

    @FXML
    void cadastrar(ActionEvent event) {
        Palco.Cliente();

    }

    @FXML
    void Visualizar(ActionEvent event) {
        Palco.Vizualizar();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
}
