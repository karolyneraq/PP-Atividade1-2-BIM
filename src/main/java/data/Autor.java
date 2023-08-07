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
	
	public void adicionarLivroEditora(String nome, Editora editora) {
		livros.add(new Livro(nome, this, editora));
	}

	public void removerLivro(Livro livro) {
		livros.remove(livro);
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
