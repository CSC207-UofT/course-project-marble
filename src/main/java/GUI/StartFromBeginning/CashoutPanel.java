package GUI.StartFromBeginning;

import GUI.StartFromBeginning.Done.BasicInfoPanel;

import javax.swing.*;
import java.awt.*;

public class CashoutPanel extends JPanel {

    public CashoutPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(10,10,10,10);
        JLabel cashout = new JLabel("Cashout 1 of the following bonds");
        constraints.gridwidth = 3;
        constraints.gridx = 0;
        constraints.gridy = 0;
        cashout.setHorizontalAlignment(GridBagConstraints.CENTER);
        this.add(cashout, constraints);



    }

    public static void main(String [] args){
        JFrame frame = new JFrame("User Profile");
        CashoutPanel cashoutPanel = new CashoutPanel();

        frame.add(cashoutPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
