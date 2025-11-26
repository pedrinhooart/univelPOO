package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.ResultadoCadastro;

public class ProdutoDAO {

    public boolean existeProduto(String nomeProduto) {
        String sql = "SELECT 1 FROM produtos WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nomeProduto);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // true = existe

        } catch (SQLException e) {
            System.out.println("Erro ao verificar existência de produto: " + e.getMessage());
            return false;
        }
    }

    // Insere um novo produto
    public ResultadoCadastro inserir(Produto produto) {

        if (existeProduto(produto.getNome())) {
            return ResultadoCadastro.USUARIO_EXISTE;
        }

            String sql = "INSERT INTO produtos (nome, preco, marca, data_cadastro) " + "VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getMarca());
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

            stmt.executeUpdate();

            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        }
    }

    public boolean excluir(int idProduto) {

    String sql = "DELETE FROM produtos WHERE id = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idProduto);

        int r = stmt.executeUpdate();

        return r > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public List<Produto> listarTodos() {
    List<Produto> lista = new ArrayList<>();
    String sql = "SELECT * FROM produtos ORDER BY id";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto u = new Produto();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setMarca(rs.getString("marca"));
            u.setPreco(rs.getDouble("preco"));
            

            lista.add(u);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

public Produto buscarPorId(int id) {
    String sql = "SELECT * FROM produtos WHERE id = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Produto u = new Produto();

            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setMarca(rs.getString("marca"));
            u.setPreco(rs.getDouble("preco"));
            
            return u;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

public boolean gravar(Produto p) {
    String sql = "UPDATE produtos SET nome = ?, marca = ?, preco = ? WHERE id = ?";
    
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getMarca());
        stmt.setDouble(3, p.getPreco());
        stmt.setInt(4, p.getId());

        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar produto: " + e.getMessage());
        return false;
    }
}

public void atualizar() {
    listarTodos();
}
}
