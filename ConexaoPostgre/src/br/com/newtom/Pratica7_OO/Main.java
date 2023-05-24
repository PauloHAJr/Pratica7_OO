package br.com.newtom.Pratica7_OO;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConsultaLivro cl = new ConsultaLivro();
        InserirLivro il = new InserirLivro();
        ExcluirLivro el = new ExcluirLivro();

        int opcao = Integer.parseInt(JOptionPane.showInputDialog("<1> Cadastrar Livro \n<2> Pesquisar Livro por Preço \n<3> Pesquisar Livro por Título \n<4> Excluir Livro \n<5> Sair"));

        while(opcao != 5) {

            switch (opcao) {
                case 1:
                    il.inserirLivro();
                    break;

                case 2:
                    cl.consultaPreco();
                    break;

                case 3:
                    cl.consultaTitulo();
                    break;

                case 4:
                    el.excluirLivro();
                    break;

                default:
                    break;
    }}

    }
}
