package GUI;

import GUI.GUI_Done.JRegisterFrame;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame{
    private static JFrame frame;
    public AppFrame(){
        frame = new JFrame("Title of App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void modifyFrame(){
        frame.setPreferredSize(new Dimension(852, 480));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String [] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppFrame aFrame = new AppFrame();
                aFrame.modifyFrame();
                JRegisterFrame frame = new JRegisterFrame();
            }
        });
    }
}
