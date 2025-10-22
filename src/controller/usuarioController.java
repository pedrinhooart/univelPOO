package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
    
    private final UsuarioDAO dao = new UsuarioDAO();


    public boolean login(String login, String senha) {
        Usuario u = dao new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        return dao.autenticar(u);
    }

    public boolean cadastrar(String login, String senha) {
        Usuario u = dao new Usuario();
        u.setLogin(login);
        u.setSenha(senha);
        return dao.autenticar(u);
    }
}
