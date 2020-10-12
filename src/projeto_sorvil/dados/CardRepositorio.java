package projeto_sorvil.dados;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

public class CardRepositorio implements RepositorioCards, Serializable{

	private static final long serialVersionUID = 2206304480631005062L;
	private ArrayList<Card> cards;
	private static CardRepositorio instance;

		
 
        
    public static CardRepositorio getInstance() {
		    if (instance == null) {
		      instance = CardsDAO.lerDoArquivo();
		    }
		    return instance;
		  }

    public CardRepositorio(ArrayList<Card> cards) {
        this.cards = cards;
    }
        
        

        @Override
	public boolean adicionar(Card card) {		
		return cards.add(card);		
	}
	
      
        @Override
	public Card buscar(int indice) {
		return cards.get(indice);
	}
        
    @Override
        public boolean idExiste(String id){
            boolean existe = false;
            for(Card card : cards){
                if(card.getId().equals(id)){
                    existe = true;
                }
            }
            return existe;
        }
        
        @Override
	public boolean apagar(Card card) {
		return cards.remove(card);
	}

        @Override
        public List<Card> listar() {
            return cards;    }

        @Override
        public List<Card> listar(Usuario usuario) {
            return cards.stream()
                    .filter(card-> card.getUsuario().equals(usuario))
                    .collect(Collectors.toList());
        }

        @Override
        public List<Card> listar(Livro livro) {
            return cards.stream()
                    .filter(card-> card.getLivro().equals(livro))
                    .collect(Collectors.toList());
        }

		@Override
		public Card buscar(Card card) {
			return this.buscar(this.cards.indexOf(card));
		}


}
