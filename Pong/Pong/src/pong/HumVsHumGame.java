/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.Ball;
import GameClasses.GameObject;
import GameClasses.Goal;
import GameClasses.Player1Paddle;
import GameClasses.Player2Paddle;
import GameClasses.Wall;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import pongGUI.GUI;

/**
 *
 * 2:n Pelaajan peli.
 * 
 * @author trusanen
 */
public class HumVsHumGame extends Game {
    
    private GUI gameGUI;
    private Goal player1Goal;
    private Goal player2Goal;
    
    HumVsHumGame(GUI newGameGUI) {
        super();
        gameGUI = newGameGUI;
        
        Player1Paddle player1 = new Player1Paddle(100, 125, 10, 50);
        Player2Paddle player2 = new Player2Paddle(395, 125, 10, 50);
        
        player1Goal = new Goal(80, 50, 20, 210);
        player2Goal = new Goal(405, 50, 20, 210);
        
        gameObjects.add(new Ball(250, 145, 10, 10));
        gameObjects.add(player1);
        gameObjects.add(player2);
        gameObjects.add(new Wall(100, 50, 305, 5));
        gameObjects.add(new Wall(100, 255, 305, 5));
        gameObjects.add(player1Goal);
        gameObjects.add(player2Goal);
        
        controlledObjects.add(player1);
        controlledObjects.add(player2);
        
    }
    
    private boolean checkCollision(GameObject obj1, GameObject obj2) {
        
        if(obj1.collisionRectangle.collidesWith(obj2.collisionRectangle) || obj2.collisionRectangle.collidesWith(obj1.collisionRectangle)) {
            return true;
        }
        return false;
    }
    
    public void updateObjects() {
        
        for(GameObject obj : gameObjects) {

            obj.update();

            for(GameObject other : gameObjects) {
                if(!obj.equals(other) && checkCollision(obj, other)) {
                    obj.collides(other);
                }
            }
        }
    }
    
    public void drawObjects() {
        gameGUI.drawObjects(gameObjects);
    }
    
    public void sleep() {
        
        try {
            Thread.sleep(sleepAmount);
        } catch (InterruptedException ex) {
            Logger.getLogger(HumVsCompGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int run() {
        
        while(player1Goal.getScore() < 5 && player2Goal.getScore() < 5) {
            
            updateObjects();
            
            drawObjects();
            
            sleep();
            
        }
        
        return 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(KeyListener obj : controlledObjects) {
            obj.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for(KeyListener obj : controlledObjects) {
            obj.keyReleased(e);
        }
    }
    
}
