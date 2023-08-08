package bussiness;

import java.util.ArrayList;

import data.Autor;
import data.Livro;
import data.Editora;
import data.Persistencia;

public class ServicoLivro extends Servico{
    private ArrayList<Livro> livros;
    private ServicoAutor sa;
    private ServicoEditora se;

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

        for (Autor autor : sa.Visualizar()){
            if (autor.getNome().equals(nomeAutor)){
                autorLivro = autor;
            }
        }

        if (autorLivro == null){
            autorLivro = new Autor(nomeAutor);
            this.sa.Cadastrar(nomeAutor);
        }
        
        livros.add(autorLivro.adicionarLivro(titulo));
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

        for (Autor autor : this.sa.Visualizar()){
            if (autor.getNome().equals(nomeAutor)){
                autorLivro = autor;
            }
        }

        for (Editora editora : this.se.Visualizar()){
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

        autorLivro.adicionarLivroEditora(titulo, editoraLivro);
        return true;
    }

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

    public ArrayList<Livro> Visualizar(){
        return this.livros;
    }

    public ArrayList<Livro> Buscar(String busca){
        ArrayList<Livro> livrosBuscados = new ArrayList<Livro>();
        
        for (Livro livro : this.livros){
            if (livro.getTitulo().contains(busca)){
                livrosBuscados.add(livro);
            }
        }

        return livrosBuscados;
    }

    public void Carregar(){
        this.livros.addAll(Persistencia.loadLivros(this.sa.Visualizar(), this.se.Visualizar()));
    }

    public void Salvar(){
        Persistencia.saveLivros(this.sa.Visualizar());
    }
}
