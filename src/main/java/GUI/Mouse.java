package GUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse extends JFrame implements MouseListener, MouseMotionListener {
    private static int mouseX, mouseY;//mouse position
    private static boolean lClick, rClick;//if clicking right or left

    //returns if left mouse button is pressed
    public static boolean LeftPressed(){
        return lClick;
    }
    //returns if right mouse button is pressed
    public static boolean RightPressed(){
        return rClick;
    }

    //Returns the mouse Xpos
    public static int getMX(){
        return mouseX;
    }
    //Returns the mouse Ypos
    public static int getMY(){
        return mouseY;
    }

    //when you drag the mouse while click/pressing
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();//updates mouse XPos
        mouseY = e.getY();//updates mouse YPos
    }

    //When you move the mouse
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();//updates mouse XPos
        mouseY = e.getY();//updates mouse YPos
    }


    //don't worry about empty methods they are for future improvements/uses
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    //when mouse is pressed
    public void mousePressed(MouseEvent e) {
        //depending on which button returns true for Lclick or RClick or nothing (if you click a special key on specialized mouses)
        if(e.getButton() == MouseEvent.BUTTON1){
            lClick = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            rClick = true;
        }
    }
    //when you release the mouse buttons
    public void mouseReleased(MouseEvent e) {
        //resets the values of the button booleans to false
        if(e.getButton() == MouseEvent.BUTTON1){
            lClick = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            rClick = false;
        }
    }

}