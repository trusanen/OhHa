/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * Ensimmäisen pelaajan maila. Sisältää näppäinmäärittelyt
 * ensimmäiselle pelaajalle.
 *
 * @author trusanen
 */
public class Player1Paddle extends Paddle implements KeyListener {
    
    /**
     *
     * @param newx
     * @param newy
     * @param width
     * @param height
     */
    public Player1Paddle(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Painettaessa s-kirjainta, mailan nopeudeksi tulee 2,
     * w-kirjainta painettaesssa -2.
     * 
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's') {
            speedy = 2;
        }
        if(e.getKeyChar() == 'w') {
            speedy = -2;
        }
    }

    /**
     * Pysäyttää mailan, jos s- tai w-kirjain päästetään irti.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'w') {
            speedy = 0;
        }
    }
}
