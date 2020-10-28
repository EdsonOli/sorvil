package projeto_sorvil.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.MeuLivro;


public class TelaBibliotecaPessoalController {


    @FXML
    private AnchorPane tela;

    @FXML
    private Button btnDeletarLivro;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnEditarUsuario;

    @FXML
    private Button btnAdicionarLivro;

    @FXML
    private ListView<MeuLivro> lvListaPessoalLivros;

    @FXML
    private TextField txtLivro;

    @FXML
    private Text titulo;
    

    private static ObservableList<MeuLivro> obsListPessoal = null;


	

	

    @FXML
    void iniciar(MouseEvent event) {

    	if( obsListPessoal == null ){
    		obsListPessoal = FXCollections.observableArrayList(FachadaController.listarLivrosUsuario(FachadaController.getUsuarioLogado()));					

    		lvListaPessoalLivros.setItems(obsListPessoal);
    	}
    	
    }

    



    @FXML
    void fechar(ActionEvent event) {
    	obsListPessoal = null;
    	lvListaPessoalLivros.setItems(obsListPessoal);
    	FachadaController.setUsuarioLogado(null);
    	MainTestes.escolherTela(1);
    	
    }


    @FXML
    void irParaLivro(ActionEvent event) {
    	
    	MeuLivro onLivro = new MeuLivro(null, null, 0);
    	FachadaController.setOnLivro(onLivro);
    	MainTestes.escolherTela(6);
    }
    

    @FXML
    void DeletarLivroPessoal(ActionEvent event) {
    	obsListPessoal = null;

    	
    }

    @FXML
    void telaAdicionarLivro(ActionEvent event) {
    	obsListPessoal = null;
    	MainTestes.escolherTela(9);
    }

    @FXML
    void telaEditarUsuario(ActionEvent event) {
    	obsListPessoal  = null;
    	MainTestes.escolherTela(5);
    }
    
    
	
	
	
	
	

}
