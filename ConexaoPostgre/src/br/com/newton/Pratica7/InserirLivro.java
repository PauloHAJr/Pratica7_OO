package br.com.newton.Pratica7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InserirLivro {
        public void inserirLivro(Livro livro) {
            String sql = "insert into livro (nm_titulo, nm_autor, vl_preco) values (?, ?, ?)";

            try (Connection connection = ConexaoBD.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, livro.getTitulo());
                statement.setString(2, livro.getAutor());
                statement.setDouble(3, livro.getPreco());
                statement.executeUpdate();
                System.out.println("Livro inserido com sucesso!");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

