package GUI.GUI_Done;

import javax.swing.*;

public class JLoginFrame extends JFrame {
    public JLoginFrame(){
        super("Login Window");
        JLoginPanel loginPanel = new JLoginPanel();

        this.add(loginPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String [] args){
        JLoginFrame frame = new JLoginFrame();
    }
}
