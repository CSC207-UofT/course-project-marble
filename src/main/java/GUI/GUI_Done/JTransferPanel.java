package GUI.GUI_Done;

import javax.swing.*;
import java.awt.*;

public class JTransferPanel extends JPanel{

    public JTransferPanel() {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel recipientIdLabel = new JLabel("Recipient ID");
        this.add(recipientIdLabel, constraints);

        constraints.gridx = 1;
        JTextField recipientId = new JTextField(20);
        this.add(recipientId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel fromAccLabel = new JLabel("From Account");
        this.add(fromAccLabel, constraints);

        constraints.gridx = 1;
        JPasswordField pass = new JPasswordField(20); //change to drop down menu with account options
        this.add(pass, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel amountLabel = new JLabel("Amount");
        this.add(amountLabel, constraints);

        constraints.gridx = 1;
        JTextField amount = new JTextField(20);
        this.add(amount, constraints);


        constraints.gridy = 3;
        constraints.gridwidth = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Transfer");
        this.add(loginButton, constraints);

    }

    public static void main(String [] args){
        JFrame frame = new JFrame("Transfer Window Test");
        JTransferPanel JTP = new JTransferPanel();

        frame.add(JTP);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}