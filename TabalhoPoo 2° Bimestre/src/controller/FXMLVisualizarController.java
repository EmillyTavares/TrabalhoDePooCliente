package controller;

import dao.ClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cliente;
import view.Palco;


public class FXMLVisualizarController implements Initializable {

    @FXML
    private TableView<Cliente> tabela;
    @FXML
    private TableColumn<Cliente, Integer> ColCpf;

    @FXML
    private TableColumn<Cliente, String> ColNome;

    @FXML
    private TableColumn<Cliente, String> ColSexo;

    @FXML
    private TableColumn<Cliente, Integer> ColN;
    ClienteDAO dao = new ClienteDAO();
@FXML
    void Alterar(ActionEvent event) {

    }
    @FXML
    void voltar(ActionEvent event) {
        Palco.telaPrincipal();
    }

    @FXML
    void Excluir(ActionEvent event) {
        Excluir();
    }

   

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        tabela.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> itemSelecitado(newValue));
        mostrarTabela();
    }

    public void Excluir() {
        Cliente cliente = new Cliente();
        cliente = tabela.getSelectionModel().getSelectedItem();
        if (cliente != null) {

            if (dao.delete(cliente.getNumero())) {
                /*Alert alert = new Alert(Alert.AlertType.WARNING);            
                 alert.setTitle("Exclusão com sucesso");
                 alert.setHeaderText("Exclusão");
                 alert.setContentText("Dados excluidos com sucesso");
                 alert.showAndWait();*/
                System.out.println("EXCLUIDO COM SUCESSO");
                mostrarTabela();
            } else {
                System.out.println("Erro ao excluir");
            }
        } else {
            /*Alert alert = new Alert(Alert.AlertType.WARNING);            
             alert.setTitle("Exclusão");
             alert.setHeaderText("Cabeçalho do alerta");
             alert.setContentText("Você deve selecionar um aluno para excluir");
             alert.showAndWait();*/
            System.out.println("ERRO!");

        }
    }

    public void mostrarTabela() {
        ColN.setCellValueFactory(new PropertyValueFactory<>("numero"));
        ColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ColSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        ColCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tabela.setItems(listaCliente());//
    }

    public ObservableList<Cliente> listaCliente() {
        List<Cliente> lista = dao.pesquisarAll();//
        return FXCollections.observableArrayList(lista);  //      
    }

    private void itemSelecitado(Cliente cliente) {
        cliente.setCpf(cliente.getCpf());
        cliente.setNome(cliente.getNome());
        cliente.setNumero(cliente.getNumero());
        cliente.setSexo(cliente.getSexo());
        System.out.println("NUMERO" + cliente.getNumero());
    }
    @FXML
    public void Atualizar() throws IOException{
        Cliente cliente= tabela.getSelectionModel().getSelectedItem();
        if(cliente != null){
            boolean buttonConfirmaClick = showTela(cliente);
            if(buttonConfirmaClick){                
                dao.atualizar(cliente);
                mostrarTabela();
            }            
        }else{
            System.out.println("Atualizar");
        }           
    }

    private boolean showTela(Cliente cliente)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAtualizarController.class.getResource("/view/FXMLAtualizar.fxml"));
        AnchorPane pagina = (AnchorPane) loader.load();        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Atualizar Cliente");
        Scene scener = new Scene(pagina);
        dialogStage.setScene(scener);
        
        FXMLAtualizarController alterarController = loader.getController();
        alterarController.setStage(dialogStage);
        alterarController.setAluno(cliente);
        dialogStage.showAndWait();
        return alterarController.isBtnSalvar();
    }
}

