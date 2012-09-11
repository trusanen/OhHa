/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author trusanen
 */
public class GameObject {
    
    private double x;
    private double y;
    private double speedx;
    private double speedy;
    private Rectangle collisionRectangle;
    
    public GameObject() {
        
        x = 0;
        y = 0;
        speedx = 0;
        speedy = 0;
        collisionRectangle = new Rectangle(0, 0, 0, 0);
        
    }
    
    public GameObject(double newx, double newy) {
        
        x = newx;
        y = newy;
        speedx = 0;
        speedy = 0;
        collisionRectangle = new Rectangle(0, 0, 0, 0);
        
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
        x = x + speedx;
        y = y + speedy;
    }
    
    public boolean collidesWith(GameObject otherObject) {
        
        if(!(collisionRectangle.collidesWith(otherObject.getRectangle()))) {
            return false;
        }
        
        return true;
        
    }
    
}
