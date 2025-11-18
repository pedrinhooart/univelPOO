package model;

import java.time.LocalDateTime;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String dataCriacao;
    private String tipo;
    private String lastLogin;
    private String ativo; // NOVO: Campo ativo adicionado

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(String dataCriacao) { this.dataCriacao = dataCriacao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getLastLogin() { return lastLogin; }
    public void setLastLogin(String lastLogin) { this.lastLogin = lastLogin; }

    // CORRIGIDO: Implementação do setAtivo
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    // CORRIGIDO: Implementação do getAtivo
    public String getAtivo() {
        return ativo;
    }

    // CORRIGIDO: Implementação para definir o login (antigo setUsername)
    public void setUsername(String login) {
        this.login = login;
    }
    
    // CORRIGIDO: Implementação para setar LastLogin a partir de LocalDateTime
    public void setLastLogin(LocalDateTime now) {
        // Converte LocalDateTime para String para armazenar no campo lastLogin
        this.lastLogin = now.toString();
    }

    /*
     * MÉTODOS REMOVIDOS/IGNORADOS POIS ERAM INCORRETOS OU REDUNDANTES:
     * - public static String getPassword(): Removido por ser estático e redundante (getSenha já existe).
     * - public boolean autenticar(Usuario u): Removido. A lógica de autenticação deve estar no UsuarioDAO.
     */
}