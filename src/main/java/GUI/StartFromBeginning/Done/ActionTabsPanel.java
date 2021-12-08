package GUI.StartFromBeginning.Done;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionTabsPanel extends JPanel {

    public ActionTabsPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JButton viewInvestments = new JButton("View \n Investments");
        constraints.gridx = 0;
        constraints.gridy = 0;

        viewInvestments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(viewInvestments, constraints);

        JButton cashout = new JButton("Cashout");
        constraints.gridy = 1;

        cashout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(cashout, constraints);

        JButton withdrawRec = new JButton("Withdrawal \n Records");
        constraints.gridy = 2;

        withdrawRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(withdrawRec, constraints);

        JButton depositRec = new JButton("Deposit \n Records");
        constraints.gridy = 3;

        depositRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(depositRec, constraints);

        JButton viewAcc = new JButton("View \n User \n Details");
        constraints.gridy = 4;

        viewAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(viewAcc, constraints);

    }

    public static void main(String [] args){
        JFrame frame = new JFrame("Actions Tabs Test");
        ActionTabsPanel atPanel = new ActionTabsPanel();

        frame.setSize(new Dimension(300, 300));
        frame.add(atPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
