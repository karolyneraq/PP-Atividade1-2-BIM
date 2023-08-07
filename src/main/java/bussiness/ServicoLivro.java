package bussiness;

import java.util.ArrayList;

import data.Autor;
import data.Livro;
import data.Editora;
import data.Persistencia;

public class ServicoLivro extends Servico{
    private ArrayList<Livro> livros;

    public ServicoLivro(){}
    
    public boolean Cadastrar(String titulo, String nomeAutor, ServicoAutor sa){
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
            sa.Cadastrar(nomeAutor);
        }
        
        livros.add(autorLivro.adicionarLivro(titulo));
        return true;
    }

    public boolean Cadastrar(String titulo, String nomeAutor, ServicoAutor sa, String nomeEditora, ServicoEditora se){
        Autor autorLivro = null;
        Editora editoraLivro = null;

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

        for (Editora editora : se.Visualizar()){
            if (editora.getNome().equals(nomeEditora)){
                editoraLivro = editora;
            }
        }

        if (autorLivro == null){
            autorLivro = new Autor(nomeAutor);
            sa.Cadastrar(nomeAutor);
        }
        if (editoraLivro == null){
            editoraLivro = new Editora(nomeEditora);
            se.Cadastrar(nomeEditora);
        }

        autorLivro.adicionarLivroEditora(titulo, editoraLivro);
        return true;
    }

    public boolean Atualizar(String nomeAtual, String novoNome){
        for (Livro livro : this.livros){
            if (livro.getTitulo().equals(nomeAtual)){
                livro.setTitulo(novoNome);
                return true;
            }
        }

        return false;
    }

    public boolean Remover(String nome){
        for (Livro livro : this.livros){
            if (livro.getTitulo().equals(nome)){
                this.livros.remove(livro);
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

    public void Carregar(ServicoAutor sa, ServicoEditora se){
        this.livros.addAll(Persistencia.loadLivros(sa.Visualizar(), se.Visualizar()));
    }
}
