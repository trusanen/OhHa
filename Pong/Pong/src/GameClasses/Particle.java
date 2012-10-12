/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * 
 * Partikkeliluokka. Pieni partikkeli, joka piirtää
 * pallon häntäefektin.
 *
 * @author trusanen
 */
public class Particle extends GameObject {
    
    int life = 5;
    
    Particle(double x, double y) {
        super(x, y);
    }

    @Override
    public void update() {
        move();
        life -= 1;
        
        if(life <= 0) {
            game.removeObject(this);
        }
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine((int)x, (int)y, (int)oldx, (int)oldy);
    }

    @Override
    public void collides(GameObject other) {
        if(other instanceof Wall || other instanceof Paddle) {
            game.removeObject(this);
        }
    }
    
}
