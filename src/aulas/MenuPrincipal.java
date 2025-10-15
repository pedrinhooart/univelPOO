package aulas;

import javax.swing.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuProgramas = new JMenu("Programas");

        addMenuItem(menuProgramas, "Aula 1 - Hello World", "aulas.HelloWorldGUI");
        addMenuItem(menuProgramas, "Aula 2 - Saudação", "aulas.SaudacaoGUI");
        addMenuItem(menuProgramas, "Aula 3 - While Try Calendar", "aulas.WhileTryCalendarGUI");
        addMenuItem(menuProgramas, "Aula 4 - Repetir Nome", "aulas.RepetirNomeGUI");
        addMenuItem(menuProgramas, "Aula 5 - Tratamento Excessoes", "aulas.TratamentoExcessoes");
        addMenuItem(menuProgramas, "Aula 5 - ExemplosArquivos", "aulas.ExemplosArquivos");
        addMenuItem(menuProgramas, "Aula 6 - Exessao Idade Invalida", "aulas.ExessaoIdadeInvalida");
        addMenuItem(menuProgramas, "Aula 6 - Exercicio ArrayList", "aulas.ExercicioArrayList");
        addMenuItem(menuProgramas, "Aula 7 - JanelaO", "aulas.JanelaO");
        addMenuItem(menuProgramas, "Aula 7 - Média Aluno", "aulas.Pedro");


        menuBar.add(menuProgramas);
        setJMenuBar(menuBar);
    }

    private void addMenuItem(JMenu menu, String nome, String nomeClasse) {
        JMenuItem item = new JMenuItem(nome);
        item.addActionListener(e -> {
            try {
                Class<?> clazz = Class.forName(nomeClasse);
                Object instancia = clazz.getDeclaredConstructor().newInstance();

                if (instancia instanceof JFrame) {
                    ((JFrame) instancia).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "A classe " + nomeClasse + " não é um JFrame.\nTem como chamar, mas ficaria um arquivo muito grande.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this,
                        "O programa não foi encontrado:\n" + nomeClasse,
                        "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Erro ao abrir o programa:\n" + ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });
        menu.add(item);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}

// teset