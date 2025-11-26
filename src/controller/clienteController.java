package controller;

import dao.ClienteDAO;

public class ClienteController {
    
    // Instancia o DAO (a camada de persistência)
    private final ClienteDAO dao = new ClienteDAO(); 

    // Exemplo de método: Salvar/Atualizar Cliente.
    public boolean salvarCliente(String nome, String cpf) {
        // 1. Validação de dados de entrada
        if (nome == null || nome.trim().isEmpty()) {
            System.err.println("Erro no Controller: O nome do cliente é obrigatório.");
            return false;
        }
        
        // 2. Validação de CPF (utilizando a classe ValidadorCPF)
        // if (!util.ValidadorCPF.isCPFValido(cpf)) {
        //     System.err.println("Erro no Controller: CPF inválido.");
        //     return false;
        // }
        
        // 3. Chamada à camada de persistência (DAO)
        System.out.println("Controller: Preparando para salvar cliente: " + nome + " - " + cpf);
        
        return dao.salvar(nome, cpf); 
    }
}