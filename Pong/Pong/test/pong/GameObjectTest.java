/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.HashSet;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author trusanen
 */
public class GameObjectTest {
    
    private static double delta = 0.000000001;
    
    @Test
    
    public void testSetCoordinates() {
        
        GameObject obj = new GameObject();
        
        obj.setCoordinates(1,1);
        
        assertEquals("Olio on väärässä paikassa!", obj.getCoordinates()[0], 1, delta);
        assertEquals("Olio on väärässä paikassa!", obj.getCoordinates()[1], 1, delta);
        
    }
    
    public void testSetSpeed() {
        
        GameObject obj = new GameObject();
        
        obj.setSpeed(1,1);
        
        assertEquals("Nopeudet eivät päivity kunnolla!", obj.getSpeed()[0], 1, delta);
        assertEquals("Nopeudet eivät päivity kunnolla!", obj.getSpeed()[1], 1, delta);
        
    }
    
    public void testSetRectangle() {
        
        GameObject obj = new GameObject(0, 2);
        Rectangle rect = new Rectangle(0, 2, 2, 0);
        
        obj.setRectangle(rect);
        
        assertEquals("Palautettu neliö ei ole sama kuin annettu!", obj.getRectangle(), rect);        
        
    }
    
    public void testMove() {
        
        GameObject obj = new GameObject();
        
        obj.setSpeed(1, 1);
        obj.move();
        
        assertEquals("Olio liikkuu väärään suuntaan!", obj.getCoordinates()[0], 1, delta);
        assertEquals("Olio liikkuu väärään suuntaan!", obj.getCoordinates()[1], 1, delta);
        
    }
    
    public void testCollisionSamePlace() {
        
        GameObject obj1 = new GameObject();
        GameObject obj2 = new GameObject();
        
        Rectangle rect = new Rectangle(0, 2, 2, 0);
        
        obj1.setRectangle(rect);
        obj2.setRectangle(rect);
        
        assertTrue("Olio 1 ei törmää Olio 2:een!", obj1.collidesWith(obj2));
        assertTrue("Olio 2 ei törmää Olio 1:een!", obj2.collidesWith(obj1));
        
    }
    
}
