package GUI.StartFromBeginning.Done;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateBondPanel extends JPanel {

    public CreateBondPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10,10,10,10);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JLabel name = new JLabel("Name: ");
        this.add(name, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField nameInput = new JTextField(20);
        this.add(nameInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel interestRate = new JLabel("Interest Rate: ");
        this.add(interestRate, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField interestRateInput = new JTextField(20);
        this.add(interestRateInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        JLabel price = new JLabel("Price: ");
        this.add(price, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField priceInput = new JTextField(20);
        this.add(priceInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 3;
        JLabel volume = new JLabel("Volume: ");
        this.add(volume, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField volumeInput = new JTextField(20);
        this.add(volumeInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 4;
        JLabel date = new JLabel("Date: ");
        this.add(date, constraints);

        constraints.gridwidth = 2;
        constraints.gridx = 1;
        JTextField dateInput = new JTextField(20);
        this.add(dateInput, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 1;
        constraints.gridy = 5;
        JButton createBondButton = new JButton("Create Bond");
        createBondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //create bond command
            }
        });
        this.add(createBondButton, constraints);

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
        JFrame frame = new JFrame("Create Bond Panel Test");
        CreateBondPanel createBondPanel = new CreateBondPanel();

        frame.setSize(new Dimension(400, 300));
        frame.add(createBondPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
