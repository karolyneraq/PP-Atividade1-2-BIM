package bussiness;

import java.util.ArrayList;

import data.Livro;

public class LocacaoReserva implements Locacao{
    private Livro reservaAtual;
    private ArrayList<Livro> reservas;

    public boolean SolicitarLocacao(String nomeLivro, ServicoLivro sl){
        for (Livro livro : sl.Visualizar()){
            if (livro.getTitulo().equals(nomeLivro)){
                reservaAtual = livro;
                return true;
            }
        }

        return false;
    }

    public Livro AcompanharLocacao(){
        return this.reservaAtual;
    }

    public ArrayList<Livro> VerHistorico(){
        return this.reservas;
    }

    public boolean CancelarLocacao(String nomeLivro, ServicoLivro sl){
        if (reservaAtual.getTitulo().equals(nomeLivro)){
            reservaAtual = null;
            return true;
        }

        return false;
    }
}
