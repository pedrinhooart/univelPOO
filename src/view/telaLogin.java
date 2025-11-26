package view;

import controller.UsuarioController;
import java.awt.*;
import javax.swing.*;
import model.Usuario;
import util.Mensagem;

public class TelaLogin extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btnEntrar, btnCadastrar;

    private final UsuarioController controller = new UsuarioController();

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Usuário:"));
        txtLogin = new JTextField();
        add(txtLogin);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Cadastrar");

        add(btnEntrar);
        add(btnCadastrar);

        btnEntrar.addActionListener(e -> {
            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());

            if (controller.login(login, senha)) {
                Mensagem.info("Login realizado com sucesso!");

                Usuario usuario = new Usuario();
                usuario.setLogin(login);

                dispose();
                new TelaMenu(usuario).setVisible(true);
            } else {
                Mensagem.erro("Usuário ou senha inválidos!");
            }
        });

        btnCadastrar.addActionListener(e -> {
            TelaCadastroUsuario telaCadastro = new TelaCadastroUsuario();
            telaCadastro.setVisible(true);
        });
    }
}
