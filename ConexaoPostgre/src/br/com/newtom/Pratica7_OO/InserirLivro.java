package br.com.newtom.Pratica7_OO;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirLivro {
    private String id_isbn,nm_titulo;
    private double vl_preco;

    private static final String sqlInserir = "INSERT INTO livro (id_isbn, nm_titulo, vl_preco) VALUES (?, ?, ?);";

   /* public static void main(String[] argv) throws SQLException {
        Inserir createTableExample = new InserirLivro();
        createTableExample.insertRecord();
    }*/

    public void inserirLivro() throws SQLException {


        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInserir)) {

            preparedStatement.setString(1, id_isbn = JOptionPane.showInputDialog("Digite o id_isbn"));
            preparedStatement.setString(2, nm_titulo = JOptionPane.showInputDialog("Digite o nm_titulo"));
            preparedStatement.setDouble(3, vl_preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o nm_titulo")));

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            System.out.println("Livro inserido com sucesso!");
        } catch (SQLException e) {

            printSQLException(e);
        }

    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
