package view;

import controller.UsuarioController;
import util.Mensagem;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroUsuario extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnSalvar;

    private final UsuarioController controller = new UsuarioController();

    public TelaCadastroUsuario() {
        setTitle("Cadastrar Usuário");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Novo Usuário:"));
        txtLogin = new JTextField();
        add(txtLogin);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        btnSalvar = new JButton("Salvar");
        add(new JLabel()); // espaço vazio
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String login = txtLogin.getText().trim();
            String senha = new String(txtSenha.getPassword()).trim();

            if (login.isEmpty() || senha.isEmpty()) {
                Mensagem.erro("Preencha todos os campos.");
                return;
            }

            boolean sucesso = controller.cadastrar(login, senha);

            if (sucesso) {
                Mensagem.info("Usuário cadastrado com sucesso!");
                dispose();
            } else {
                Mensagem.erro("Erro ao salvar no banco de dados ou usuário já existe.");
            }
        });
    }
}
