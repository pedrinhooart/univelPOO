package view;

import controller.ProdutoController;
import java.awt.*;
import javax.swing.*;
import util.Mensagem;
import util.ResultadoCadastro;

public class TelaCadastroProduto extends JFrame {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtMarca;
    private JButton btnSalvar;

    private final ProdutoController controller = new ProdutoController();

    public TelaCadastroProduto() {
        setTitle("Cadastrar Produto");
        setSize(300, 240);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Novo Produto:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        add(txtPreco);

        add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        add(txtMarca);

        btnSalvar = new JButton("Salvar");
        add(new JLabel());
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String marca = txtMarca.getText();
            Double preco = Double.parseDouble(txtPreco.getText());

            ResultadoCadastro resultado = controller.cadastrar(nome, preco, marca);

            switch (resultado) {
                case SUCESSO -> {
                    Mensagem.info("Produto cadastrado com sucesso!");
                    dispose();
                }
                case USUARIO_EXISTE -> Mensagem.erro("Já existe um produto com esse nome!");
                case ERRO_BANCO -> Mensagem.erro("Erro ao salvar no banco de dados.");
            }
        });
    }
}
