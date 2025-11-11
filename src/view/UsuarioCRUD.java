
package view;

import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.UsuarioDAO;

import java.awt.*;
import java.util.List;

public class UsuarioCRUD extends JFrame {
    private JTable tabelaUsuarios;
    private DefaultTableModel model;
    private JButton btnNovo, btnEditar, btnExcluir;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public UsuarioCRUD() {
        setTitle("Gerenciamento de Músicas");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Nome", "Tipo", "Situação", "Data Criação"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabelaUsuarios = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabelaUsuarios);
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
        btnEditar.addActionListener(e -> editarUsuario());
        btnExcluir.addActionListener(e -> excluirUsuario());

        carregarUsuarios();
        setVisible(true);
}

    private void carregarUsuarios() {
        model.setRowCount(0);
        List<Usuario> usuarios = usuarioDAO.listarTodos();
        for (Usuario u : usuarios) {
            String tipoLegivel = u.getTipo().equals("A") ? "Administrador" : "Usuário";
            String ativoLegivel = u.getAtivo().equals("T") ? "Ativo" : "Inativo";

        model.addRow(new Object[]{u.getId(), u.getLogin(), tipoLegivel, ativoLegivel, u.getDataCriacao()
        });
    }
  }

  private void abrirFormulario(Usuario usuario) {
    UsuarioFormulario form = new UsuarioFormulario(this, usuario);
    form.setVisible(true);
}

private void editarUsuario() {
    int linha = tabelaUsuarios.getSelectedRow();
    if (linha >= 0) {
        int id = (int) model.getValueAt(linha, 0);
        Usuario usuario = usuarioDAO.buscarPorId(id);
        abrirFormulario(usuario);
    } else {
        JOptionPane.showMessageDialog(this, "Selecione um usuário para editar.");
    }
  }
}

