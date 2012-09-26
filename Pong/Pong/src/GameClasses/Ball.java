/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * 
 * Pallo-luokka. Sisältää pelipallon toimintalogiikan.
 *
 * @author trusanen
 */
public class Ball extends GameObject {
    
    private double width;
    private double height;
    
    public Ball(double x, double y, double width, double height) {
        
        super(x, y, width, height);
        
        this.width = width;
        this.height = height;
        
        double rnd = Math.random();
        
        if(rnd < 0.5) {
            speedx = 2.5;
        }
        else {
            speedx = -2.5;
        }
            
        if(rnd < 0.5) {
            speedy = Math.random() * 2;
        }
        else {
            speedy = -Math.random() * 2;
        }
        
    }
    
    public double[] getMeasures() {
        
        double[] ballMeasures = new double[2];
        
        ballMeasures[0] = width;
        ballMeasures[1] = height;
        
        return ballMeasures;
    }
    
    public double calculateBounceAngle(GameObject other) {
        
        double othery = other.getRectangle().getCoordinates()[1];
        double otherHeight = other.getRectangle().getCoordinates()[3];
        
        if(speedy < 0) {

            return 0.1 * ( y + (height/2) - 
                    (othery + (otherHeight/2)));
        }
        else {
            return 0.1 * ( y + (height/2) - 
                    (othery + (otherHeight/2)));
        }
        
    }
    
    public double changeXDirection() {
        
        if(speedx > 0) {
            return -speedx - 0.2;
        }
        else {
            return -speedx + 0.2;
        }
        
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
    public void collides(GameObject other) {
        
        x = oldx;
        y = oldy;

        collisionRectangle.setCoordinates(oldx, oldy);
        
        if(other instanceof Paddle) {
            
            speedx = changeXDirection();
            speedy = calculateBounceAngle(other);
            
        }
        if(other instanceof Wall) {
            x = oldx;
            y = oldy;

            collisionRectangle.setCoordinates(oldx, oldy);

            speedy = -speedy;
            
        }
        if(other instanceof Goal) {
            other.collides(this);
            
            setCoordinates(250, 145);
            
            collisionRectangle.setCoordinates(250, 145);
            
            double rnd = Math.random();
        
            if(rnd < 0.5) {
                speedx = 2.5;
            }
            else {
                speedx = -2.5;
            }

            if(rnd < 0.5) {
                speedy = Math.random() * 2;
            }
            else {
                speedy = -Math.random() * 2;
            }
        }
    }
}
