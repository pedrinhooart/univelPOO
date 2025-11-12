package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.Funcoes;
import util.ResultadoCadastro;

public class UsuarioDAO {

    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios ORDER BY id";
        try (Connection conn = Conexao.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha_hash"));
                usuario.setDataCriacao(rs.getString("data_criacao"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setAtivo(rs.getString("ativo"));
                usuario.setLastLogin(rs.getString("last_login"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    public boolean excluir(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int r = stmt.executeUpdate();
            return r > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("nome_usuario"));
                usuario.setSenha(rs.getString("senha_hash"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setAtivo(rs.getString("ativo"));
                usuario.setDataCriacao(rs.getString("data_criacao"));
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getConnection() throws SQLException {
        return Conexao.conectar();
    }

    public boolean autenticar(Usuario u) {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha_hash = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getLogin());
            stmt.setString(2, Funcoes.gerarHashSHA256(u.getSenha()));

            ResultSet rs = stmt.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao verificar usuário: " + e.getMessage());
        }
        return false;
    }

    public ResultadoCadastro inserir(Usuario u) {
        if (existeUsuario(u.getLogin())) {
            return ResultadoCadastro.USUARIO_EXISTE;
        }

        String sql = "INSERT INTO usuarios (nome_usuario, senha_hash, data_criacao, tipo, ativo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, u.getLogin());
            stmt.setString(2, Funcoes.gerarHashSHA256(u.getSenha()));
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setString(4, "U");
            stmt.setString(5, "T");
            stmt.executeUpdate();

            return ResultadoCadastro.SUCESSO;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            return ResultadoCadastro.ERRO_BANCO;
        }
    }

    private boolean existeUsuario(String login) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE nome_usuario = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar existência de usuário: " + e.getMessage());
        }
        return false;
    }

    public boolean gravar(Usuario u) {
        String sql = "UPDATE usuarios SET nome_usuario = ?, tipo = ?, ativo = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getTipo());
            stmt.setString(3, u.getAtivo());
            stmt.setInt(4, u.getId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            return false;
        }
    }

    public void atualizar() {
        listarTodos();
    }

    public boolean cadastrar(Usuario u) {
        return inserir(u) == ResultadoCadastro.SUCESSO;
    }
}
