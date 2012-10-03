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
    
    private int state;
    private boolean stayPut;
    private boolean choiceMade;
    
    public MenuSelection(double x, double y) {
        super(x, y);
        
        stayPut = false;
        state = 2;
        choiceMade = false;
    }
    
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
            setCoordinates(80, 150);
        }
        if(state == 4) {
            setCoordinates(80, 200);
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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w') {
            if(!stayPut && state > 2) {
                state -= 1;
                changePlace(state);
                stayPut = true;
            }
        }
        if(e.getKeyChar() == 's') {
            if(!stayPut && state < 4) {
                state += 1;
                changePlace(state);
                stayPut = true;
            }
        }
        if(e.getKeyCode() == 10) {
            choiceMade = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        stayPut = false;
    }
    
}
