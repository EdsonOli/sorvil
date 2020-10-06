package projeto_sorvil.model;

public class Autor {
	private String nome;
	private String sobrenome;
	private String id;
	
	public Autor(String nome, String sobrenome, String id) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getId() {
		return id;
	}
	
	
	public boolean equals(Autor autor) {
		return autor != null && autor.getNome().equals(this.getNome()) && autor.getSobrenome().equals(this.getSobrenome())
                        && autor.getId().equals(this.getId());
	}

	public void setId(String id) {
		this.id = id;
	}
	
        @Override
	public String toString() {
		return this.getNome() + " " + this.getSobrenome();
	}
	
	

}
