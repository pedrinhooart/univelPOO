package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO { // Nota: A convenção Java sugere ClienteDAO
    
    // Método de exemplo para salvar um cliente no banco
    public boolean salvar(String nome, String cpf) {
        String sql = "INSERT INTO clientes (nome, cpf) VALUES (?, ?)"; 
        
        // Uso de try-with-resources para garantir que a Connection seja fechada.
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            if (conn == null) {
                System.err.println("DAO Cliente: Conexão não estabelecida.");
                return false;
            }

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            
            int linhasAfetadas = stmt.executeUpdate();
            System.out.println("DAO Cliente: Cliente " + nome + " salvo com sucesso. Linhas afetadas: " + linhasAfetadas);
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("DAO Cliente: Erro ao salvar cliente: " + e.getMessage());
            return false;
        }
    }
}