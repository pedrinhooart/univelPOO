package aulas;

import java.awt.*;
import javax.swing.*;

// Deixe esta classe sem 'public' para não haver duas classes públicas no mesmo arquivo
class IdadeInvalida extends Exception {
    public IdadeInvalida(String msg) {
        super(msg);
    }
}

public class ExessaoIdadeInvalida extends JFrame {
    public ExessaoIdadeInvalida() {
        setTitle("excessoes personalizadas - java out");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));
        setLocationRelativeTo(null);

        JButton btn1 = new JButton("Excessao personalizada");

        add(btn1);
        btn1.addActionListener(e -> {
            JFrame janela = new JFrame("excessao personalizada");
            janela.setSize(300, 200);
            janela.setLayout(new FlowLayout());
            janela.setLocationRelativeTo(this);

            JTextField idade = new JTextField(5);
            JButton verificar = new JButton("verificar");

            janela.add(new JLabel("Idade:"));
            janela.add(idade);
            janela.add(verificar);

            verificar.addActionListener(a -> {
                try {
                    int valor = Integer.parseInt(idade.getText());
                    if (valor < 0) {
                        throw new IdadeInvalida("idade nao pode ser negativa");
                    }
                    JOptionPane.showMessageDialog(janela, "idade valida: " + valor);
                } catch (IdadeInvalida ex) {
                    JOptionPane.showMessageDialog(janela, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(janela, "digite um numero valido", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });

            janela.setVisible(true);
        });
    }

    public static void main(String[] args) {
        new ExessaoIdadeInvalida().setVisible(true);
    }
}
