package view;

import model.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;

import java.awt.*;
import java.util.List;

public class ClienteCRUD extends JFrame {

    private JTable tabelaClientes;
    private DefaultTableModel model;
    private JButton btnNovo, btnEditar, btnExcluir;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteCRUD() {
        setTitle("Gerenciamento de Clientes");
        setSize(900, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Nome", "Telefone", "Email", "CPF", "Nascimento", "Peso"}, 0
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaClientes = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
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
        btnEditar.addActionListener(e -> editarCliente());
        btnExcluir.addActionListener(e -> excluirCliente());

        carregarClientes();
        setVisible(true);
    }

    private void carregarClientes() {
        model.setRowCount(0);
        List<Cliente> clientes = clienteDAO.listarTodos();

        for (Cliente c : clientes) {
            model.addRow(new Object[]{
                    c.getId(),
                    c.getNome(),
                    c.getTelefone(),
                    c.getEmail(),
                    c.getCpf(),
                    c.getDataNascimento(),
                    c.getPeso()
            });
        }
    }

    private void abrirFormulario(Cliente cliente) {
        ClienteFormulario form = new ClienteFormulario(this, cliente);
        form.setVisible(true);
    }

    private void editarCliente() {
        int linha = tabelaClientes.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            Cliente cliente = clienteDAO.buscarPorId(id);
            abrirFormulario(cliente);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para editar.");
        }
    }

    private void excluirCliente() {
        int linha = tabelaClientes.getSelectedRow();
        if (linha >= 0) {
            int id = (int) model.getValueAt(linha, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este cliente?");
            if (confirm == JOptionPane.YES_OPTION) {
                boolean sucesso = clienteDAO.excluir(id);
                if (sucesso) {
                    carregarClientes();
                    JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir cliente!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para excluir!");
        }
    }

    public void atualizarTabela() {
        carregarClientes();
    }
}