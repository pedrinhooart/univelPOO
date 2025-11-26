package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao { // Nota: A convenção Java sugere Conexao
    
    private static final String DB_NAME = "univel4a"; 
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root"; // seu usuário do MySQL
	private static final String PASSWORD = "vssql"; // sua senha do MySQL

    // Construtor privado para evitar instanciação
    private Conexao() {} 

    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso! (Banco: " + DB_NAME + ")");

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    public static Connection getConexao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getConexao'");
    }

    public static void fecharConexao(Connection conexao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fecharConexao'");
    }
}