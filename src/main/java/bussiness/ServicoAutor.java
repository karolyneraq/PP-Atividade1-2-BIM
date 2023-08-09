package bussiness;

import java.util.ArrayList;

import data.Autor;
import data.Persistencia;

public class ServicoAutor extends Servico{
    private final ArrayList<Autor> autores = new ArrayList<>();
    
    public ServicoAutor(){}

    public boolean Cadastrar(String nomeAutor){
        for (Autor autor : this.autores){
            if (autor.getNome().equals(nomeAutor)){
                return false;
            }
        }

        this.autores.add(new Autor(nomeAutor));
        this.Salvar();
        return true;
    }

    @Override
    public boolean Atualizar(String nomeAtual, String novoNome){
        for (Autor autor : this.autores){
            if (autor.getNome().equals(nomeAtual)){
                autor.setNome(novoNome);
                this.Salvar();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean Remover(String nome){
        for (Autor autor : this.autores){
            if (autor.getNome().equals(nome)){
                this.autores.remove(autor);
                this.Salvar();
                return true;
            }
        }

        return false;
    }

    public String Visualizar(){
        String catalogo = String.format("%20s|%20s\n" , "    AUTOR: ", "    QNTD. LIVROS:");
        catalogo += "\n";
        
        for (Autor a : this.autores){
            catalogo += String.format("%-20s|%-20s\n" , a.getNome(), a.getLivros().size());
        }
        return catalogo;
    }

    public ArrayList<Autor> Buscar(String busca){
        ArrayList<Autor> autoresBuscados = new ArrayList<>();
        
        for (Autor autor : autores){
            if (autor.getNome().contains(busca)){
                autoresBuscados.add(autor);
            }
        }

        return autoresBuscados;
    }

    public ArrayList<Autor> GetAutores(){
        return this.autores;
    }

    public void Carregar(){
        this.autores.addAll(Persistencia.loadAutores());
    }

    public void Salvar(){
        Persistencia.saveAutores(autores);
    }
}
