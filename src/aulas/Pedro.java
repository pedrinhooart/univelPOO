package aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pedro {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cálculo média do aluno");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JLabel lblNota1 = new JLabel("Nota 1:");
        JTextField txtNota1 = new JTextField();
        JLabel lblNota2 = new JLabel("Nota 2:");
        JTextField txtNota2 = new JTextField();
        JLabel lblNota3 = new JLabel("Nota 3:");
        JTextField txtNota3 = new JTextField();

        JButton btnCalcular = new JButton("Calcular Média");
        JLabel lblResultado = new JLabel("Média: ");
        JButton btnSair = new JButton("Sair");

        frame.add(lblNota1); frame.add(txtNota1);
        frame.add(lblNota2); frame.add(txtNota2);
        frame.add(lblNota3); frame.add(txtNota3);
        frame.add(new JLabel()); frame.add(btnCalcular);
        frame.add(lblResultado); frame.add(new JLabel());
        frame.add(btnSair); frame.add(new JLabel());

        btnCalcular.addActionListener(e -> {
            try {
                double n1 = Double.parseDouble(txtNota1.getText());
                double n2 = Double.parseDouble(txtNota2.getText());
                double n3 = Double.parseDouble(txtNota3.getText());
                double media = (n1 + n2 + n3) / 3;
                lblResultado.setText("Média: " + String.format("%.2f", media));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Digite apenas números válidos.");
            }
        });

        btnSair.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
