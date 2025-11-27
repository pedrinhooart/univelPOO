package controller;

import dao.ClienteDAO;
import model.Cliente;
import util.ResultadoCadastro;

import java.time.LocalDate;

public class ClienteController {

    private final ClienteDAO cDAO = new ClienteDAO();

    public ResultadoCadastro cadastrar(
            String nome,
            String telefone,
            String email,
            String cpf,
            LocalDate dataNascimento,
            double peso
    ) {
        Cliente c = new Cliente();

        c.setNome(nome);
        c.setTelefone(telefone);
        c.setEmail(email);
        c.setCpf(cpf);
        c.setDataNascimento(dataNascimento);
        c.setPeso(peso);

        return cDAO.inserir(c);
    }
}