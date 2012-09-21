/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics;
import java.awt.event.KeyListener;

/**
 *
 * @author trusanen
 */
public abstract class GameObject extends Object implements KeyListener {
    
    public double x;
    public double y;
    public double oldx;
    public double oldy;
    public double speedx;
    public double speedy;
    public Rectangle collisionRectangle;
    public KeyEventLogic keyLogic;
    
    public GameObject() {
        
        x = 0;
        y = 0;
        oldx = 0;
        oldy = 0;
        speedx = 0;
        speedy = 0;
        collisionRectangle = new Rectangle(0, 0, 0, 0);
        
    }
    
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void collides();
    
    public GameObject(double newx, double newy) {
        
        x = newx;
        y = newy;
        oldx = newx;
        oldy = newy;
        collisionRectangle = new Rectangle(newx, newy, 0, 0);
        
    }
    
    public GameObject(double newx, double newy, double width, double height) {
        
        x = newx;
        y = newy;
        oldx = newx;
        oldy = newy;
        collisionRectangle = new Rectangle(newx, newy, width, height);
        
    }
    
    public double[] getCoordinates() {
        
        double[] coordinates = new double[2];
        
        coordinates[0] = x;
        coordinates[1] = y;
        
        return coordinates;
    }
    
    public Rectangle getRectangle() {
        return collisionRectangle;
    }
    
    public double[] getSpeed() {
        
        double[] speeds = new double[2];
        
        speeds[0] = speedx;
        speeds[1] = speedy;
        
        return speeds;        
    }
    
    public void setCoordinates(double newx, double newy) {
        x = newx;
        y = newy;
    }
    
    public void setSpeed(double newSpeedx, double newSpeedy) {
        speedx = newSpeedx;
        speedy = newSpeedy;
    }
    
    public void setSpeed(double[] speeds) {
        speedx = speeds[0];
        speedy = speeds[1];
    }
    
    public void setRectangle(Rectangle rect) {
        collisionRectangle = rect;
    }
    
    public void move() {
        oldx = x;
        oldy = y;
        
        x = x + speedx;
        y = y + speedy;
        
        collisionRectangle.move(speedx, speedy);
    }
    
}
