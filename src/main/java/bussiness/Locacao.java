import java.util.ArrayList;

public interface Locacao{
    String locacaoAtual = "";

    public boolean SolicitarLocacao(String nomeLivro);
    public String AcompanharLocacao();
    public ArrayList<String> VerHistorico();
}
