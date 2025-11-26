package view;

import dao.ProdutoDAO;
import java.awt.*;
import javax.swing.*;
import model.Produto;

public class ProdutoFormulario extends JDialog {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtMarca;

    private JButton btnSalvar;

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private Produto produto;
    private ProdutoCRUD parent;

    public ProdutoFormulario(ProdutoCRUD parent, Produto produto) {
        super(parent, true);
        this.parent = parent;
        this.produto = produto;

        setTitle(produto == null ? "Novo Produto" : "Editar Produto");
        setSize(350, produto == null ? 250 : 220);
        setLayout(new GridLayout(4, 2, 10, 10));
        setLocationRelativeTo(parent);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        add(txtPreco);

        add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        add(txtMarca);

        btnSalvar = new JButton("Salvar");
        add(new JLabel());
        add(btnSalvar);

        if (produto != null) {
            txtNome.setText(produto.getNome());
            txtPreco.setText(String.valueOf(produto.getPreco()));
            txtMarca.setText(produto.getMarca());
        }

        btnSalvar.addActionListener(e -> salvarProduto());
    }

    private void salvarProduto() {
        try {
            String nome = txtNome.getText().trim();
            String precoStr = txtPreco.getText().trim();
            String marca = txtMarca.getText().trim();

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome obrigatório");
                return;
            }
            if (precoStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preço obrigatório");
                return;
            }
            if (marca.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Marca obrigatória");
                return;
            }

            double preco;
            try {
                preco = Double.parseDouble(precoStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preço inválido!");
                return;
            }

            if (produto == null) {
                Produto p = new Produto();
                p.setNome(nome);
                p.setPreco(preco);
                p.setMarca(marca);

                produtoDAO.inserir(p);

            } else {
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setMarca(marca);
                produtoDAO.gravar(produto);
            }

            parent.atualizarTabela();
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + e.getMessage());
        }
    }
}
