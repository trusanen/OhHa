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
    
    public void testCollisionSamePlace() {
        
        Rectangle rect1 = new Rectangle(0, 2, 2, 0);
        Rectangle rect2 = new Rectangle(0, 2, 2, 0);

        assertTrue("Neliöt eivät törmää!", rect1.collidesWith(rect2));
        
    }
    
    public void testCollisionNoCollision() {
        
        Rectangle rect1 = new Rectangle(0, -2, 2, -4);
        Rectangle rect2 = new Rectangle(0, 2, 2, 0);

        assertTrue("Neliöt törmäävät!", rect1.collidesWith(rect2));
        
    }
}
