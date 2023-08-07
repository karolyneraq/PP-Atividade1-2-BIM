import java.util.ArrayList;

public class EmprestimoService implements Locacao{
    private String emprestimoAtual;
    private ArrayList<String> emprestimos;

    public boolean SolicitarLocacao(String nomeLivro){
        return true;
    }

    public String AcompanharLocacao(){
        return emprestimoAtual;
    }

    public ArrayList<String> VerHistorico(){
        return this.emprestimos;
    }
}