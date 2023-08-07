package bussiness;

import java.util.ArrayList;

import data.Livro;


public interface Locacao{
    public boolean SolicitarLocacao(String nomeLivro);
    public Livro AcompanharLocacao();
    public ArrayList<Livro> VerHistorico();
}
