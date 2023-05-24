package br.com.newtom.Pratica7_OO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaLivro {

    private String nm_titulo;
    private double vl_preco;

    private static final String sqlConsultaTitulo = "SELECT * FROM livro WHERE nm_titulo LIKE ?";
    private static final String sqlConsultaPreco = "SELECT * FROM livro WHERE vl_preco >= ?";

    public void consultaTitulo() {

        try (Connection connection = Conexao.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlConsultaTitulo);) {
            preparedStatement.setString(1, JOptionPane.showInputDialog("Digite o titulo:") + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nm_titulo = rs.getString("nm_titulo");
                JOptionPane.showMessageDialog(null,"Título: "+nm_titulo);
            }


            /*String nm_titulo = rs.getString("nm_titulo");
            JOptionPane.showMessageDialog(null,"Título: "+nm_titulo);*/

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void consultaPreco() {

        try(Connection connection = Conexao.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlConsultaPreco);)  {

            preparedStatement.setDouble(1, Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do livro: ")));
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            String nm_titulo = rs.getString("nm_titulo");
            while (rs.next()) {
                double vl_preco = rs.getDouble("vl_preco");
                JOptionPane.showMessageDialog(null, "Título: " + nm_titulo + "\nPreço: " + vl_preco);
            }
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
