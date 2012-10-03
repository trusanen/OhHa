/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import CollisionClasses.Rectangle;
import java.awt.Graphics;
import pong.Game;

/**
 * Abstrakti peliolio-yläluokka. Paikkamäärittelyt,
 * nopeusmäärittelyt ja törmäyksentunnistusmäärittelyt.
 *
 * @author trusanen
 */
public abstract class GameObject extends Object {
    
    private static int objectIds = 1000;
    
    public int objectId;
    public Game game;
    public double x;
    public double y;
    public double oldx;
    public double oldy;
    public double speedx;
    public double speedy;
    public Rectangle collisionRectangle;
    
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void collides(GameObject other);
    
    public GameObject(double x, double y) {
        
        setObjectId();
        
        this.x = x;
        this.y = y;
        oldx = x;
        oldy = y;
        collisionRectangle = new Rectangle(x, y, 0, 0);
        
    }
    
    public GameObject(double newx, double newy, double width, double height) {
        
        setObjectId();
        x = newx;
        y = newy;
        oldx = newx;
        oldy = newy;
        collisionRectangle = new Rectangle(newx, newy, width, height);
    }
    
    private void setObjectId() {
        objectId = objectIds;
        objectIds += 1;
    }
    
    public int getObjectId() {
        return objectId;
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
    
    public void setRectangle(Rectangle rect) {
        collisionRectangle = rect;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public void move() {
        oldx = x;
        oldy = y;
        
        x = x + speedx;
        y = y + speedy;
        
        collisionRectangle.move(speedx, speedy);
    }
    
}
