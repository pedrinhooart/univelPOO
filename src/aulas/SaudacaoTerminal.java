package aulas;

import java.util.Scanner; //importa a biblioteca java.util
public class SaudacaoTerminal {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler entrada do usuário
        Scanner entrada = new Scanner(System.in);
        // Solicita ao usuário que digite seu nome
        System.out.print("Digite seu nome: ");
        // Lê o nome do usuário
        String nome = entrada.nextLine();
        // Exibe uma saudação personalizada
        System.out.println("Olá, " + nome + "! Bem-vindo ao terminal Java.");
        // Fecha o objeto Scanner
        entrada.close();
    }
}
