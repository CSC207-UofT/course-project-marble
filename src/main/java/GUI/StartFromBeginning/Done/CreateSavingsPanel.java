package GUI.StartFromBeginning.Done;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateSavingsPanel extends JPanel{
    public CreateSavingsPanel() {
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
        JTextField nameInput = new JTextField(21);
        this.add(nameInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel interestRate = new JLabel("Interest Rate: ");
        this.add(interestRate, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField interestRateInput = new JTextField(21);
        this.add(interestRateInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 1;
        constraints.gridy = 2;
        JButton createSavingsButton = new JButton("Create Savings");
        createSavingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create savings command
            }
        });
        this.add(createSavingsButton, constraints);

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
        JFrame frame = new JFrame("Create Savings Panel Test");
        CreateSavingsPanel createSavingsPanel = new CreateSavingsPanel();

        frame.setSize(new Dimension(400, 300));
        frame.add(createSavingsPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
