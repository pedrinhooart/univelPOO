package dao;

import java.sql.Connection;

public class TestaConexao {
    public void executar() {
        System.out.println("Iniciando teste com MySQL...");
        Connection conexao = Conexao.getConexao();
        Conexao.fecharConexao(conexao);
    }

    public static void main(String[] args) {
        new TestaConexao().executar();
    }
}
