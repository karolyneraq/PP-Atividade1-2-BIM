package bussiness;

import java.util.ArrayList;

import data.Livro;


public interface Locacao{
    public boolean SolicitarLocacao(String nomeLivro, ServicoLivro sl);
    public Livro AcompanharLocacao();
    public ArrayList<Livro> VerHistorico();
    public boolean CancelarLocacao(String nomeLivro, ServicoLivro sl);
}
