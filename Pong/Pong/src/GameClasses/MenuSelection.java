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
 * @author trusanen
 */
public class MenuSelection extends GameObject implements KeyListener {
    
    // VIIMEISTELE TÄMÄ!
    
    int state;
    boolean stayPut;
    
    public MenuSelection(double x, double y) {
        super(x, y);
        
        stayPut = false;
        state = 1;
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

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyChar() == 'w') {
            if(!stayPut && state < 1) {
                state -= 1;
            }
        }
        if(e.getKeyChar() == 's') {
            if(!stayPut && state < 3) {
                state += 1;
            }
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
