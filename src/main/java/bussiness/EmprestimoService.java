package bussiness;

import java.util.ArrayList;

import data.Autor;
import data.Editora;
import data.Livro;

public class EmprestimoService implements Locacao{
    private Livro emprestimoAtual;
    private ArrayList<Livro> emprestimos;

    public boolean SolicitarLocacao(String nomeLivro){
        for (Livro livro : livros){
            if (livro.getTitulo().equals(nomeLivro)){
                this.emprestimoAtual = livro;
                return true;
            }
        }
    }

    public Livro AcompanharLocacao(){
        return emprestimoAtual;
    }

    public ArrayList<Livro> VerHistorico(){
        return this.emprestimos;
    }
}