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
public class Player2Paddle extends Paddle implements KeyListener {
    
    Player2Paddle(double newx, double newy) {
        super(newx, newy);
    }
    
    Player2Paddle(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'k') {
            speedy = 1;
        }
        if(e.getKeyChar() == 'i') {
            speedy = -1;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'k') {
            speedy = 0;
        }
        if(e.getKeyChar() == 'i') {
            speedy = 0;
        }
    }
    
}
