
package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

 
public class Palco extends Application {
        public static Scene scener;
        public static Scene sceneCliente;
        public static Scene sceneVisualizar;
        public static Scene cliente;
        public static Stage palco;
        public  static Scene scenerCliente;
        public static Scene sceneAtualizar;
    @Override
    public void start(Stage primaryStage) throws IOException {
         palco = primaryStage;
         
         Parent root = FXMLLoader.load(getClass().getResource("FXMLClassPrincipal.fxml"));
         scener = new Scene(root);
        Parent Cliente =FXMLLoader.load(getClass().getResource("FXMLCliente.fxml"));
        sceneCliente = new Scene(Cliente);
        Parent visualizar = FXMLLoader.load(getClass().getResource("FXMLVisualizar.fxml"));
        sceneVisualizar= new Scene(visualizar);
         Parent atualizar = FXMLLoader.load(getClass().getResource("FXMLAtualizar.fxml"));
           sceneAtualizar = new Scene(atualizar);
        
        palco.setTitle("Menu");
        palco.setScene(scener);
        palco.setResizable(true);
        palco.show();

    }

   
    public static void main(String[] args) {
        launch(args);
    }
   
    
    public static void Cliente(){
        palco.setTitle("Cadastro de Cliente");
        palco.setScene(sceneCliente);        
    }
    
    public static void Vizualizar(){
        palco.setTitle("Visualizar");
        palco.setScene(sceneVisualizar);
    }
    
    public static void telaPrincipal(){
        palco.setTitle("Tela Principal");
        palco.setScene(scener);
    }
    public static void Atualizar(){
        palco.setTitle("Atualizar Cliente");
        palco.setScene(sceneAtualizar);
    }
    
    
}
       
  
