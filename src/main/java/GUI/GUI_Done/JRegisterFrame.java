package GUI.GUI_Done;

import javax.swing.*;

public class JRegisterFrame extends JFrame {
    public JRegisterFrame(){
        super("Register Window");
        JRegisterPanel registerPanel = new JRegisterPanel();

        this.add(registerPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String [] args){
        JRegisterFrame frame = new JRegisterFrame();
    }
}