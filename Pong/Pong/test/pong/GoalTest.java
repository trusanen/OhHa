/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.Ball;
import GameClasses.Goal;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author trusanen
 */
public class GoalTest {
    
    @Test
    public void testScore() {
        
        Goal goal1 = new Goal(0, 0, 5, 50);
        
        goal1.score();
        
        assertEquals("Score-metodin ajaminen ei nosta pisteitä!", goal1.getScore(), 1);
        
    }
    
    @Test
    public void testCollidesWithBall() {
        
        Goal goal1 = new Goal(0, 0, 5, 50);
        
        Ball ball1 = new Ball(0, 0, 10, 10);
        
        goal1.collides(ball1);
        
        assertEquals("Pallon törmääminen maaliin ei nosta pisteitä!", goal1.getScore(), 1);
    
    }
}
