package dao;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) {

        // O try-with-resources garante que a conexão será fechada no final.
        try (Connection conexao = Conexao.conectar()) {

            // Se a conexão não for nula, o teste passou.
            if (conexao != null) {
                System.out.println("Teste bem-sucedido. Conexão foi obtida.");
                // A conexão será fechada automaticamente aqui.
            } else {
                System.out.println("Teste falhou. A conexão retornou nula.");
            }

        } catch (SQLException e) {
            // Este 'catch' é necessário caso ocorra um erro ao fechar a conexão.
            System.out.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}