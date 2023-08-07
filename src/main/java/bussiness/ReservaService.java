package bussiness;

import java.util.ArrayList;

import data.Livro;


public class ReservaService implements Locacao{
    private Livro reservaAtual;
    private ArrayList<Livro> reservas;

    public boolean SolicitarLocacao(String nomeLivro){
        return true;
    }

    public Livro AcompanharLocacao(){
        return this.reservaAtual;
    }

    public ArrayList<Livro> VerHistorico(){
        return this.reservas;
    }
}