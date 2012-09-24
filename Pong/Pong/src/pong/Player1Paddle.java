/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author trusanen
 */
public class Player1Paddle extends Paddle implements KeyListener {
    
    Player1Paddle(double newx, double newy) {
        super(newx, newy);
    }
    
    Player1Paddle(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's') {
            speedy = 1;
        }
        if(e.getKeyChar() == 'w') {
            speedy = -1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 's') {
            speedy = 0;
        }
        if(e.getKeyChar() == 'w') {
            speedy = 0;
        }
    }
    
}
