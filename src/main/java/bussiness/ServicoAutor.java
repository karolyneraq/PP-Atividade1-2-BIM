package bussiness;

import java.util.ArrayList;

import data.Autor;
import data.Persistencia;

public class ServicoAutor extends Servico{
    private ArrayList<Autor> autores;
    
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

    public ArrayList<Autor> Visualizar(){
        return this.autores;
    }

    public ArrayList<Autor> Buscar(String busca){
        ArrayList<Autor> autoresBuscados = new ArrayList<Autor>();
        
        for (Autor autor : autores){
            if (autor.getNome().contains(busca)){
                autoresBuscados.add(autor);
            }
        }

        return autoresBuscados;
    }

    public void Carregar(){
        this.autores.addAll(Persistencia.loadAutores());
    }

    public void Salvar(){
        Persistencia.saveAutores(autores);
    }
}
