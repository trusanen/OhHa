/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * Maila-luokka, pelaajien mailojen yläluokka. Sisältää tekoälyn
 * ja mailan toimintalogiikan.
 *
 * @author trusanen
 */
public class Paddle extends GameObject {
    
    public double width;
    public double height;
    public Ball gameBall;
    
    public Paddle(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.width = width;
        this.height = height;
    }
    
    public Paddle(double x, double y, double width, double height, Ball gameBall) {
        super(x, y, width, height);
        this.width = width;
        this.height = height;
        this.gameBall = gameBall;
    }
    
    public void runAI() {
        if(gameBall != null) {
            if((gameBall.y + (gameBall.getMeasures()[1] / 2)) > (y + (height / 2))) {
                speedy = 2;
            }
            else {
                speedy = -2;
            }
        }
    }

    @Override
    public void update() {
        
        if(!((this instanceof Player1Paddle) || (this instanceof Player2Paddle))) {
            runAI();
        }
        
        move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public void collides(GameObject other) {
        if(other instanceof Wall) {
            y = oldy;
            
            collisionRectangle.setCoordinates(x, oldy);
        }
    }
    
}
