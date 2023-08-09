package bussiness;

import java.util.ArrayList;

import data.Editora;
import data.Persistencia;

public class ServicoEditora extends Servico{
    private final ArrayList<Editora> editoras = new ArrayList<>();

    public ServicoEditora(){}
    
    public boolean Cadastrar(String nome){
        for (Editora editora : this.editoras){
            if (editora.getNome().equals(nome)){
                return false;
            }
        }
        
        this.editoras.add(new Editora(nome));
        this.Salvar();
        return true;
    }

    @Override
    public boolean Atualizar(String nomeAtual, String novoNome){
        for (Editora editora : this.editoras){
            if (editora.getNome().equals(nomeAtual)){
                editora.setNome(novoNome);
                this.Salvar();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean Remover(String nome){
        for (Editora editora : this.editoras){
            if (editora.getNome().equals(nome)){
                this.editoras.remove(editora);
                this.Salvar();
                return true;
            }
        }

        return false;
    }

    public String Visualizar(){
        String catalogo = String.format("%-20s|%-20s\n" , "    EDITORA: ", "    QNTD. LIVROS:");
        catalogo += "\n";
        
        for (Editora e : this.editoras){
            catalogo += String.format("%-20s|%-20s\n" , e.getNome(), e.getLivros().size());
        }
        return catalogo;
    }

    public ArrayList<Editora> Buscar(String busca){
        ArrayList<Editora> editorasBuscadas = new ArrayList<>();
        
        for (Editora editor : this.editoras){
            if (editor.getNome().contains(busca)){
                editorasBuscadas.add(editor);
            }
        }

        return editorasBuscadas;
    }

    public ArrayList<Editora> GetEditoras(){
        return this.editoras;
    }

    public void Carregar(){
        this.editoras.addAll(Persistencia.loadEditoras());
    }

    public void Salvar(){
        Persistencia.saveEditoras(editoras);
    }
}
