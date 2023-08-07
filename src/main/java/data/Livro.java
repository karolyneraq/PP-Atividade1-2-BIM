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
	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
}
