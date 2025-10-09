package aulas;

import javax.swing.*;
import java.io.*;

public class ExemplosArquivos {
    public static void main(String[] args) throws IOException {
        try {
            String valor = JOptionPane.showInputDialog("digite um numero ");
            int numero = Integer.parseInt(valor);

            int resultado = 10 / numero;

            JOptionPane.showMessageDialog(null, "resultado: " + resultado);

            FileReader fr = new FileReader("arquivo.txt");
            fr.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite apenas numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Não é possivel dividir por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "erro: arquivo nao encontrado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "erro na leitura do arquivo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro inesperado: " + e.getMessage());
        }
    }
}
