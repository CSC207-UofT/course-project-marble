package GUI.StartFromBeginning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBalPanel extends JPanel {
    public ChangeBalPanel() {
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel name = new JLabel("Name: ");
        this.add(name, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField nameInput = new JTextField(27);
        this.add(nameInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel amount = new JLabel("Amount(- / +): ");
        this.add(amount, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField amountInput = new JTextField(27);
        this.add(amountInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton changeSavingsBalButton = new JButton("Change Savings Balance");
        changeSavingsBalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change Savings Bal command
            }
        });
        this.add(changeSavingsBalButton, constraints);

        constraints.gridx = 2;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeFrame();
            }
        });
        this.add(cancelButton, constraints);
    }

    private void closeFrame() { //should I make interface with closeframeable?
        JFrame frame = (JFrame) SwingUtilities.getRoot(this);
        frame.dispose();
    }

    public static void main(String [] args){
        JFrame frame = new JFrame("Change Savings Panel Test");
        ChangeBalPanel changeBalPanel = new ChangeBalPanel();

        frame.setSize(new Dimension(420, 300));
        frame.add(changeBalPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
