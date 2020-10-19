package projeto_sorvil.gui;


import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import projeto_sorvil.controller.ControladorAutor;
import projeto_sorvil.controller.ControladorEditora;
import projeto_sorvil.controller.ControladorLivro;
import projeto_sorvil.controller.FachadaController;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;


public class TelaAdicionarLivroController {
    
    @FXML
    private GridPane telaAdicionarLivro;
    
    @FXML
    private Text adicionar;
    
    @FXML
    private Text nometxt;

    @FXML
    private Text autortxt;

    @FXML
    private Text editoratxt;

    @FXML
    private Text anoPubtxt;

    @FXML
    private Text numPagtxt;

    @FXML
    private Text generotxt;

    @FXML
    private TextField nomeLivro;

    @FXML
    private TextField autor;

    @FXML
    private TextField editora;

    @FXML
    private TextField anoPub;

    @FXML
    private TextField numPag;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoCriar;
    
    @FXML
    private TextField anoEd;
    
    @FXML
    private Button btnAbrir;
    
    @FXML  ChoiceBox <Genero> boxGenero;

    
    @FXML
    public void initialize() {

    	this.boxGenero.getItems().addAll(Genero.values());

    }
    
    

    @FXML
    void criarLivro(ActionEvent event) {
    	
    	Editora novaEditora = new Editora(editora.getText(), null);
    	FachadaController.getInstance().novaEditora(novaEditora);
    	
    	Autor novoAutor = new Autor(autor.getText() ,null, null);
    	FachadaController.getInstance().novoAutor(novoAutor);
    	
    	Genero onGenero = boxGenero.getValue();
    	int anoEdicao = Integer.parseInt(anoEd.getText());
    	int anoPublica = Integer.parseInt(anoPub.getText());
        int numeroPag = Integer.parseInt(numPag.getText());
    	
    	
    	Livro livroAdicionado = new Livro(nomeLivro.getText(), null , novaEditora, novoAutor, onGenero ,numeroPag ,
    			anoEdicao, anoPublica);
    	
    	FachadaController.getInstance().novoLivro(livroAdicionado);
        System.out.println(anoPublica);
        System.out.println(numeroPag);
        
        
    			
    			
    }

    @FXML
    void voltar(ActionEvent event) {
        this.limparCampos();
    	MainTestes.escolherTela(3);
    }
    
    public void limparCampos(){
        nomeLivro.clear();
        autor.clear();
    	editora.clear();
    	anoPub.clear();
    	numPag.clear();
        anoEd.clear();
        this.boxGenero.getSelectionModel().clearSelection();
    }
    
}
