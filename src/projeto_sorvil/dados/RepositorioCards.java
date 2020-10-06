package projeto_sorvil.dados;

import java.util.List;
import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

public interface RepositorioCards {
	
	boolean adicionar(Card card);
        
	public Card buscar(int indice);
	
	public boolean apagar(Card card);
        
        public List<Card> listar();
        
        public List<Card> listar(Usuario usuario);
        
        public List<Card> listar(Livro livro);
        
        public List<Card> listar(String titulo);
        
        
        
        
        
        
        
        

}
