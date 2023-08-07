package bussiness;

import java.util.ArrayList;
import data.Livro;
import data.Autor;
import data.Editora;

public class ServicoLivro extends Servicos{
    private ArrayList<Livro> livros;
    private ArrayList<Autor> autores;
    private ArrayList<Editora> editoras;

    public boolean Cadastrar(String titulo, String nomeAutor){
        Autor autorLivro = null;
        
        for (Livro livro : livros){
            if (livro.getTitulo().equals(titulo)){
                return false;
            }
        }

        for (Autor autor : autores){
            if (autor.getNome().equals(nomeAutor)){
                autorLivro = autor;
            }
        }

        if (autorLivro == null){
            autorLivro = new Autor(nomeAutor);
        }
        
        autorLivro.adicionarLivro(titulo);
        return true;
    }

    public boolean Cadastrar(String titulo, String nomeAutor, String nomeEditora){
        Autor autorLivro = null;
        Editora editoraLivro = null;

        for (Livro livro : livros){
            if (livro.getTitulo().equals(titulo)){
                return false;
            }
        }

        for (Autor autor : autores){
            if (autor.getNome().equals(nomeAutor)){
                autorLivro = autor;
            }
        }

        for (Editora editora : editoras){
            if (editora.getNome().equals(nomeEditora)){
                editoraLivro = editora;
            }
        }

        if (autorLivro == null){
            autorLivro = new Autor(nomeAutor);
        }
        if (editoraLivro == null){
            editoraLivro = new Editora(nomeEditora);
        }

        autorLivro.adicionarLivroEditora(titulo, editoraLivro);
        return true;
    }

    public boolean Atualizar(String nomeAtual, String novoNome){
        for (Livro livro : livros){
            if (livro.getTitulo().equals(nomeAtual)){
                livro.setTitulo(novoNome);
                return true;
            }
        }

        return false;
    }

    public boolean Remover(String nome){
        for (Livro livro : livros){
            if (livro.getTitulo().equals(nome)){
                livros.remove(livro);
                return true;
            }
        }

        return false;
    }

    public ArrayList<Livro> Visualizar(){
        return this.livros;
    }
}