package aulas;

import java.util.Scanner;

public class EntradaConsole {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = entrada.nextInt();
        
        System.out.println("digite sua altura: ex:(1,75)");
        double altura = entrada.nextDouble();
        
        System.out.println("\n -resultado-");
        System.out.println("nome: " + nome);
        System.out.println("idade: " + idade);
        System.out.println("altura: " + altura);
        
        entrada.close();
    }
}
