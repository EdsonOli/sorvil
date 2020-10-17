package projeto_sorvil.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Card  implements Serializable{


	private static final long serialVersionUID = -6306012540272143681L;
	private String id;
	private String titulo;
	private String texto;
	private Usuario usuario;
	private Livro livro;
	private LocalDateTime dataHora;
	private boolean publico = false;
	private int pagina;
	
	public Card(String titulo, String id, String texto, Usuario usuario, Livro livro, LocalDateTime dataHora, boolean publico,
			int pagina) {
		
		this.titulo = titulo;
		this.id = id;
		this.texto = texto;
		this.usuario = usuario;
		this.livro = livro;
		this.dataHora = dataHora;
		this.publico = publico;
		this.pagina = pagina;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
            if (titulo != null){
                this.titulo = titulo;
            }
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
            if(id != null){
                this.id = id;
            }
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
            if(texto != null){
                this.texto = texto;
            }
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
            if(usuario != null){
                this.usuario = usuario;
            }
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
            if(livro != null){
                this.livro = livro;
            }
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
            if (dataHora != null){
                this.dataHora = dataHora;
            }
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	public boolean equals(Card card) {
            if(card != null){
                return card.getUsuario().equals(this.usuario)
                            && card.getTitulo().equals(this.titulo) 
                            && card.getDataHora().equals(this.dataHora) 
                            && card.getLivro().equals(this.livro);
        }
        return false;   
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}


        @Override
	public String toString() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return this.livro.getNome() + "\n" + this.getTitulo() + "\n" + this.getTexto() + "\n" 
		+ "Pagina: " + this.getPagina() + "\n" + formatter.format(dataHora) ;
	}
	
	
	
	
}
