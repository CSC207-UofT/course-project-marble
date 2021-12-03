package GUI.StartFromBeginning.Done;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuickPopupActionPanel extends JPanel {

    private JLabel createBond;
    private JLabel createSavings;
    private JLabel budgetGoal;


    public QuickPopupActionPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        budgetGoal = new JLabel("Budget Goal Progress");
        constraints.gridx = 0;
        constraints.gridy = 0;

        budgetGoal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        budgetGoal.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                BudgetGoalPanel goalPanel = new BudgetGoalPanel();
                PopUp pop = new PopUp("Budget Goal Progress", goalPanel);
                pop.getFrame().setVisible(true);
            }
            public void mouseEntered(MouseEvent me){
                budgetGoal.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent me){
                budgetGoal.setForeground(Color.BLACK);
            }
        });

        this.add(budgetGoal, constraints);

        createBond = new JLabel("Create Bond");
        constraints.gridy = 1;

        createBond.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createBond.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                CreateBondPanel createBondPanel = new CreateBondPanel();
                PopUp pop = new PopUp("Create Bond", createBondPanel);
                pop.getFrame().setVisible(true);
            }
            public void mouseEntered(MouseEvent me){
                createBond.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent me){
                createBond.setForeground(Color.BLACK);
            }
        });

        this.add(createBond, constraints);

        createSavings = new JLabel("Create Savings Account");
        constraints.gridy = 2;

        createSavings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createSavings.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                CreateSavingsPanel createSavingsPanel = new CreateSavingsPanel();
                PopUp pop = new PopUp("Create Bond", createSavingsPanel);
                pop.getFrame().setVisible(true);
            }
            public void mouseEntered(MouseEvent me){
                createSavings.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent me){
                createSavings.setForeground(Color.BLACK);
            }
        });

        this.add(createSavings, constraints);
    }

    public static void main(String [] args){
        JFrame frame = new JFrame("Quick Popup Action Test");
        QuickPopupActionPanel qpaPanel = new QuickPopupActionPanel();

        frame.setSize(new Dimension(300, 300));
        frame.add(qpaPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
