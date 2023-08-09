package bussiness;

import java.util.ArrayList;

import data.Livro;

public class LocacaoEmprestimo implements Locacao{
    private Livro emprestimoAtual;
    private ArrayList<Livro> emprestimos = new ArrayList<>();

    @Override
    public boolean SolicitarLocacao(String nomeLivro, ServicoLivro sl){
        for (Livro livro : sl.GetLivros()){
            if (livro.getTitulo().equals(nomeLivro)){
                this.emprestimoAtual = livro;
                this.emprestimos.add(livro);
                return true;
            }
        }

        return false;
    }

    public Livro AcompanharLocacao(){
        return emprestimoAtual;
    }

    public String VerHistorico(){
        String historico = String.format("%-20s| %-20s | %-20s" , "TÍTULO: ", "AUTOR:", "EDITORA");
        historico += "\n";
        
        for (Livro l : this.emprestimos){
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
        if (this.emprestimoAtual.getTitulo().equals(nomeLivro)){
            this.emprestimoAtual = null;
            return true;
        }

        return false;
    }
}
