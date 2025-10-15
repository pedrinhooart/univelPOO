package aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ExercicioArrayList extends JFrame {
    private JTextArea areaResultado;
    private JButton btnExecutar;

    public ExercicioArrayList() {
        setTitle("Exercício ArrayList com GridLayout");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 1, 10, 10));

        setLocationRelativeTo(null);

        btnExecutar = new JButton("Gerar Lista e Remover Pares");
        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        btnExecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> numeros = new ArrayList<>();

                for (int i = 1; i <= 10; i++) {
                    numeros.add(i);
                }

                StringBuilder sb = new StringBuilder();
                sb.append("Lista inicial: ").append(numeros).append("\n");

                ArrayList<Integer> pares = new ArrayList<>();
                for (int n : numeros) {
                    if (n % 2 == 0) {
                        pares.add(n);
                    }
                }
                sb.append("Números pares: ").append(pares).append("\n");
                
                numeros.removeIf(n -> n % 2 == 0);
                sb.append("Lista final (sem pares): ").append(numeros);
              
                areaResultado.setText(sb.toString());
            }
        });

        add(btnExecutar);
        add(new JScrollPane(areaResultado));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExercicioArrayList().setVisible(true);
        });
    }
}