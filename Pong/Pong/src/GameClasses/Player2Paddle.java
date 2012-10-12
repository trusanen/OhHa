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
    
    /**
     *
     * @param newx
     * @param newy
     * @param width
     * @param height
     */
    public Player2Paddle(double newx, double newy, double width, double height) {
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
     * Painettaessa k-kirjainta, mailan nopeudeksi tulee 2,
     * i-kirjainta painettaesssa -2.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'k') {
            speedy = 2;
        }
        if(e.getKeyChar() == 'i') {
            speedy = -2;
        }
    }

    /**
     *
     * Pysäyttää mailan, jos k- tai i-kirjain päästetään irti.
     * 
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 'k' || e.getKeyChar() == 'i') {
            speedy = 0;
        }
    }
}
