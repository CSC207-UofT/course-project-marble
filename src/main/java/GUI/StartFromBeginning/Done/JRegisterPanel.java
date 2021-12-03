package GUI.StartFromBeginning.Done;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRegisterPanel extends JPanel{
    public JRegisterPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        this.add(userLabel, constraints);

        constraints.gridx = 1;
        JTextField username = new JTextField(16);
        username.setPreferredSize(new Dimension(120,40));
        username.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(username, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        this.add(passLabel, constraints);

        constraints.gridx = 1;
        JTextField pass = new JTextField(16);
        pass.setPreferredSize(new Dimension(120,40));
        pass.setFont(new Font("Serif", Font.PLAIN, 20));
        this.add(pass, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(120, 70));
        constraints.anchor = GridBagConstraints.WEST;
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.add(registerButton,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(120, 70));
        constraints.anchor = GridBagConstraints.EAST;
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame();
            }
        });
        this.add(cancelButton, constraints);
    }

    private void closeFrame() {
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        frame.dispose();
    }
}