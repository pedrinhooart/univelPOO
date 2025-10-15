package aulas;

import javax.swing.JOptionPane;
import java.util.Calendar;

public class WhileTryCalendarGUI {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("digite seu nome: ");

        int idade = -1;

        while (idade < 0){
            try {
                String idadeString = JOptionPane.showInputDialog("digite sua idade: ");
                idade = Integer.parseInt(idadeString);
                
                if (idade < 0) {
                    JOptionPane.showMessageDialog(null, "idade nao pode ser negativa");
                }
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "valor invalido");
            }
        }

        Calendar calendario = Calendar.getInstance();
        int anoAtual = calendario.get(Calendar.YEAR);
        int anoNascimento = anoAtual - idade;
        
        String mensagem = "olá, " + nome + "\nVocê nasceu em " + anoNascimento;
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
