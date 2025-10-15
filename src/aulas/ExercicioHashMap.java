package aulas;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class ExercicioHashMap extends JFrame {
    private JTextField txtProduto, txtPreco;
    private JTextArea areaResultado;
    private JButton btnAdicionar, btnMostrar;
    private HashMap<String, Double> produtos;
    
    public ExercicioHashMap() {
        setTitle("Exercício HashMap com BoxLayout");
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(null);

        produtos = new HashMap<>();

        txtProduto = new JTextField(15);
        txtPreco = new JTextField(8);
        btnAdicionar = new JButton("Adicionar/Atualizar Produto");
        btnMostrar = new JButton("Mostrar Produtos");
        areaResultado = new JTextArea(12, 35);
        areaResultado.setEditable(false);

        JPanel painel1 = new JPanel();
        painel1.add(new JLabel("Produto:"));
        painel1.add(txtProduto);

        JPanel painel2 = new JPanel();
        painel2.add(new JLabel("Preço:"));
        painel2.add(txtPreco);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnMostrar);

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Mapa antes: ").append(produtos).append("\n");

                String produto = txtProduto.getText().trim();
                try {
                    double preco = Double.parseDouble(txtPreco.getText().trim());
                    produtos.put(produto, preco);
                    sb.append("Produto adicionado/atualizado!\n");
                    sb.append("Mapa depois: ").append(produtos).append("\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Preço inválido!");
                }

                areaResultado.setText(sb.toString());
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder("Produtos e preços:\n");
                for (Map.Entry<String, Double> entry : produtos.entrySet()) {
                    sb.append(entry.getKey())
                      .append(" -> R$ ")
                      .append(entry.getValue())
                      .append("\n");
                }
                areaResultado.setText(sb.toString()); 
            }
        });

        add(painel1);
        add(painel2);
        add(painelBotoes);
        add(new JScrollPane(areaResultado));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExercicioHashMap().setVisible(true);
        });
    }
}
