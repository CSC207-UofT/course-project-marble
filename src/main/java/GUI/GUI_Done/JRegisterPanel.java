package GUI.GUI_Done;

import javax.swing.*;
import java.awt.*;

public class JRegisterPanel extends JPanel{
    public JRegisterPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel userLabel = new JLabel("Username");
        this.add(userLabel, constraints);

        constraints.gridx = 1;
        JTextField username = new JTextField(20);
        this.add(username, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel passLabel = new JLabel("Password");
        this.add(passLabel, constraints);

        constraints.gridx = 1;
        JTextField pass = new JTextField(20);
        this.add(pass, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton registerButton = new JButton("Register");
        constraints.anchor = GridBagConstraints.WEST;
        this.add(registerButton,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton cancelButton = new JButton("Cancel");
        constraints.anchor = GridBagConstraints.EAST;
        this.add(cancelButton, constraints);
    }
}