package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clienteDAO {
    
    // Método de exemplo para salvar um cliente no banco
    public boolean salvar(String nome, String cpf) {
        // CORREÇÃO: Assume que a tabela 'clientes' será criada no script.sql
        String sql = "INSERT INTO clientes (nome, cpf) VALUES (?, ?)"; 
        
        try (Connection conn = conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            if (conn == null) {
                System.out.println("DAO Cliente: Conexão não estabelecida.");
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
    
    // Outros métodos de CRUD (buscar, atualizar, deletar) viriam aqui.
}