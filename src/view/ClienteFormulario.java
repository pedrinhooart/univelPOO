package view;

import model.Cliente;
import javax.swing.*;
import dao.ClienteDAO;
import java.awt.*;
import java.time.LocalDate;

public class ClienteFormulario extends JDialog {

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEmail;
    private JTextField txtCpf;
    private JTextField txtNascimento;
    private JTextField txtPeso;

    private JButton btnSalvar;

    private ClienteDAO clienteDAO = new ClienteDAO();
    private Cliente cliente;
    private ClienteCRUD parent;

    public ClienteFormulario(ClienteCRUD parent, Cliente cliente) {
        super(parent, true);
        this.parent = parent;
        this.cliente = cliente;

        setTitle(cliente == null ? "Novo Cliente" : "Editar Cliente");
        setSize(400, 350);
        setLayout(new GridLayout(7, 2, 10, 10));
        setLocationRelativeTo(parent);

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

        if (cliente != null) {
            txtNome.setText(cliente.getNome());
            txtTelefone.setText(cliente.getTelefone());
            txtEmail.setText(cliente.getEmail());
            txtCpf.setText(cliente.getCpf());
            txtNascimento.setText(String.valueOf(cliente.getDataNascimento()));
            txtPeso.setText(String.valueOf(cliente.getPeso()));
        }

        btnSalvar.addActionListener(e -> salvarCliente());
    }

    private void salvarCliente() {
        try {
            String nome = txtNome.getText().trim();
            String telefone = txtTelefone.getText().trim();
            String email = txtEmail.getText().trim();
            String cpf = txtCpf.getText().trim();
            LocalDate nascimento = LocalDate.parse(txtNascimento.getText().trim());
            double peso = Double.parseDouble(txtPeso.getText().trim());

            if (cliente == null) {
                Cliente c = new Cliente();
                c.setNome(nome);
                c.setTelefone(telefone);
                c.setEmail(email);
                c.setCpf(cpf);
                c.setDataNascimento(nascimento);
                c.setPeso(peso);

                clienteDAO.inserir(c);

            } else {
                cliente.setNome(nome);
                cliente.setTelefone(telefone);
                cliente.setEmail(email);
                cliente.setCpf(cpf);
                cliente.setDataNascimento(nascimento);
                cliente.setPeso(peso);

                clienteDAO.gravar(cliente);
            }

            parent.atualizarTabela();
            dispose();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar cliente: " + e.getMessage());
        }
    }
}