package util;

public class validadorCPF { // Nome de classe deveria ser ValidadorCPF (convenção Java)
    
    // Adiciona construtor privado para evitar instanciacao
    private validadorCPF() {
        // Classe utilitária, não deve ser instanciada.
    }

    /**
     * Verifica se o CPF é formalmente válido (tamanho e formato básico).
     * NOTA: A implementação real deve conter a lógica completa dos dígitos verificadores.
     * Esta é uma versão simplificada para estruturar a classe.
     * @param cpf O CPF como String (pode conter . e -).
     * @return true se for válido (ou passar na verificação simplificada).
     */
    public static boolean isCPFValido(String cpf) {
        if (cpf == null) {
            return false;
        }
        
        String cpfLimpo = cpf.replaceAll("[^0-9]", ""); // Remove não-dígitos
        
        if (cpfLimpo.length() != 11) {
            return false;
        }
        
        // Impede CPFs com todos os dígitos iguais (ex: 111.111.111-11)
        if (cpfLimpo.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        // A lógica completa dos dígitos verificadores seria implementada aqui.
        
        return true; // Retorno otimista simulado
    }
}