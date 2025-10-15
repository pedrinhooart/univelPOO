package aulas;

import javax.swing.JOptionPane;

public class EntradaGrafica {
    public static void main(String[] args) {
        // Entrada de String
        String nome = JOptionPane.showInputDialog("Digite seu nome: ");

        // Entrada de inteiro
        int idade = 0; // Declarar fora do try
        String idadeSrt = JOptionPane.showInputDialog("Digite sua idade: ");
        try {
            idade = Integer.parseInt(idadeSrt);
        }  catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Idade inválida!");
            return; // encerra o programa se idade inválida
        }

        String alturaStr = JOptionPane.showInputDialog("Digite sua altura (ex: 1.75): ");
        double altura =  Double.parseDouble(alturaStr);

        String mensagem = "Nome: " + nome + "\nIdade: " + idade + "\nAltura: " + altura;
        JOptionPane.showMessageDialog(null, mensagem);
        
    }
}