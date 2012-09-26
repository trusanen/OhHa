/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.Paddle;
import GameClasses.Wall;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author trusanen
 */
public class PaddleTest {
    
    private final double delta = 0.0000000001;
    
    @Test
    public void testMove() {
        
        Paddle paddle1 = new Paddle(0, 0, 5, 20);
        
        paddle1.speedy = 2;
        
        paddle1.move();
        
        assertEquals("Maila liikkuu väärään paikkaan!", paddle1.y, 2, delta);
        
    }
    
    @Test
    public void collidesWithWall() {
        
        Paddle paddle1 = new Paddle(0, 0, 5, 20);
        paddle1.oldy = 5;
        
        Wall wall1 = new Wall(0, 0, 50, 5);
        
        paddle1.collides(wall1);
        
        assertEquals("Maila ei liiku takaisinpäin!", paddle1.y, 5, delta);
        assertEquals("Mailan törmäysneliö ei liiku takaisinpäin!", paddle1.collisionRectangle.getCoordinates()[1], 5, delta);
        
    }
}
