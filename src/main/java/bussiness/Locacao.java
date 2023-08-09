package bussiness;

import data.Livro;

public interface Locacao{
    public boolean SolicitarLocacao(String nomeLivro, ServicoLivro sl);
    public Livro AcompanharLocacao();
    public String VerHistorico();
    public boolean CancelarLocacao(String nomeLivro, ServicoLivro sl);
}
