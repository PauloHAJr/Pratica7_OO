package br.com.newtom.Pratica7_OO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/BDlivrariaUniversitaria", "postgres", "123456");
            return conexao;
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não localizado!");
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + e.getMessage());
        }

        return null;
    }
}
