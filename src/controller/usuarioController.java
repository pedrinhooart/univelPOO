package controller;

public class UsuarioController {
    
    /**
     * Tenta autenticar um usuário com nome de usuário e senha (simulado).
     * @param nomeUsuario Nome de usuário.
     * @param senha Senha.
     * @return true se as credenciais forem válidas (admin/1234), false caso contrário.
     */
    public boolean autenticar(String nomeUsuario, String senha) {
        // 1. Validação simples
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty() || senha == null || senha.isEmpty()) {
            System.err.println("Controller: Nome de usuário e senha são obrigatórios.");
            return false;
        }
        
        // Simulação de autenticação: 'admin' com senha '1234'
        if (nomeUsuario.equalsIgnoreCase("admin") && senha.equals("1234")) {
            return true;
        } else {
            System.out.println("Controller: Credenciais inválidas para " + nomeUsuario + ".");
            return false;
        }
    }

    public boolean cadastrar(String login, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }
}