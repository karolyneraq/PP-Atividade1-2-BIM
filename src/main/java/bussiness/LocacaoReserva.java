package bussiness;

import java.util.ArrayList;

import data.Livro;

public class LocacaoReserva implements Locacao{
    private Livro reservaAtual;
    private ArrayList<Livro> reservas = new ArrayList<>();

    public boolean SolicitarLocacao(String nomeLivro, ServicoLivro sl){
        for (Livro livro : sl.GetLivros()){
            if (livro.getTitulo().equals(nomeLivro)){
                reservaAtual = livro;
                this.reservas.add(livro);
                return true;
            }
        }

        return false;
    }

    public Livro AcompanharLocacao(){
        return this.reservaAtual;
    }

    public String VerHistorico(){
        String historico = String.format("%-20s| %-20s | %-20s" , "TÍTULO: ", "AUTOR:", "EDITORA");
        historico += "\n";
        
        for (Livro l : this.reservas){
            if (l.getEditora() == null){
            historico += String.format("%-20s| %s" , l.getTitulo(), l.getAutor().getNome() );
            }
            else{
            historico += String.format("%-20s| %-20s | %-20s" , l.getTitulo(), l.getAutor().getNome(), l.getEditora().getNome());
            }
            
            historico += "\n";
        }
        return historico;
    }

    public boolean CancelarLocacao(String nomeLivro, ServicoLivro sl){
        if (reservaAtual.getTitulo().equals(nomeLivro)){
            reservaAtual = null;
            return true;
        }

        return false;
    }
}
