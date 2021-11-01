package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[65536];//keys

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        //keys been pressed so its true
    }

    public void keyReleased(KeyEvent e) {
        //released so key pressed is false
        keys[e.getKeyCode()] = false;
    }


    //will use later likely
    public void keyTyped(KeyEvent arg0) {

    }

    public boolean[] getKeys() {
        return this.keys;
    }
}
