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
public class Ball extends GameObject {
    
    private double width;
    private double height;
    
    Ball(double newx, double newy) {
        super(newx, newy);
    }
    
    Ball(double newx, double newy, double newWidth, double newHeight) {
        
        super(newx, newy, newWidth, newHeight);
        
        width = newWidth;
        height = newHeight;
        
        speedx = 3;
        
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawOval((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public void update() {
        
        move();

    }

    @Override
    public void collides() {
        x = oldx;
        y = oldy;
        
        speedx = -speedx;
    }
    
}
