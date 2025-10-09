package aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaudacaoGUI extends JFrame {
    private JTextField campoNome;
    private JButton botaoSaudar;
    private JLabel labelMensagem;

    /**
     * 
     */
    public SaudacaoGUI() {
        setTitle("Programa Saudação");

        setSize(350, 150);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

        campoNome = new JTextField(20);

        botaoSaudar = new JButton("saudar");

        labelMensagem = new JLabel("digite seu nome e clique em saudar");

        painel.add(new JLabel("nome: "));
        painel.add(campoNome);
        painel.add(botaoSaudar);
        painel.add(labelMensagem);

        botaoSaudar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText().trim();

                if (nome.isEmpty()) {
                    labelMensagem.setText("por favor, digite o nome: ");
                } else {
                    labelMensagem.setText("ola, "+ nome + "bao?");
                }
            }
        });

        add(painel);
    }
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                SaudacaoGUI janela = new SaudacaoGUI();
                janela.setVisible(true); 
            });
        }
    }