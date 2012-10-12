/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * Päävalikon valitsijaluokka. Valitsee, mikä
 * peli pelataan ja
 * 
 * @author trusanen
 */
public class MenuSelection extends GameObject implements KeyListener {
    
    private int state;
    private boolean choiceMade;
    
    /**
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     */
    public MenuSelection(double topLeftx, double topLefty) {
        super(topLeftx, topLefty);
        
        state = 2;
        choiceMade = false;
    }
    
    /**
     *
     * @return Palauttaa, mikä valinta tehtiin.
     */
    public int getChoice() {
        if(choiceMade) {
            return state;
        }
        
        return 0;
    }
    
    private void changePlace(int state) {
        
        if(state == 2) {
            setCoordinates(80, 100);
        }
        if(state == 3) {
            setCoordinates(80, 125);
        }
        if(state == 4) {
            setCoordinates(80, 150);
        }
        if(state == 5) {
            setCoordinates(80, 175);
        }   
        
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y - 10, 10, 10);
    }

    @Override
    public void collides(GameObject other) {
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     *
     * Napin painaminen alas. W-kirjainta painettaessa liikkuu
     * ylöspäin, s-kirjainta painettaessa alas. Enter valitsee.
     * 
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w') {
            moveUp();
        }
        if(e.getKeyChar() == 's') {
            moveDown();
        }
        if(e.getKeyCode() == 10) {
            choiceMade = true;
        }
    }

    /**
     * 
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    private void moveUp() {
        
        if(state > 2) {
            state -= 1;
            changePlace(state);
        }
    }
    
    private void moveDown() {
        
        if(state < 5) {
            state += 1;
            changePlace(state);
        }
    }
}
