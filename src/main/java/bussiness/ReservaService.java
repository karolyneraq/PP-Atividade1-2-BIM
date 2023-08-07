import java.util.ArrayList;

public class ReservaService implements Locacao{
    private String reservaAtual;
    private ArrayList<String> reservas;

    public boolean SolicitarLocacao(String nomeLivro){
        return true;
    }

    public String AcompanharLocacao(){
        return this.reservaAtual;
    }

    public ArrayList<String> VerHistorico(){
        return this.reservas;
    }
}