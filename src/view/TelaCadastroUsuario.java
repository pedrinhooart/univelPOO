package view;

import controller.UsuarioController;
import java.awt.*;
import javax.swing.*;
import util.Mensagem;
import util.ResultadoCadastro;

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

        add(new JLabel("Novo Usuário:"));
        txtLogin = new JTextField();
        add(txtLogin);

        add(new JLabel("Senha:"));
        txtSenha = new JPasswordField();
        add(txtSenha);

        btnSalvar = new JButton("Salvar");
        add(new JLabel()); 
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String login = txtLogin.getText();
            String senha = new String(txtSenha.getPassword());
            ResultadoCadastro resultado = controller.cadastrar(login, senha);

          switch (resultado) {
              case SUCESSO:
                  Mensagem.info("Usuário cadastrado com sucesso!");
                  dispose();
                  break; // <-- Adicionado
                  
              case USUARIO_EXISTE:
                  Mensagem.erro("Já existe um usuário com esse nome. Escolha outro!");
                  break; // <-- Adicionado
                  
              case ERRO_BANCO:
                  Mensagem.erro("Erro ao salvar no banco de dados.");
                  break; // <-- Adicionado
          }
        });
    }
}
