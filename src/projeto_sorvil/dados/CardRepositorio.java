package projeto_sorvil.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import projeto_sorvil.model.Card;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

public class CardRepositorio implements RepositorioCards, Serializable{

    private static CardRepositorio lerDoArquivo() {
         CardRepositorio instanciaLocal = null;

		    File in = new File("src/cards.dat");
		    FileInputStream fis;
		    ObjectInputStream ois = null;
		    ArrayList<Card> cds = new ArrayList<>();
		    
                    try {
		      fis = new FileInputStream(in);
		      ois = new ObjectInputStream(fis);
		      Object o = ois.readObject();
		      instanciaLocal = (CardRepositorio) o;
		    } catch (IOException | ClassNotFoundException e) {
		      instanciaLocal = new CardRepositorio(cds);
		    } finally {
		      if (ois != null) {
		        try {
		          ois.close();
		        } catch (IOException e) {
		        }
		      }
		    }

		    return instanciaLocal;
		  
    }
    
    public void salvarArquivo() {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("src/cards.dat");
	    FileOutputStream fos;
	    ObjectOutputStream oos = null;

	    try {
	      fos = new FileOutputStream(out);
	      oos = new ObjectOutputStream(fos);
	      oos.writeObject(instance);
	    } catch (IOException e) {
	    } finally {
	      if (oos != null) {
	        try {
	          oos.close();
	        } catch (IOException e) {
	          }
	      }
	    }
	  }
	
    private ArrayList<Card> cards;
    private static CardRepositorio instance;
        
    public static CardRepositorio getInstance() {
		    if (instance == null) {
		      instance = lerDoArquivo();
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


}
