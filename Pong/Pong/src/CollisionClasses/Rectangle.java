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
    
    /**
     *
     * @param topLeftx Neliön vasemman yläkulman x-koordinaatti
     * @param topLefty Neliön vasemman yläkulman y-koordinaatti
     * @param width Neliön leveys
     * @param height Neliön korkeus
     */
    public Rectangle(double topLeftx, double topLefty, double width, double height) {
        x = topLeftx;
        y = topLefty;
        this.width = width;
        this.height = height;
    }
   
    /**
     *
     * @return Koordinaatit sekä leveys ja korkeus
     */
    public double[] getCoordinates() {
        
        double[] coordinates = new double[4];
        
        coordinates[0] = x;
        coordinates[1] = y;
        coordinates[2] = width;
        coordinates[3] = height;
        
        return coordinates;
    }
    
    /**
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti
     */
    public void setCoordinates(double topLeftx, double topLefty) {
        x = topLeftx;
        y = topLefty;
    }
    
    /**
     *
     * @param xDirection Kuinka paljon liikutaan x-suunnassa
     * @param yDirection Kuinka paljon liikutaan y-suunnassa
     */
    public void move(double xDirection, double yDirection) {
        setCoordinates(x + xDirection, y + yDirection);
    }
    
    /**
     * Kasvattaa neliön korkeutta viidellä ja siirtää neliön oikeaan kohtaan, 
     * jos neliö on korkeampi kuin pelialue.
     * Käytetään vain bonusten yhteydessä.
     */
    public void grow() {
        height = height + 5;
        
        if((y + height) > 255) {
            y = y - ((y + height) - 255);
        }
    }
    
    /**
     *
     * @param otherObject
     * @return Törmääkö vai ei? True tai false.
     */
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
