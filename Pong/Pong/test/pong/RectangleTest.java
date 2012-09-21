/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author trusanen
 */
public class RectangleTest {
    
    private double delta = 0.0000000001;
    
    @Test
    public void testSetCoordinates() {
        
        double[] rectCoordinates = new double[4];
        
        rectCoordinates[0] = 0;
        rectCoordinates[1] = 2;
        rectCoordinates[2] = 2;
        rectCoordinates[3] = 0;
        
        Rectangle rect1 = new Rectangle(rectCoordinates);
        
        assertEquals("Palautetut koordinaatit eivät ole samat kuin annetut!", rect1.getCoordinates(), rectCoordinates);

    }
    
    @Test
    public void testCollisionSamePlace() {
        
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(0, 0, 5, 5);

        assertTrue("Neliöt eivät törmää!", rect1.collidesWith(rect2));
        
    }
    
    @Test
    public void testCollisionNoCollision() {
        
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(10, 0, 5, 5);

        assertFalse("Neliöt törmäävät!", rect1.collidesWith(rect2));
        
    }
    
    @Test
    public void testCollisionTopLeft() {
        
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(4, 4, 5, 5);
        
        assertTrue("Neliöt eivät törmää!", rect1.collidesWith(rect2));
        
    }
    
    @Test
    public void testCollisionBottomRight() {
        
        Rectangle rect1 = new Rectangle(4, 4, 5, 5);
        Rectangle rect2 = new Rectangle(0, 0, 5, 5);
        
        assertTrue("Neliöt eivät törmää!", rect1.collidesWith(rect2));
        
    }
    
    @Test
    public void testMove() {
        
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        
        rect1.move(5, 5);
        
        double[] newCoordinates = new double[4];
        
        newCoordinates[0] = 5;
        newCoordinates[1] = 5;
        newCoordinates[2] = 10;
        newCoordinates[3] = 10;
        
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[0], newCoordinates[0], delta);
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[1], newCoordinates[1], delta);
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[2], newCoordinates[2], delta);
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[3], newCoordinates[3], delta);
               
    }
}
