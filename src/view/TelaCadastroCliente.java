package view;

import controller.ClienteController;
import util.Mensagem;
import util.ResultadoCadastro;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class TelaCadastroCliente extends JFrame {

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtCpf;
    private JTextField txtNascimento;
    private JTextField txtPeso;

    private JButton btnSalvar;

    private final ClienteController controller = new ClienteController();

    public TelaCadastroCliente() {
        setTitle("Cadastrar Cliente");
        setSize(350, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        add(txtTelefone);

        add(new JLabel("Email:"));
        txtEmail = new JTextField();
        add(txtEmail);

        add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        add(txtCpf);

        add(new JLabel("Nascimento (AAAA-MM-DD):"));
        txtNascimento = new JTextField();
        add(txtNascimento);

        add(new JLabel("Peso (kg):"));
        txtPeso = new JTextField();
        add(txtPeso);

        btnSalvar = new JButton("Salvar");
        add(new JLabel());
        add(btnSalvar);

        btnSalvar.addActionListener(e -> salvar());
    }

    private void salvar() {
        try {
            String nome = txtNome.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String email = txtEmail.getText().trim();
            String cpf = txtCpf.getText().trim();
            LocalDate nascimento = LocalDate.parse(txtNascimento.getText().trim());
            double peso = Double.parseDouble(txtPeso.getText().trim());

            ResultadoCadastro resultado =
                    controller.cadastrar(nome, telefone, email, cpf, nascimento, peso);

            switch (resultado) {
                case SUCESSO -> {
                    Mensagem.info("Cliente cadastrado com sucesso!");
                    dispose();
                }
                case USUARIO_EXISTE -> Mensagem.erro("Já existe um cliente com esse nome!");
                case ERRO_BANCO -> Mensagem.erro("Erro ao salvar no banco de dados.");
            }

        } catch (Exception ex) {
            Mensagem.erro("Erro: " + ex.getMessage());
        }
    }
}