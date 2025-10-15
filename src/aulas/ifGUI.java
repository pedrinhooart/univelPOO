package aulas;

import javax.swing.JOptionPane;

public class ifGUI {
    public static void main(String[] args) {
        String numStr = JOptionPane.showInputDialog("digite um numero: ");
        int num = Integer.parseInt(numStr);
        String msg;
        if (num > 0) {
            msg = "o numero é positivo";
        } else if (num < 0) {
            msg = "o numero é negativo";
        } else {
            msg = "o numero é zero";
        }
        JOptionPane.showMessageDialog(null, msg);
    }
}
