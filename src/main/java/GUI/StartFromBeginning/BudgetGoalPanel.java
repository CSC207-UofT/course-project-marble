package GUI.StartFromBeginning;

import javax.swing.*;
import java.awt.*;

public class BudgetGoalPanel extends JPanel {

    public BudgetGoalPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;

        JLabel budgetLabel = new JLabel("Budget Goals");
        constraints.gridx = 0;
        constraints.gridy = 0;
        budgetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(budgetLabel, constraints);

        //get the progress amount from model
        JProgressBar goalProgress = new JProgressBar(0, 1); // set max to 1 for now
        constraints.gridy = 1;
        this.add(goalProgress, constraints);

        JLabel progressAmount = new JLabel("0/1"); // for now 0/1 until I can get it from model
        progressAmount.setHorizontalAlignment(SwingConstants.CENTER);
        constraints.gridy = 2;
        this.add(progressAmount, constraints);
    }

    public static void main(String [] args){
        JFrame frame = new JFrame("Budget Goal Test");
        BudgetGoalPanel budgetGoalPanel = new BudgetGoalPanel();

        frame.setSize(new Dimension(300, 300));
        frame.add(budgetGoalPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
