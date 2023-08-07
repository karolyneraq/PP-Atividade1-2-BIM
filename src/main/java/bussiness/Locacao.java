public interface Locacao{
    String locacaoAtual = "";

    public void SolicitarLocacao(String nomeLivro);
    public String AcompanharLocacao();
    public void VerHistorico();
}
