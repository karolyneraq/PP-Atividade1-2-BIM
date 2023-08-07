package bussiness;

import java.util.ArrayList;

import data.Livro;

abstract public class Servicos {
    public Servicos(){}

    abstract public boolean Cadastrar(String titulo, String autor);

    abstract public boolean Cadastrar(String titulo, String autor, String editora);

    abstract public boolean Atualizar(String nomeAtual, String novoNome);

    abstract public boolean Remover(String nome);

    abstract public ArrayList<Livro> Visualizar();
}
