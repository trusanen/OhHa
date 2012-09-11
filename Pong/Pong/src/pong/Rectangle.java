/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author trusanen
 */
public class Rectangle {
    
    private double[] coordinates;
    
    Rectangle(double topLeftx, double topLefty, double bottomRightx, double bottomRighty) {
        coordinates = new double[4];
        coordinates[0] = topLeftx;
        coordinates[1] = topLefty;
        coordinates[2] = bottomRightx;
        coordinates[3] = bottomRighty;
    }
    
    Rectangle(double[] newCoordinates) {
        coordinates = newCoordinates;
    }
   
    public double[] getCoordinates() {        
        return coordinates;
    }
    
    public void setCoordinates(double topLeftx, double topLefty, double bottomRightx, double bottomRighty) {
        coordinates[0] = topLeftx;
        coordinates[1] = topLefty;
        coordinates[2] = bottomRightx;
        coordinates[3] = bottomRighty;
    }
    
    public boolean collidesWith(Rectangle otherObject) {
        
        double[] otherCoordinates = otherObject.getCoordinates();
        
        if (coordinates[0] < otherCoordinates[2] && coordinates[1] > otherCoordinates[3]) {
            return true;
        }
        if (coordinates[2] > otherCoordinates[0] && coordinates[3] < otherCoordinates[1]) {
            return true;
        }
        
        return false;
        
    }
}
