package data;

public class Livro {
	private String titulo;
	private Autor autor;
	private Editora editora;

	public Livro(String titulo, Autor autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.setEditora(null);
	}

	public Livro(String titulo, Autor autor, Editora editora) {
		this.titulo = titulo;
		this.autor = autor;
		this.setEditora(editora);
    editora.adicionarLivro(this);
	}

	public String getTitulo() {
		return this.titulo;
	}

	public Autor getAutor() {
		return this.autor;
	}

	public Editora getEditora() {
		return this.editora;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
}
