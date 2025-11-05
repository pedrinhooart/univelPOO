package view;

import model.Usuario;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TelaMenu extends JFrame{
    
    private final Usuario usuario;

    public TelaMenu(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Menu Principal - Usuario: " + usuario.getLogin());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuUsuario = new JMenuItem("Usuarios");
        JMenuItem menuClientes = new JMenuItem("Clientes");
        JMenuItem menuProdutos = new JMenuItem("Produtos");
        menuCadastro.add(menuUsuario);
        menuCadastro.add(menuClientes);
        menuCadastro.add(menuProdutos);

        JMenu menuSair = new JMenu("Sair");
        JMenuItem sair = new JMenuItem("Logout");
        menuSair.add(sair);

        menuBar.add(menuCadastro);
        menuBar.add(menuSair);
        setJMenuBar(menuBar);

        JLabel lblSaudacao = new JLabel("Bem-vindo, " + usuario.getLogin() + "!");
        lblSaudacao.setFont(new Font("Arial", Font.BOLD, 16));
        lblSaudacao.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblSaudacao, BorderLayout.CENTER);

        menuUsuario.addActionListener(e -> new UsuarioCRUD().setVisible(true));
        menuUsuario.addActionListener(e -> new TelaCadastroUsuario().setVisible(true));
        menuUsuario.addActionListener(e -> new TelaCadastroUsuario().setVisible(true));

        sair.addActionListener(e -> {
            
        });
    }
}
