package bussiness;

import java.util.ArrayList;

import data.Editora;
import data.Persistencia;

public class ServicoEditora extends Servico{
    private ArrayList<Editora> editoras;

    public ServicoEditora(){}
    
    public boolean Cadastrar(String nome){
        for (Editora editora : this.editoras){
            if (editora.getNome().equals(nome)){
                return false;
            }
        }
        
        editoras.add(new Editora(nome));
        return true;
    }

     public boolean Atualizar(String nomeAtual, String novoNome){
         for (Editora editora : this.editoras){
             if (editora.getNome().equals(nomeAtual)){
                 editora.setNome(novoNome);
                 return true;
             }
         }

         return false;
     }

     public boolean Remover(String nome){
         for (Editora editora : this.editoras){
             if (editora.getNome().equals(nome)){
                 this.editoras.remove(editora);
                 return true;
             }
         }

         return false;
     }

     public ArrayList<Editora> Visualizar(){
         return this.editoras;
     }

    public ArrayList<Editora> Buscar(String busca){
        ArrayList<Editora> editorasBuscadas = new ArrayList<Editora>();
        
        for (Editora editor : this.editoras){
            if (editor.getNome().contains(busca)){
                editorasBuscadas.add(editor);
            }
        }

        return editorasBuscadas;
    }

    public void Carregar(){
        this.editoras.addAll(Persistencia.loadEditoras());
    }
}
