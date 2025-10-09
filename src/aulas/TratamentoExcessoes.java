package aulas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TratamentoExcessoes extends JFrame {
    private JTextField txtNumero;
    private JButton btnCalcular, btnForcarNull;
    
    public TratamentoExcessoes() {
        setTitle("Tratamento de Exceções");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        txtNumero = new JTextField(10);
        btnCalcular = new JButton("Calcular Quadrado");
        btnForcarNull = new JButton("Limpar campo numero");

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(txtNumero.getText());
                    JOptionPane.showMessageDialog(null, "Quadrado:" + (n * n));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Digite apenas numeros!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, "Não é possivel dividir por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Informação obrigatória", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(null, "Indice invalido, digite entre 0 e 15", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (OutOfMemoryError ex) {
                    JOptionPane.showMessageDialog(null, "Memória insuficiente!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro Desconhecido:\n " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnForcarNull.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNumero = null;
            }
        });

        add(new JLabel("Digite um número:"));
        add(txtNumero);
        add(btnCalcular);
        add(btnForcarNull);
    }

    public static void main(String[] args) {
        new TratamentoExcessoes().setVisible(true);
    }
}

