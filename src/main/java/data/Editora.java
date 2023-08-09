package data;

import java.util.ArrayList;

public class Editora {
	
	private String nome;
	private ArrayList<Livro> livros;
	
	public Editora(String nome) {
		this.nome = nome;
		this.livros = new ArrayList<Livro>();
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	
	public void adicionarLivro(Livro livro) {
		livro.setEditora(this);
		this.livros.add(livro);
	}
	
	public void removerLivro(Livro livro) {
		livro.setEditora(null);
		livros.remove(livro);
	}
	
	public void listarLivros() {
		
		if (livros.size() > 0){
			
			String saida = "A editora " + this.getNome() + " publicou estes livros:\n";
			
			for(int i = 0; i < this.livros.size(); i++){
				saida += "Titulo: " + this.livros.get(i).getTitulo() + "\n\n";
			}
			
			System.out.println(saida);
		}
		
		else {
			System.out.println("A editora " + this.getNome() + " ainda não publicou nenhum livro");
		}
	}
}
