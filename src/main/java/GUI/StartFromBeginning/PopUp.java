package GUI.StartFromBeginning;

import javax.swing.*;

public class PopUp extends JFrame {
    private Popup pop;
    private JFrame frame;
    public PopUp(String title, JPanel panel){
        frame = new JFrame(title);

        PopupFactory pf = new PopupFactory();
        pop = pf.getPopup(frame, panel, 20,20);
        frame.add(panel);
        frame.setSize(720,480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JFrame getFrame(){
        return this.frame;
    }
}
