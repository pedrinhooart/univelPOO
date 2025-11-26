package model;

public class Produto {
    
    private int id;
    private String nome;
    private double preco;
    private String marca;

    // Getter e Setter ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter preco
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Getter e Setter marca
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
