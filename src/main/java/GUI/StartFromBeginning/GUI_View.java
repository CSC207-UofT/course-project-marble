package GUI.StartFromBeginning;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ItemEvent;

public class GUI_View{
    private JFrame frame;
    private JPanel startUp;
    private JButton login;
    private JButton register;
    private JButton exit;
    private int windowHeight;
    private int windowWidth;
    private StateManager sManager;

    public GUI_View(){
        frame = new JFrame("Marbles Financial");

        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(1366, 768));
        frame.setMinimumSize(new Dimension(1366, 768));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        start();
    }

    private void start() {
        StartUpPanel startPanel = new StartUpPanel();
        frame.add(startPanel);
    }

    public void continueAfterAccess(){
        //sManager = new StateManager();
        //sManager.addCompToPane(frame.getContentPane());
    }
}
