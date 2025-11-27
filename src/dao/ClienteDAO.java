package dao;

import model.Cliente;
import util.ResultadoCadastro;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean existeCliente(String nome) {
        String sql = "SELECT 1 FROM clientes WHERE nome = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar existência de cliente: " + e.getMessage());
            return false;
        }
    }

    public ResultadoCadastro inserir(Cliente c) {

        if (existeCliente(c.getNome())) {
            return ResultadoCadastro.USUARIO_EXISTE;
        }

        String sql = "INSERT INTO clientes (nome, email, fone, cpf, data_nasc, peso) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getCpf());
            stmt.setDate(5, Date.valueOf(c.getDataNascimento()));
            stmt.setDouble(6, c.getPeso());

            stmt.executeUpdate();
            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        }
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY id";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("fone"));
                c.setCpf(rs.getString("cpf"));

                Date dt = rs.getDate("data_nasc");
                if (dt != null) {
                    c.setDataNascimento(dt.toLocalDate());
                }

                c.setPeso(rs.getDouble("peso"));

                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("fone"));
                c.setCpf(rs.getString("cpf"));
                c.setPeso(rs.getDouble("peso"));

                Date dt = rs.getDate("data_nasc");
                if (dt != null) {
                    c.setDataNascimento(dt.toLocalDate());
                }

                return c;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean gravar(Cliente c) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, cpf = ?, data_nascimento = ?, peso = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getCpf());
            stmt.setDate(5, Date.valueOf(c.getDataNascimento()));
            stmt.setDouble(6, c.getPeso());
            stmt.setInt(7, c.getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        }
    }
}