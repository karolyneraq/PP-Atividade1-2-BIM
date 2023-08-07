package data;

import java.util.ArrayList;

public class Autor {
	private String nome;
	private ArrayList<Livro> livros;

	public Autor(String nome) {
		this.nome = nome;
		this.livros = new ArrayList<>();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void adicionarLivro(String nome) {
		livros.add(new Livro(nome, this));
	}
	
	public Livro adicionarLivro(String nome) {
		Livro livro = new Livro(nome, this);
		livros.add(livro);
		return livro;
	}
	
	public Livro adicionarLivroEditora(String nome, Editora editora) {
		Livro livro = new Livro(nome, this, editora);
		livros.add(livro);
		return livro;
	}

	public void listarLivros(){
		
		if (livros.size() > 0){
			
			String saida = "O autor " + this.nome + " escreveu estes livros:\n";
			
			for(int i = 0; i < this.livros.size(); i++){
				saida += "Titulo: " + this.livros.get(i).getTitulo() + "\n\n";
			}
			
			System.out.println(saida);
		}
		
		else {
			System.out.println("O autor " + this.getNome() + " ainda não escreveu nenhum livro");
		}
	}
}
