import view.TelaLogin; // Importa a tela de login corrigida (PascalCase)
// import aulas.MenuPrincipal; // Removido para não executar o MenuPrincipal

public class Main {
    public static void main(String[] args) {
        // Ponto de entrada principal da aplicação.
        // Inicia o fluxo de login, que é a primeira tela da aplicação fora da pasta 'aulas'.
        // Isso garante que a aplicação execute a lógica de Controller/DAO/View.
        TelaLogin.main(args);
    }
}