package projeto_sorvil.dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public class UsuarioRepositorio implements RepositorioUsuario, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5084589120456372224L;
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	private static UsuarioRepositorio instancia;
	
	
	public UsuarioRepositorio(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
		
	public static UsuarioRepositorio getInstancia() {
        if (instancia == null) {
            instancia = UsuariosDAO.lerDoArquivo();
        }
        return instancia;
    }
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public boolean adicionar(Usuario user) {
		boolean retorno = usuarios.add(user);
		
		UsuariosDAO.salvarArquivo(instancia);
		return retorno;
		
	}

	public boolean remover(Usuario user) {
			
			return usuarios.remove(user);
	}
	
	public void editarNome(Usuario user, String nome) {
		
		 user.setNome(nome);
	}
	
	public void editarLogin(Usuario user, String login) {
		
		 user.setLogin(login);
	}
	
	public void editarSenha(Usuario user, String senha) {
		
		 user.setSenha(senha);
	}
	
	public Usuario buscar(String login) {
		
		for(int i=0; i < usuarios.size() ; i++) { 
			if(usuarios.get(i).getLogin().equals(login)) {
				return usuarios.get(i);
			}

		}		
		return null;	
	}
	
	public Usuario buscarPeloNome(String nome) {
		
		for(int i=0; i < usuarios.size() ; i++) { 
			if(usuarios.get(i).getNome().compareToIgnoreCase(nome) < 2) {
				return usuarios.get(i);
			}

		}		
		return null;	
		
	}
	
	public List<Usuario> listar() {
		return usuarios.subList(0, usuarios.size());
	}
	
	public List<MeuLivro> listarLivros(Usuario user) {
		return user.getEstante().subList(0 , user.getEstante().size() );
	}
	
	
	public boolean idExiste(String id){
		
        for(int i =0; i< usuarios.size(); i++){
            if(usuarios.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;
    }
	
	
	
	
	
	
	
	
}
