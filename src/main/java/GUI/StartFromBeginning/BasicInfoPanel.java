package GUI.StartFromBeginning;

import javax.swing.*;
import java.awt.*;

public class BasicInfoPanel extends JPanel {
    public BasicInfoPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(10,10,10,10);
        //SET JFRAME'S NAME TO USER PROFILE OR SOME TAB NAME

        JLabel nameUser = new JLabel("NAME / [USERNAME]");
        constraints.gridwidth = 3;
        constraints.gridy = 1;
        constraints.gridx = 1;
        nameUser.setHorizontalAlignment(GridBagConstraints.CENTER);
        this.add(nameUser, constraints);

        JLabel bal = new JLabel("Balance: ");
        constraints.gridx = 0;
        constraints.gridy = 2;
        this.add(bal, constraints);

        JLabel balance = new JLabel("1000");
        constraints.gridx = 3;
        this.add(balance, constraints);



    }

    public static void main(String [] args){
        JFrame frame = new JFrame("User Profile");
        BasicInfoPanel bPanel = new BasicInfoPanel();

        frame.add(bPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
