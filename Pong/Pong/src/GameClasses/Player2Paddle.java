/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * Toisen pelaajan maila. Sisältää näppäinmäärittelyt
 * toiselle pelaajalle.
 *
 * @author trusanen
 */
public class Player2Paddle extends Paddle implements KeyListener {
    
    public Player2Paddle(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'k') {
            speedy = 2;
        }
        if(e.getKeyChar() == 'i') {
            speedy = -2;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'k' || e.getKeyChar() == 'i') {
            speedy = 0;
        }
    }
}
