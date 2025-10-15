package aulas;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class JanelaOi {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Janela com Botão");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); // Permite posicionar manualmente com setBounds

        JLabel lblNome = new JLabel("Digite seu nome: ");
        lblNome.setBounds(20, 20, 150, 25);
        frame.add(lblNome);

        JTextField txtNome = new JTextField();
        txtNome.setBounds(160, 20, 200, 25);
        frame.add(txtNome);

        JRadioButton rbtnMasculino = new JRadioButton("Masculino");
        rbtnMasculino.setBounds(20, 60, 100, 25);

        JRadioButton rbtnFeminino = new JRadioButton("Feminino");
        rbtnFeminino.setBounds(120, 60, 100, 25);

        ButtonGroup grupoSexo = new ButtonGroup();
        grupoSexo.add(rbtnMasculino);
        grupoSexo.add(rbtnFeminino);

        frame.add(rbtnFeminino);
        frame.add(rbtnMasculino);
        
        JCheckBox chkProgramador = new JCheckBox("Programador");
        chkProgramador.setBounds(20, 100, 120, 25);
        JCheckBox chkProfessor = new JCheckBox("Professor");
        chkProfessor.setBounds(150, 100, 120, 25);
        frame.add(chkProgramador);
        frame.add(chkProfessor);

        String[] cores = { "Vermelho", "Verde", "Azul", "Amarelo" };
        JComboBox<String> combo = new JComboBox<>(cores);
        combo.setBounds(20, 140, 120, 25);
        frame.add(combo);

        String[] frutas = { "Maçã", "Banana", "Laranja"};
        JList<String> lista = new JList<>(frutas);
        lista.setBounds(160, 140, 120, 60);
        frame.add(lista);

        JSlider slider = new JSlider(0, 100, 50);
        slider.setBounds(20, 200, 200, 50);
        frame.add(slider);

        ImageIcon icon = new ImageIcon("C:\\Users\\pedro\\Documents\\Pedro ART\\resources\\imagens\\pasta.png");
        JLabel lblIcone = new JLabel(icon);
        lblIcone.setBounds(20, 180, 200, 150);
        frame.add(lblIcone);


        JButton botao = new JButton("Clique Aqui");
        botao.setBounds(140, 120, 120, 30);
        frame.add(botao);

        botao.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Oi!"));

        frame.setVisible(true);
    }
}