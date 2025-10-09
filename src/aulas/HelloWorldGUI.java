

import javax.swing.*;
public class HelloWorldGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World GUI");
        JButton button = new JButton("Clique Me");
        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}