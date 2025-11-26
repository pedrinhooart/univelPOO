import view.TelaLogin; // Importa a tela de login corrigida (PascalCase)

// A classe 'aulas.MenuPrincipal' foi removida para que o Main não dependa da pasta 'aulas'.

public class Main {
    public static void main(String[] args) {
        // Ponto de entrada principal da aplicação.
        // Inicia a Tela de Login, garantindo que o fluxo comece pela camada View/Controller/DAO,
        // fora da pasta 'aulas'.
        TelaLogin.main(args);
    }
}