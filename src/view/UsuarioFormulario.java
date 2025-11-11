package view;

import model.Usuario;

import javax.swing.*;
import dao.UsuarioDAO;
import java.awt.*;
import java.security.MessageDigest;

public class UsuarioFormulario extends JDialog {
    private JTextField txtNome;
    private JPasswordField txtSenha;
    private JComboBox<String> cbTipo, cbAtivo;
    private JButton btnSalvar;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario;
    private UsuarioCRUD parent;

    public UsuarioFormulario(UsuarioCRUD parent, Usuario usuario) {
        super(parent,  true);
        this.parent = parent;
        this.usuario = usuario;

        setTitle(usuario == null ? "Novo Usuário" : "Editar Usuário");
        setSize(350, usuario == null ? 300:250);
        setLayout(new GridLayout(usuario == null ? 6 : 5, 2, 10, 10));
        setLocationRelativeTo(parent);

        add(new JLabel("nome:"));
        txtNome = new JTextField();
        add(txtNome);

        if (usuario == null) {
            add(new JLabel("Senha:"));
            txtSenha = new JPasswordField();
            add(txtSenha);
        }

        add(new JLabel("Tipo"));
        cbTipo = new JComboBox<>(new String[]{"Usuario","Administrador" });
        add(cbTipo);

        add(new JLabel("Ativo"));
        cbAtivo = new JComboBox<>(new String[]{"Ativo","Inativo"});
        add(cbAtivo);

        btnSalvar = new JButton("Salvar");
        add(new JLabel());
        add(btnSalvar);


        if (usuario != null) {
            txtNome.setText(usuario.getLogin());
            cbTipo.setSelectedItem(usuario.getTipo().equals( "A") ? "Administrador" : "Usuario");
            cbAtivo.setSelectedItem(usuario.getAtivo().equals( "T") ? "Ativo" : "Inativo");
        }

        btnSalvar.addActionListener(e -> salvarUsuario());
    }

    private void salvarUsuario() {
        try{
            String nome = txtNome.getText().trim();

            String tipoSelecionado = (String) cbTipo.getSelectedItem();
            String ativoSelecionado = (String) cbAtivo.getSelectedItem();

            String tipo = tipoSelecionado.equalsIgnoreCase("Administrador") ? "A" : "U";
            String ativo = ativoSelecionado.equalsIgnoreCase("Ativo") ? "T" : "F";

            if(nome.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome obrigatório!");
                return;

            }

            if (usuario == null) {
                String senha = new String(txtSenha.getPassword()).trim();
                if (senha.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Senha obrigatoria!");
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
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar usuario!");
        }
    }

    private String gerarHashSHA256(String senha) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(senha.getBytes("UTF-8"));


        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();

    }
}
