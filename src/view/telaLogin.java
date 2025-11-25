package view;

import javax.swing.*;
import java.awt.*;
import controller.usuarioController; 

public class telaLogin extends JFrame { // Nome de classe deveria ser TelaLogin (convenção Java)
    private final JTextField txtUsuario = new JTextField(15);
    private final JPasswordField txtSenha = new JPasswordField(15);
    private final JButton btnLogin = new JButton("Entrar");

    public telaLogin() {
        setTitle("Login de Usuário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Usa FlowLayout para uma disposição simples
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); 

        add(new JLabel("Usuário:"));
        add(txtUsuario);
        add(new JLabel("Senha:"));
        add(txtSenha);
        add(btnLogin);

        // Adiciona o listener para o botão de Login
        btnLogin.addActionListener(e -> realizarLogin());
    }

    private void realizarLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());
        
        // Instancia e chama o Controller para a lógica de negócio (autenticação)
        usuarioController controller = new usuarioController();
        
        if (controller.autenticar(usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            // Fecha a tela de login
            this.dispose(); 
            // Em uma aplicação completa, abriria o menu principal aqui (e.g., new MenuPrincipal().setVisible(true))
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            txtSenha.setText(""); // Limpa o campo de senha após falha
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new telaLogin().setVisible(true));
    }
}