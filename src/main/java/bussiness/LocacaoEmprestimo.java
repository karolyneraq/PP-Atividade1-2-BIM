package bussiness;

import java.util.ArrayList;

import data.Livro;

public class LocacaoEmprestimo implements Locacao{
    private Livro emprestimoAtual;
    private ArrayList<Livro> emprestimos;

    public boolean SolicitarLocacao(String nomeLivro, ServicoLivro sl){
        for (Livro livro : sl.Visualizar()){
            if (livro.getTitulo().equals(nomeLivro)){
                this.emprestimoAtual = livro;
                return true;
            }
        }

        return false;
    }

    public Livro AcompanharLocacao(){
        return emprestimoAtual;
    }

    public ArrayList<Livro> VerHistorico(){
        return this.emprestimos;
    }

    public boolean CancelarLocacao(String nomeLivro, ServicoLivro sl){
        if (emprestimoAtual.getTitulo().equals(nomeLivro)){
            emprestimoAtual = null;
            return true;
        }

        return false;
    }
}
