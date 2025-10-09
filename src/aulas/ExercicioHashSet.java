import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.*;

public class ExercicioHashSet extends JFrame {
    private JTextField txtNome;
    private JTextArea areaResultado;
    private JButton btnVerificar;
    private HashSet<String> nomes;

    public ExercicioHashSet() {
        setTitle("Exercicio HashSet com Border Layout");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // tipo border layout
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);

        //Conjunto inicial
        nomes = new HashSet<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carlos");
        
        JPanel painelSuperior = new JPanel();
        painelSuperior.add(new JLabel("Digite um nome: "));
        txtNome = new JTextField(15);
        painelSuperior.add(txtNome);

        btnVerificar = new JButton("Verificar nome");

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Conjunto inicial: ").append(nomes).append("\n");
                String nome = txtNome.getText();
                if (nomes.contains(nome)) {
                    sb.append("Resultado").append("Está na lista!");
                } else {
                    sb.append("Resultado").append("Não está na lista!");
                }

                areaResultado.setText(sb.toString());
            }
        });

        add(painelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);
        add(btnVerificar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ExercicioHashSet().setVisible(true);
    }
    
}
