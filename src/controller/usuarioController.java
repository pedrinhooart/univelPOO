package controller;

public class usuarioController {
    
    /**
     * Tenta autenticar um usuário com nome de usuário e senha.
     * @param nomeUsuario Nome de usuário.
     * @param senha Senha (sem hash).
     * @return true se as credenciais forem válidas, false caso contrário.
     */
    public boolean autenticar(String nomeUsuario, String senha) {
        // 1. Validação simples
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty() || senha == null || senha.isEmpty()) {
            System.out.println("Controller: Nome de usuário e senha são obrigatórios.");
            return false;
        }
        
        // 2. Chamada à camada de persistência (DAO) para verificar as credenciais.
        // Em um projeto real, a senha seria hasheada antes de ser comparada com a senha_hash do banco.
        
        // Simulação de autenticação: 'admin' com senha '1234'
        if (nomeUsuario.equalsIgnoreCase("admin") && senha.equals("1234")) {
            System.out.println("Controller: Usuário " + nomeUsuario + " autenticado com sucesso.");
            return true;
        } else {
            System.out.println("Controller: Credenciais inválidas para " + nomeUsuario + ".");
            return false;
        }
    }
}