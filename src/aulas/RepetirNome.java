package aulas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RepetirNome extends JFrame {

    private final JTextField txtNome;
    private final JTextField txtQuantidade;
    private final JTextArea txtResultado;
    private final JButton btnExecutar;

    public RepetirNome() {
        setTitle("Repetir Nome com FOR");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        JLabel lblNome = new JLabel("Digite seu nome:");
        txtNome = new JTextField(20);

        JLabel lblQuantidade = new JLabel("Quantas vezes repetir?");
        txtQuantidade = new JTextField(5);

        btnExecutar = new JButton("Repetir nome");
        txtResultado = new JTextArea(10, 35);
        txtResultado.setEditable(false);
        txtResultado.setLineWrap(true);
        txtResultado.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(txtResultado,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(lblNome);
        add(txtNome);
        add(lblQuantidade);
        add(txtQuantidade);
        add(btnExecutar);
        add(scroll);

        btnExecutar.addActionListener((ActionEvent e) -> executar());
    }

    private void executar() {
        txtResultado.setText("");
        String nome = txtNome.getText().trim();
        String qtdStr = txtQuantidade.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um nome!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int qtd;
        try {
            qtd = Integer.parseInt(qtdStr);
            if (qtd <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um número inteiro positivo!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // evita continuar com valor inválido
        }

        for (int i = 1; i <= qtd; i++) {
            txtResultado.append(i + " - " + nome + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RepetirNome().setVisible(true));
    }
}
