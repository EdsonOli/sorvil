/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_sorvil.controller;

import java.util.List;
import java.util.UUID;
import projeto_sorvil.dados.LivroRepositorio;
import projeto_sorvil.dados.RepositorioLivro;
import projeto_sorvil.model.Autor;
import projeto_sorvil.model.Editora;
import projeto_sorvil.model.Genero;
import projeto_sorvil.model.Livro;
import projeto_sorvil.model.Usuario;

/**
 *
 * @author Rayan
 */
public class ControladorLivro {
    
    private RepositorioLivro repositorioLivro;
    private static ControladorLivro instance;
    
    public static ControladorLivro getInstance() {
        if (instance == null) {
            instance = new ControladorLivro();
        }
        return instance;
    }
    
    private ControladorLivro(){
        this.repositorioLivro = LivroRepositorio.getInstance();
    }
    
    private boolean confereID(String id){
        return this.repositorioLivro.idExiste(id);
    }
    
    private String novoID(){
        String idProvi = UUID.randomUUID().toString();
        if(this.confereID(idProvi)){
            return novoID();
        }
        else{
            return idProvi;
        }
    }
    
    public boolean novoLivro(Livro livro){
        if(livro != null){
            livro.setId(this.novoID());
            if(!this.repositorioLivro.listar().contains(livro)){
               return this.repositorioLivro.adicionar(livro); 
            }
        }
        
        return false;
    }
    
    public boolean deleteLivro(Usuario usuario, Livro livro){
        if(livro != null ){
            if (!this.repositorioLivro.listar().contains(livro) && usuario.isAdmin() == true){
                return this.repositorioLivro.apagar(livro);
            }    
        }
        return false;
    }
    
    public Livro buscarLivro(String nome){
        Livro livro = null;
        if (nome != null){
            for(Livro lvr : this.repositorioLivro.listar()){
                if(lvr.getNome().equals(nome)){
                    livro = lvr;
                }
            }
        }
        return livro;
    }
    
    public List<Livro> listarPorEditora (Editora editora) {
        if (editora != null){
            return this.repositorioLivro.listar(editora);
        }
        return null;
    }
    
    public List<Livro> listarPorAutor (Autor autor){
        if (autor != null) {
            return this.repositorioLivro.listar(autor);
        }
        return null;
    }
    
    public List<Livro> listarPorGenero (Genero genero){
        if (genero != null) {
            return this.repositorioLivro.listar(genero);
        }
        return null;
    }
    
}
