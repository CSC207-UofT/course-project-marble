package GUI.StartFromBeginning.Done;

import GUI.GUI_Done.JLoginPanel;
import GUI.GUI_Done.JRegisterPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUpPanel extends JPanel {

    public StartUpPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(100,10,70,10);

        constraints.gridy = 0;
        constraints.gridwidth = 3;
        JLabel welcome = new JLabel("Welcome to Marbles, a financial planning app!");
        welcome.setFont(new Font("Serif", Font.BOLD, 40));
        welcome.setHorizontalAlignment(GridBagConstraints.CENTER);
        this.add(welcome, constraints);

        constraints.gridwidth = 1;

        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLoginPanel loginPanel = new JLoginPanel();
                PopUp pop = new PopUp("Login", loginPanel);
                pop.getFrame().setVisible(true);
            }
        });
        login.setFont(new Font("Serif", Font.BOLD, 30));
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.ipadx = 200;
        this.add(login, constraints);

        JButton register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRegisterPanel regiPanel = new JRegisterPanel();
                PopUp pop = new PopUp("Register", regiPanel);
                pop.getFrame().setVisible(true);
            }
        });
        register.setFont(new Font("Serif", Font.BOLD, 30));
        constraints.gridx = 1;
        this.add(register, constraints);

        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setFont(new Font("Serif", Font.BOLD, 30));
        constraints.gridx = 2;
        this.add(exit, constraints);
    }

    public static void main(String [] args){
        JFrame frame = new JFrame("StartUpTest");
        StartUpPanel startPanel = new StartUpPanel();

        frame.add(startPanel);
        frame.pack();
        frame.setSize(1366,768);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
