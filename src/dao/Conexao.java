package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	// A URL foi corrigida para usar o banco de dados 'univel4a', conforme o script.sql
	private static final String URL = "jdbc:mysql://localhost:3307/univel4a?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root"; // seu usuário do MySQL
	private static final String PASSWORD = "vssql"; // sua senha do MySQL

    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
            return conexao;
    }
}