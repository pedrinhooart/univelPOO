package view;

import javax.swing.*;
import java.awt.*;
import controller.UsuarioController; 

public class TelaLogin extends JFrame {
    
    private final JTextField txtUsuario = new JTextField(15);
    private final JPasswordField txtSenha = new JPasswordField(15);
    private final JButton btnLogin = new JButton("Entrar");

    public TelaLogin() {
        super("Login de Usuário"); 
        
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        painel.add(new JLabel("Usuário:"));
        painel.add(txtUsuario);
        painel.add(new JLabel("Senha:"));
        painel.add(txtSenha);
        painel.add(btnLogin);

        add(painel);

        // Adiciona o listener para o botão de Login, chamando o método realizarLogin
        btnLogin.addActionListener(e -> realizarLogin());
    }

    private void realizarLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());
        
        UsuarioController controller = new UsuarioController();
        
        if (controller.autenticar(usuario, senha)) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); 
            // Em uma aplicação real, aqui você abriria a tela principal.
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
            txtSenha.setText(""); // Limpa o campo de senha após falha
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaLogin().setVisible(true));
    }
}