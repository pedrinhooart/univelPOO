package view;

import dao.UsuarioDAO;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import javax.swing.*;
import model.Usuario;

public class UsuarioFormulario extends JDialog {
    private JTextField txtNome;
    private JPasswordField txtSenha;
    private JComboBox<String> cbTipo, cbAtivo;
    private JButton btnSalvar;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario;
    private UsuarioCRUD parent;

    public UsuarioFormulario(UsuarioCRUD parent, Usuario usuario) {
        super(parent, true);
        this.parent = parent;
        this.usuario = usuario;

        setTitle(usuario == null ? "Novo Usuário" : "Editar Usuário");
        setSize(350, usuario == null ? 300 : 250);
        setLayout(new GridLayout(usuario == null ? 6 : 5, 2, 10, 10));
        setLocationRelativeTo(parent);

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Administrador", "Usuario"});
        add(cbTipo);

        add(new JLabel("Ativo:"));
        cbAtivo = new JComboBox<>(new String[]{"Ativo", "Inativo"});
        add(cbAtivo);

        btnSalvar = new JButton("Salvar");
        add(new JLabel());
        add(btnSalvar);

        if (usuario != null) {
            txtNome.setText(usuario.getLogin());
            cbTipo.setSelectedItem(usuario.getTipo().equals("A") ? "Administrador" : "Usuario");
            cbAtivo.setSelectedItem(usuario.getAtivo().equals("T") ? "Ativo" : "Inativo");
            txtSenha.setText("");
        }

        btnSalvar.addActionListener(e -> salvarUsuario());
    }

    private void salvarUsuario() {
        try {
            String nome = txtNome.getText().trim();

            String tipoSelecionado = (String) cbTipo.getSelectedItem();
            String ativoSelecionado = (String) cbAtivo.getSelectedItem();

            String tipo = tipoSelecionado.equalsIgnoreCase("Administrador") ? "A" : "U";
            String ativo = ativoSelecionado.equalsIgnoreCase("Ativo") ? "T" : "F";

            if (nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome obrigatório");
                return;
            }
            if (usuario == null) {
                String senha = new String(txtSenha.getPassword()).trim();
                if (senha.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Senha obrigatória");
                    return;
                }
                String senhaHash = gerarHashSHA256(senha);

                Usuario u = new Usuario();
                u.setLogin(nome);
                u.setSenha(senhaHash);
                u.setTipo(tipo);
                u.setAtivo(ativo);

                usuarioDAO.inserir(u);

            } else {
                usuario.setLogin(nome);
                usuario.setTipo(tipo);
                usuario.setAtivo(ativo);
                usuarioDAO.gravar(usuario);
            }
            parent.atualizarTabela();
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar usuário: " + e.getMessage());
        }
    }

    private String gerarHashSHA256(String senha) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(senha.getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}