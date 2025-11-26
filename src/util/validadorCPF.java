package util;

public class ValidadorCPF { 
    
    // Construtor privado para evitar instanciação, pois a classe é utilitária.
    private ValidadorCPF() {
        // Classe utilitária, não deve ser instanciada.
    }

    /**
     * Verifica se o CPF é formalmente válido.
     * Nota: A lógica completa dos dígitos verificadores deve ser implementada aqui.
     * @param cpf O CPF como String.
     * @return true se passar na verificação de formato básico, false caso contrário.
     */
    public static boolean isCPFValido(String cpf) {
        if (cpf == null) {
            return false;
        }
        
        String cpfLimpo = cpf.replaceAll("[^0-9]", ""); // Remove não-dígitos
        
        if (cpfLimpo.length() != 11) {
            System.out.println("CPF Inválido: Deve conter 11 dígitos.");
            return false;
        }
        
        // Impede CPFs com todos os dígitos iguais (ex: 11111111111)
        if (cpfLimpo.matches("(\\d)\\1{10}")) {
            System.out.println("CPF Inválido: Não pode ter todos os dígitos iguais.");
            return false;
        }
        
        // Lógica completa dos dígitos verificadores seria implementada aqui.
        
        return true; 
    }
}