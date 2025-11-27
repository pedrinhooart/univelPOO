package view;

import model.Usuario;
import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {

    private final Usuario usuario;

    public TelaMenu(Usuario usuario) {
        this.usuario = usuario;

        setTitle("Menu Principal - Usuário: " + usuario.getLogin());
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuUsuario = new JMenuItem("Usuários");
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
        menuClientes.addActionListener(e -> new ClienteCRUD().setVisible(true));
        menuProdutos.addActionListener(e -> new ProdutoCRUD().setVisible(true));

        sair.addActionListener(e -> {
            dispose();
            new TelaLogin().setVisible(true);
        });
    }
}
