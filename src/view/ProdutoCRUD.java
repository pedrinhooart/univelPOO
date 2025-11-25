package view;

import model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.ProdutoDAO;

import java.awt.*;
import java.util.List;

public class ProdutoCRUD extends JFrame {

    private JTable tabelaProdutos;
    private DefaultTableModel model;
    private JButton btnNovo, btnEditar, btnExcluir;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public ProdutoCRUD() {
        setTitle("Gerenciamento de Produtos");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Preço", "Marca"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaProdutos = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        add(scrollPane, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        btnNovo = new JButton("Novo");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");

        painelBotoes.add(btnNovo);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        add(painelBotoes, BorderLayout.SOUTH);

        btnNovo.addActionListener(e -> abrirFormulario(null));
        btnEditar.addActionListener(e -> editarProduto());
        btnExcluir.addActionListener(e -> excluirProduto());

        carregarProdutos();
        setVisible(true);
    }

    private void carregarProdutos() {
        model.setRowCount(0);
        List<Produto> produtos = produtoDAO.listarTodos();

        for (Produto p : produtos) {
            model.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getPreco(),
                    p.getMarca()
            });
        }
    }

    private void abrirFormulario(Produto produto) {
        ProdutoFormulario form = new ProdutoFormulario(this, produto);
        form.setVisible(true);
    }

    private void editarProduto() {
        int linha = tabelaProdutos.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            Produto produto = produtoDAO.buscarPorId(id);
            abrirFormulario(produto);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
        }
    }

    private void excluirProduto() {
        int linha = tabelaProdutos.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este produto?");
            if (confirm == JOptionPane.YES_OPTION) {
                boolean sucesso = produtoDAO.excluir(id);
                if (sucesso) {
                    carregarProdutos();
                    JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir produto!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir!");
        }
    }

    public void atualizarTabela() {
        carregarProdutos();
    }
} 
