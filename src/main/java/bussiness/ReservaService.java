import java.util.ArrayList;

public class ReservaService implements Locacao{
    private String reservaAtual;
    private ArrayList<String> reservas;

    public void SolicitarLocacao(String nomeLivro){
        System.out.println("Reserva do livro " + nomeLivro + "concluída.");
    }

    public void AcompanharLocacao(){
        System.out.println("Você reservou o livro: " + reservaAtual);
    }

    public void VerHistorico(){
        for (String reserva : reservas){
            System.out.println("Reservou o livro: " + reserva);
        }
    }
}