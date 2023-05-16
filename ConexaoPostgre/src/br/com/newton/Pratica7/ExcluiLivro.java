package br.com.newton.Pratica7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluiLivro {
        public void excluirLivro(int idLivro) {
            String sql = "DELETE FROM Livros WHERE id = ?";

            try (Connection connection = ConexaoBD.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idLivro);
                statement.executeUpdate();
                System.out.println("Livro excluído com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
