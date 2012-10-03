/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CollisionClasses;

/**
 * 
 * Neliö-luokka. Ohjelman törmäyksentunnistus hoidetaan
 * neliö-olioilla. Sisältää neliö-olioiden toimintalogiikan.
 *
 * @author trusanen
 */
public class Rectangle {
    
    private double x;
    private double y;
    private double width;
    private double height;
    
    public Rectangle(double topLeftx, double topLefty, double width, double height) {
        x = topLeftx;
        y = topLefty;
        this.width = width;
        this.height = height;
    }
   
    public double[] getCoordinates() {
        
        double[] coordinates = new double[4];
        
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = width;
        coordinates[3] = height;
        
        return coordinates;
    }
    
    public void setCoordinates(double newx, double newy) {
        x = newx;
        y = newy;
    }
    
    public void setCoordinates(double topLeftx, double topLefty, double bottomRightx, double bottomRighty) {
        x = topLeftx;
        y = topLefty;
        width = topLeftx - bottomRightx;
        height = topLefty - bottomRighty;
    }
    
    public void move(double xDirection, double yDirection) {
        setCoordinates(x + xDirection, y + yDirection);
    }
    
    public boolean collidesWith(Rectangle otherObject) {
        
        double[] otherCoordinates = otherObject.getCoordinates();
        
        double otherx = otherCoordinates[0];
        double othery = otherCoordinates[1];
        double otherWidth = otherCoordinates[2];
        double otherHeight = otherCoordinates[3];
        
        if ((x <= (otherx + otherWidth)) && 
                (y <= (othery + otherHeight)) && 
                (x >= otherx) && 
                (y >= othery)) {
            return true;
        }
        if((x + width <= (otherx + otherWidth)) &&
                (x + width >= otherx) &&
                y <= (othery + otherHeight) &&
                y >= othery){
            return true;
        }
        if (((x + width) >= otherx) && 
                ((y + height) >= othery) && 
                ((x + width) <= (otherx + otherWidth)) && 
                ((y + height) <= (othery + otherHeight))) {
            return true;
        }
        if (x <= (otherx + otherWidth) &&
                x >= otherx &&
                (y + height) <= (othery + otherHeight) &&
                (y + height) >= othery) {
            return true;
        }
        
        
        return false;
        
    }
}
