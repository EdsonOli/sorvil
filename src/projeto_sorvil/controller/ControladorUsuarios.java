package projeto_sorvil.controller;

import java.util.ArrayList;
import java.util.List;


import projeto_sorvil.dados.IrepositorioUsuario;
import projeto_sorvil.dados.UsuarioRepositorio;
import projeto_sorvil.exceptions.CPFinvalidoExeption;
import projeto_sorvil.exceptions.JaExisteException;
import projeto_sorvil.exceptions.NaoExisteException;
import projeto_sorvil.exceptions.NaoPodeException;
import projeto_sorvil.model.MeuLivro;
import projeto_sorvil.model.Usuario;

public class ControladorUsuarios {
	

    private IrepositorioUsuario repositorioUsuarios;
    private static ControladorUsuarios instancia = null;
	
    public ControladorUsuarios() {
    	this.repositorioUsuarios = UsuarioRepositorio.getInstancia();
    }
    
    public static ControladorUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new ControladorUsuarios();
        }
        return instancia;
    }	
	
    public boolean adicionar(Usuario user) throws JaExisteException, CPFinvalidoExeption {
    	if(user != null && this.validarCPF(user.getCPF())) {
    	
    		if (!user.equals(repositorioUsuarios.buscar(user.getLogin()))) {
    			return repositorioUsuarios.adicionar(user);
    		}
                else {
    		 throw new JaExisteException(user);
          
                }
    		 
    	}
    	
		return false;
    	
    }
    
    public boolean remover(Usuario user) throws NaoPodeException {
    	if(user != null) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
    			return repositorioUsuarios.remover(user);
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    		 
    	}
    	else {
            return false;
    	}
    }
    
    
    public boolean  editarNome(Usuario user, String nome) throws NaoPodeException {
    	
    	if(user != null & nome != null & !nome.equals("")) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
    			repositorioUsuarios.editarNome(user, nome);
    			return true;
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    	}
    	else {
    		return false;
    	}
    			
	}
	
	public boolean editarLogin(Usuario user, String login) throws NaoPodeException, JaExisteException {
    	
		if(user != null & login != null & !login.equals("") ) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user) {
                    if(repositorioUsuarios.buscar(login) == null){
                        repositorioUsuarios.editarLogin(user, login);
    			return true;
                    }
                    else{
                        throw new JaExisteException(login);
                    }
    			
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    	}
    	else {
    		return false;
    	}
    	
	}
	
	public boolean editarSenha(Usuario user, String senha) throws NaoPodeException {
		
		if(user != null & senha != null & !senha.equals("")) {
    		if (repositorioUsuarios.buscar(user.getLogin()) == user ) {
    			repositorioUsuarios.editarLogin(user, senha);
    			return true;
    		}
    		else {
    			throw new NaoPodeException(user);
    		}
    	}
    	else {
    		return false;
    	}
	}
	
	
	public Usuario buscar(String login) throws NaoExisteException  {
            Usuario encontrado;
		if( login != null  & !login.equals("") ) {
			encontrado = repositorioUsuarios.buscar(login);
                        if(encontrado != null){
                            return encontrado;
                        }
                        else throw new NaoExisteException(login);
		}
		return null;
	}
	

	
	public boolean adicionarLivroUsuario(Usuario user, MeuLivro userLivro) throws JaExisteException{
		
		if(userLivro != null) {
			Usuario usuario  = repositorioUsuarios.buscar(user.getLogin());
			MeuLivro livroBuscado = usuario.buscarLivro(userLivro.getLivro().getNome());
			if (livroBuscado == null ) {
	    		repositorioUsuarios.adicionarLivro(user, userLivro);
	    		return true;
			}
			else if (userLivro.getLivro().equals(livroBuscado.getLivro())){
				throw new JaExisteException(userLivro);
			}
			else {
				return false;
			}
    	}
    	else {
            return false;
    	}

	}
	
	
	public boolean removerLivroUsuario(Usuario user, MeuLivro userLivro) throws NaoExisteException{
		
		if(userLivro != null) {
			Usuario usuario  = repositorioUsuarios.buscar(user.getLogin());
			MeuLivro livroDel = usuario.buscarLivro(userLivro.getLivro().getNome());
    		if (userLivro.getLivro().equals(livroDel.getLivro())) {
    			repositorioUsuarios.removerLivro(user, userLivro);
        		return true;
    		}
                else{
                    throw new NaoExisteException(userLivro);
                }
    	}
    	else {
            return false;
    	}

	}
	
	public MeuLivro buscarLivroUsuario(Usuario user,String nome) throws NaoExisteException {
		if( nome != null  & !nome.equals("") & user != null) {
                    MeuLivro livro = user.buscarLivro(nome);
                    if(livro != null){
                        return livro;
                    }
                    else{
                        throw new NaoExisteException(nome);
                    }
		}
		return null;
	}
	

    public List<Usuario> listar() {
        return repositorioUsuarios.listar();
    }
    
    public ArrayList<MeuLivro> listarLivrosUsuario(Usuario user) {
    	
    	if(user != null) {
    		if(repositorioUsuarios.getUsuarios().contains(user)){
    			return repositorioUsuarios.listarLivros(user);
    		}
    	}
    	return null;
    }
    
    private boolean confereCPF(String cpf) {
    	return this.repositorioUsuarios.cpfExiste(cpf);
	}
    

	private boolean validarCPF(String cpf) throws CPFinvalidoExeption, JaExisteException{
        
            boolean retorno = this.confereCPF(cpf);
            if(cpf.matches("[0-9]*") && cpf.length() == 11){
            
                if(!retorno){
                   return !retorno;
               }
                else throw new JaExisteException(cpf);
                
             }
            else throw new CPFinvalidoExeption(cpf);
 
    }

    

	
	
	
	
	
	
	
	

}
