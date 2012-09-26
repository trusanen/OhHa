/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author trusanen
 */
public class Player1Paddle extends Paddle implements KeyListener {
    
    public Player1Paddle(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's') {
            speedy = 2;
        }
        if(e.getKeyChar() == 'w') {
            speedy = -2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'w') {
            speedy = 0;
        }
    }
}
