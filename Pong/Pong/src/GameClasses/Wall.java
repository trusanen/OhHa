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
public class Wall extends GameObject {
    
    private double width;
    private double height;
    
    public Wall(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public void collides(GameObject other) {
        
    }
    
}
