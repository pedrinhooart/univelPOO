package controller;

// Idealmente, a classe Cliente (Model) deveria ser usada aqui, mas
// usaremos tipos básicos como exemplo.
public class clienteController {
    
    // Exemplo de método: Salvar/Atualizar Cliente.
    public void salvarCliente(String nome, String cpf) {
        // 1. Validação de dados de entrada
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro no Controller: O nome do cliente é obrigatório.");
            return;
        }
        
        // 2. Chamada à camada de persistência (DAO)
        System.out.println("Controller: Preparando para salvar cliente: " + nome + " - " + cpf);
        // new dao.clienteDAO().salvar(nome, cpf); // Chamaria o DAO
    }
    
    // Exemplo de método: Buscar Cliente.
    public String buscarCliente(String cpf) {
        // Lógica completa envolveria chamar o DAO.
        // return new dao.clienteDAO().buscarPorCpf(cpf);
        return "Controller: Cliente encontrado (simulado) para CPF: " + cpf;
    }
}