package GUI.StartFromBeginning;

import GUI.GUI_Done.StateManager;
import GUI.StartFromBeginning.Done.ActionTabsPanel;
import GUI.StartFromBeginning.Done.QuickPopupActionPanel;
import GUI.StartFromBeginning.Done.StartUpPanel;

import javax.swing.*;
import java.awt.*;

public class GUI_View{
    private JFrame frame;
    private JPanel startUp;
    private JButton login;
    private JButton register;
    private JButton exit;
    private int windowHeight;
    private int windowWidth;
    private StateManager sManager;
    private Model model;

    public GUI_View(){
        frame = new JFrame("Marbles Financial");

        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(1366, 768));
        frame.setMinimumSize(new Dimension(1366, 768));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model = new Model();
        start();
    }

    private void start() {
        StartUpPanel startPanel = new StartUpPanel();
        frame.add(startPanel);
    }

    public void continueAfterAccess(){
        ActionTabsPanel atPanel = new ActionTabsPanel();
        frame.add(atPanel);

        QuickPopupActionPanel qpaPanel = new QuickPopupActionPanel();
        frame.add(qpaPanel);
    }
}
