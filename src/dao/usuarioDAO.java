package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

class Usuario {
    private int id;
    private String username;
    private String password;
    private LocalDateTime lastLogin;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
}

public class UsuarioDAO {
    private Connection getConnection() throws SQLException {
        throw new SQLException("Implement your connection logic here");
    }

    public boolean autenticar(Usuario usuario) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getPassword());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setLastLogin(LocalDateTime.now());
                atualizarUltimoLogin(usuario);
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    private void atualizarUltimoLogin(Usuario usuario) {
        String sql = "UPDATE usuarios SET last_login = ? WHERE id = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setTimestamp(1, Timestamp.valueOf(usuario.getLastLogin()));
            pstmt.setInt(2, usuario.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
        }
    }
}