/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author trusanen
 */
public class Paddle extends GameObject {
    
    Paddle(double newx, double newy) {
        super(newx, newy);
    }
    
    Paddle(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
    }

    @Override
    public void update() {
        
        move();
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, 5, 50);
    }

    @Override
    public void collides() {
    }


    
}
