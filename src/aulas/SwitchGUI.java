package aulas;

import javax.swing.JOptionPane;

public class SwitchGUI {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(
            "Menu\n1 - Novo\n2 - Salvar\n3 - Sair\nDigite sua opção:");
        
        String msg;

        try {
            int opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    msg = "Você escolheu Novo";
                    break;
                case 2:
                    msg = "Você escolheu Salvar";
                    break;
                case 3:
                    msg = "Você escolheu Sair";
                    break;
                default:
                    msg = "Opção inválida!";
            }
        } catch (NumberFormatException e) {
            msg = "Entrada inválida! Digite um número.";
        }

        JOptionPane.showMessageDialog(null, msg);
    }
}
