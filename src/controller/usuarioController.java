package controller;

import dao.UsuarioDAO;
import model.Usuario;
import util.ResultadoCadastro;

public class UsuarioController {
    
    private final UsuarioDAO d = new UsuarioDAO();

    public boolean login(String login, String senha) {
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        return d.autenticar(u);
    }

    public ResultadoCadastro cadastrar(String login, String senha) {
        Usuario u = new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        u.setAtivo("F");
        u.setTipo("U");
        return d.inserir(u);

    }
}
