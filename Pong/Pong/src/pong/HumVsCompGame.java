/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import pongGUI.GUI;

/**
 *
 * @author trusanen
 */
public class HumVsCompGame extends Game {
    
    private GUI gameGUI;
    
    HumVsCompGame(GUI newGameGUI) {
        super();
        gameGUI = newGameGUI;
        
        Paddle player1 = new Paddle(0, 0, 5, 50);
        Paddle computer = new Paddle(100, 0, 5, 50);
        
        gameObjects.add(new Ball(45, 20, 10, 10));
        gameObjects.add(player1);
        gameObjects.add(computer);
        
        controlledObjects.add(player1);
        
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
        for(GameObject obj : controlledObjects) {
            obj.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for(GameObject obj : controlledObjects) {
            obj.keyReleased(e);
        }
    }
}
