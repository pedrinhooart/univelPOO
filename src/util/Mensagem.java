package util;

import javax.swing.JOptionPane;

public class Mensagem {
    public static void info(String msg) {
        JOptionPane.showMessageDialog(null, msg, "informação");
        JOptionPane.INFORMATION_MESSAGE;
    }

    public static void erro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "erro", JOptionPane.ERROR_MESSAGE);
    }
}
