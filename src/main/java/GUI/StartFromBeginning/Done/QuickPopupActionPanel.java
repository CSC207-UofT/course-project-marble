package GUI.StartFromBeginning.Done;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuickPopupActionPanel extends JPanel {

    public QuickPopupActionPanel(){
        super(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel budgetGoal=new JLabel("Budget Goal Progress");
        constraints.gridx = 0;
        constraints.gridy = 0;

        budgetGoal.setCursor(new Cursor(Cursor.HAND_CURSOR));
        budgetGoal.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                //show budget progress panel
            }
        });

        this.add(budgetGoal, constraints);

        JLabel createBond = new JLabel("Create Bond");
        constraints.gridy = 1;

        createBond.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createBond.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                //show create bond popup
            }
        });

        this.add(createBond, constraints);

        JLabel createSavings = new JLabel("Create Savings Account");
        constraints.gridy = 2;

        createSavings.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createSavings.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me)
            {
                //show create savings popup
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
