package GUI.GUI_Done;
import javax.accessibility.Accessible;
import javax.swing.*;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import java.awt.*;

public class JLoginPanel extends JPanel{

    public JLoginPanel(){
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
        JPasswordField pass = new JPasswordField(20);
        this.add(pass, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton loginButton = new JButton("Login");
        constraints.anchor = GridBagConstraints.WEST;
        this.add(loginButton,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton cancelButton = new JButton("Cancel");
        constraints.anchor = GridBagConstraints.EAST;
        this.add(cancelButton, constraints);
    }
}