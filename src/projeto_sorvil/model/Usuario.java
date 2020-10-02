package projeto_sorvil.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
	private String nome;
	private String login;
	private String senha;
	private boolean admin;
	private LocalDate dataCadastro;
	private ArrayList <Livro> estante;
	
	public Usuario(String nome, String login, String senha, boolean admin, LocalDate dataCadastro) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.admin = admin;
		this.dataCadastro = dataCadastro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public ArrayList<Livro> getEstante() {
		return estante;
	}

	public void setEstante(ArrayList<Livro> estante) {
		this.estante = estante;
	}
	
	public boolean equals(Usuario usuario) {
		if(usuario != null && usuario.getLogin() == this.login) {
			return true;
		}
		return false;
	}
	
	
	
}
