/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * 
 * Bonus-luokka. Pallon osuessa bonus-olioon tapahtuu jänniä.
 *
 * @author trusanen
 */
public class Bonus extends GameObject {
    
    private double width;
    private double height;
    private double i = 0.0;
    
    public Bonus(double x, double y, double width, double height) {
        super(x, y, width, height);
        
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawRoundRect((int)x, (int)y, (int)width, (int)height, 2, 2);
        g.drawRoundRect((int)(x - 2), (int)(y - 2), (int)(width + 4), (int)(height + 4), 3, 3);
    }

    @Override
    public void collides(GameObject other) {
        if(other instanceof Ball) {
            game.createObject(new Ball(x, y, 10, 10));
            game.createObject(new Ball(x, y, 10, 10));
            game.removeObject(this);
        }
    }
    
}
