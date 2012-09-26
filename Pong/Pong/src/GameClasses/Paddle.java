/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 *
 * @author trusanen
 */
public class Paddle extends GameObject {
    
    public double height;
    
    public Paddle(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.height = height;
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, 5, (int)height);
    }

    @Override
    public void collides(GameObject other) {
        if(other instanceof Wall) {
            y = oldy;
            
            collisionRectangle.setCoordinates(x, oldy);
        }
    }
    
}
