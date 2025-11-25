package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    // CORREÇÃO: Usar o nome do banco de dados 'univel4a' do script.sql para consistência.
    private static final String DB_NAME = "univel4a"; 
	private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root"; // seu usuário do MySQL
	private static final String PASSWORD = "vssql"; // sua senha do MySQL

    // CORREÇÃO: Adiciona construtor privado para evitar instanciacao, pois a classe é utilitária (só métodos estáticos)
    private conexao() {
        // Classe utilitária, não deve ser instanciada.
    }

    public static Connection conectar() {
        Connection conexao = null;
        try {
            // Class.forName() é mantido por compatibilidade
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso! (Banco: " + DB_NAME + ")");

        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            // CORREÇÃO: Usa System.err para imprimir a mensagem de erro da conexão
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }
}