package br.com.newton.Pratica7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaLivro {
    public List<Livro> buscarLivroPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        String sql = "select * from livro where nm_titulo = ?";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, titulo + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getString("id_isbn"));
                livro.setTitulo(resultSet.getString("nm_titulo"));
                livro.setAutor(resultSet.getString("nm_autor"));
                livro.setPreco(resultSet.getDouble("vl_preco"));
                livrosEncontrados.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livrosEncontrados;
    }

    public List<Livro> buscarLivroPorPreco(double precoMinimo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        String sql = "select * from livro where vl_preco >= ?";

        try (Connection connection = ConexaoBD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, precoMinimo);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Livro livro = new Livro();
                livro.setId(resultSet.getString("id_isbn"));
                livro.setTitulo(resultSet.getString("nm_titulo"));
                livro.setAutor(resultSet.getString("nm_autor"));
                livro.setPreco(resultSet.getDouble("vl_preco"));
                livrosEncontrados.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livrosEncontrados;
    }
}
