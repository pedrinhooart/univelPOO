package controller;
import dao.ProdutoDAO;
import model.Produto;
import util.ResultadoCadastro;


public class ProdutoController {
    
    private final ProdutoDAO pDAO = new ProdutoDAO();

    public ResultadoCadastro cadastrar(String nome, double preco, String marca) {
        Produto p = new Produto();
        p.setNome(nome);
        p.setPreco(preco);
        p.setMarca(marca);
        return pDAO.inserir(p);
    }
}
