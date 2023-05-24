package br.com.newtom.Pratica7_OO;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluirLivro {

    private String id_isbn;
    private static final String sqlExcluir = "delete from livro where id_isbn = ?;";

    public void excluirLivro() throws SQLException {

        try (Connection connection = Conexao.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(sqlExcluir);) {

            preparedStatement.setString(1, id_isbn = JOptionPane.showInputDialog("Digite o id_isbn do livro que deseja excluir"));

            int result = preparedStatement.executeUpdate();
            System.out.println("Livro excluído com sucesso!");

            System.out.println("Number of records affected :: " + result);
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

