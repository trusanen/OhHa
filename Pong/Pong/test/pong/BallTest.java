/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.Ball;
import GameClasses.Paddle;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * Pallon testiluokka.
 *
 * @author trusanen
 */
public class BallTest {
    
    private static double delta = 0.00000001;
    
    @Test
    public void testMove() {
        
        Ball ball1 = new Ball(0, 0, 5, 5);
        
        ball1.setSpeed(1, 1);
        ball1.move();
        
        assertEquals("Pallo liikkuu väärään paikkaan!", ball1.x, 1, delta);
        assertEquals("Pallo liikkuu väärään paikkaan!", ball1.y, 1, delta);
        
    }
    
    @Test
    public void testCalculateBounceAngle() {
        
        Ball ball1 = new Ball(0, 5, 10, 10);
        
        Paddle other = new Paddle(10, 0, 5, 20);
        
        assertEquals("Törmäyskulma on väärä!", ball1.calculateBounceAngle(other), 0, delta);
        
    }
    
    @Test
    public void changeXDirection() {
        
        Ball ball1 = new Ball(0, 0, 10, 10);
        ball1.setSpeed(3, 0);
        
        assertEquals("Nopeus vaihtuu väärin!", ball1.changeXDirection(), -3.2, delta);
        
    }
    
    @Test
    public void collidesWithPaddle() {
        
        Ball ball1 = new Ball(0, 0, 10, 10);
        ball1.setSpeed(-2, 1);
        ball1.oldx = 2;
        ball1.oldy = 0;
        
        double y = 0;
        double height = 10;
        
        Paddle paddle1 = new Paddle(0, 0, 5, 20);
        
        double othery = paddle1.getRectangle().getCoordinates()[1];
        double otherHeight = paddle1.getRectangle().getCoordinates()[3];
        
        double ySpeed = 0.1 * (y + (height/2) - (othery + (otherHeight/2)));
        
        ball1.collides(paddle1);
        
        assertEquals("Pallo ei liiku takaisinpäin!", ball1.x, 2, delta);
        assertEquals("Pallo ei liiku takaisinpäin!", ball1.y, 0, delta);
        assertEquals("Pallon törmäysneliö ei liiku takaisinpäin!", ball1.collisionRectangle.getCoordinates()[0], 2, delta);
        assertEquals("Pallon törmäysneliö ei liiku takaisinpäin!", ball1.collisionRectangle.getCoordinates()[1], 0, delta);
        assertEquals("Nopeus ei vaihdu oikein!", ball1.speedx, 2.2, delta);
        assertEquals("Törmäyskulma on väärä!", ySpeed, ball1.speedy, delta);
        
    }
    
}
