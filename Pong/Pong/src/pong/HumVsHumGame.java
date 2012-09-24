/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import pongGUI.GUI;

/**
 *
 * @author trusanen
 */
public class HumVsHumGame extends Game {
    
    private GUI gameGUI;
    
    HumVsHumGame(GUI newGameGUI) {
        super();
        gameGUI = newGameGUI;
        
        Player1Paddle player1 = new Player1Paddle(0, 0, 5, 50);
        Player2Paddle player2 = new Player2Paddle(100, 0, 5, 50);
        
        gameObjects.add(new Ball(45, 20, 10, 10));
        gameObjects.add(player1);
        gameObjects.add(player2);
        
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
                    obj.collides();
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
    public void run() {
        
        while(true) {
            
            updateObjects();
            
            drawObjects();
            
            sleep();

        }
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
