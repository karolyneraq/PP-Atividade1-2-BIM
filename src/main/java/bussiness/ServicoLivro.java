package bussiness;

import java.util.ArrayList;

import data.Autor;
import data.Livro;
import data.Editora;
import data.Persistencia;

public class ServicoLivro extends Servico{
    private final ArrayList<Livro> livros = new ArrayList<>();
    private final ServicoAutor sa;
    private final ServicoEditora se;

    public ServicoLivro(ServicoAutor sa, ServicoEditora se){
        this.sa = sa;
        this.se = se;
    }
    
    public boolean Cadastrar(String titulo, String nomeAutor){
        Autor autorLivro = null;
        
        for (Livro livro : this.livros){
            if (livro.getTitulo().equals(titulo)){
                return false;
            }
        }

        for (Autor autor : sa.GetAutores()){
            if (autor.getNome().equals(nomeAutor)){
                autorLivro = autor;
            }
        }

        if (autorLivro == null){
            autorLivro = new Autor(nomeAutor);
            this.sa.Cadastrar(nomeAutor);
        }
        
        livros.add(autorLivro.adicionarLivro(titulo));
        this.Salvar();
        return true;
    }

    public boolean Cadastrar(String titulo, String nomeAutor, String nomeEditora){
        Autor autorLivro = null;
        Editora editoraLivro = null;

        for (Livro livro : this.livros){
            if (livro.getTitulo().equals(titulo)){
                return false;
            }
        }

        for (Autor autor : this.sa.GetAutores()){
            if (autor.getNome().equals(nomeAutor)){
                autorLivro = autor;
            }
        }

        for (Editora editora : this.se.GetEditoras()){
            if (editora.getNome().equals(nomeEditora)){
                editoraLivro = editora;
            }
        }

        if (autorLivro == null){
            autorLivro = new Autor(nomeAutor);
            this.sa.Cadastrar(nomeAutor);
        }
        if (editoraLivro == null){
            editoraLivro = new Editora(nomeEditora);
            this.se.Cadastrar(nomeEditora);
        }

        livros.add(autorLivro.adicionarLivroEditora(titulo, editoraLivro));
        this.Salvar();
        return true;
    }

    @Override
    public boolean Atualizar(String nomeAtual, String novoNome){
        for (Livro livro : this.livros){
            if (livro.getTitulo().equals(nomeAtual)){
                livro.setTitulo(novoNome);
                this.Salvar();
                return true;
            }
        }

        return false;
    }
    
    public void AtualizarAutor(String nomeAtual, String novoNome) {
        Autor autor = null;
        
        for (Autor a : sa.GetAutores()){
            if (a.getNome().equals(novoNome)){
                autor = a;
            }
        }
        
        for (Livro livro : this.livros) {
            if (livro.getAutor().getNome().equals(nomeAtual)){
                livro.setAutor(autor);
                this.Salvar();
            }
        }
    }
    
    public void AtualizarEditora(String nomeAtual, String novoNome){
        Editora editora = null;
        
        for (Editora e : se.GetEditoras()){
            if (e.getNome().equals(novoNome)){
                editora = e;
            }
        }
        
        for (Livro livro : livros) {
            if (livro.getEditora().getNome().equals(nomeAtual)){
                livro.setEditora(editora);
                this.Salvar();
            }
        }
    }

    @Override
    public boolean Remover(String nome){
        for (Livro livro : this.livros){
            if (livro.getTitulo().equals(nome)){
                this.livros.remove(livro);
                livro.getAutor().removerLivro(livro);
                this.Salvar();
                return true;
            }
        }

        return false;
    }

    public String Visualizar(){
        String catalogo = String.format("%-20s|%-20s|%-20s\n" , "    TÍTULO: ", "    AUTOR:", "    EDITORA");
        catalogo += "\n";
        
        for (Livro l : this.livros){
            if (l.getEditora() == null){
            catalogo += String.format("%-20s|%-20s\n" , l.getTitulo(), l.getAutor().getNome() );
            }
            else{
            catalogo += String.format("%-20s|%-20s|%-20s\n" , l.getTitulo(), l.getAutor().getNome(), l.getEditora().getNome());
            }
            
        }
        return catalogo;
    }

    public ArrayList<Livro> Buscar(String busca){
        ArrayList<Livro> livrosBuscados = new ArrayList<>();
        
        for (Livro livro : this.livros){
            if (livro.getTitulo().contains(busca)){
                livrosBuscados.add(livro);
            }
        }

        return livrosBuscados;
    }
    
    public ArrayList<Livro> GetLivros(){
        return this.livros;
    }

    public void Carregar(){
        this.livros.addAll(Persistencia.loadLivros(this.sa.GetAutores(), this.se.GetEditoras()));
    }

    public void Salvar(){
        System.out.println("Salvando");
        Persistencia.saveLivros(this.livros);
    }
}
