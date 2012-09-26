/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import CollisionClasses.Rectangle;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author trusanen
 */
public class RectangleTest {
    
    private double delta = 0.0000000001;
    
    @Test
    public void testSetCoordinates() {
        
        Rectangle rect1 = new Rectangle(0, 2, 2, 2);
        
        assertEquals("Palautetut koordinaatit eivät ole samat kuin annetut!", rect1.getCoordinates()[0], 0, delta);
        assertEquals("Palautetut koordinaatit eivät ole samat kuin annetut!", rect1.getCoordinates()[1], 2, delta);
        assertEquals("Palautetut koordinaatit eivät ole samat kuin annetut!", rect1.getCoordinates()[2], 2, delta);
        assertEquals("Palautetut koordinaatit eivät ole samat kuin annetut!", rect1.getCoordinates()[3], 2, delta);

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
        
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[0], 5, delta);
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[1], 5, delta);
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[2], 5, delta);
        assertEquals("Neliö liikkuu väärään paikkaan!", rect1.getCoordinates()[3], 5, delta);               
    }
}
