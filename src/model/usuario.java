package model;

import java.time.LocalDateTime;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private String dataCriacao;
    private String tipo;
    private String lastLogin;

    public int getId() {return id; }
    public void setId(int id) { this.id = id; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(String dataCriacao) { this.dataCriacao = dataCriacao; }
    public void setUsername(String login) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUsername'");
    }

    public String getTipo() {return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public static String getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }
    public String getLastLogin() {return lastLogin;}
    public void setLastLogin(String lastLogin) {this.lastLogin = lastLogin;}
    public void setLastLogin(LocalDateTime now) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLastLogin'");
    }
    public void setAtivo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAtivo'");
    }
    public String getAtivo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAtivo'");
    }

}
