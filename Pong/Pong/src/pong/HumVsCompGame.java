/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.ArrayList;
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
        gameGUI = newGameGUI;
        gameObjects = new ArrayList<>();
        sleepAmount = 30;
        gameObjects.add(new Ball(45, 20, 10, 10));
        gameObjects.add(new Paddle(100, 0, 5, 50));
        gameObjects.add(new Paddle(0, 0, 5, 50));
    }
    
    private boolean checkCollision(GameObject obj1, GameObject obj2) {
        
        if(obj1.collisionRectangle.collidesWith(obj2.collisionRectangle) || obj2.collisionRectangle.collidesWith(obj1.collisionRectangle)) {
            return true;
        }        
        return false;
    }

    @Override
    public void run() {
        
        while(true) {
            System.out.println("uus iteraatio");
            for(GameObject obj : gameObjects) {
                
                obj.update();
                
                for(GameObject other : gameObjects) {
                    if(!obj.equals(other) && checkCollision(obj, other)) {
                        obj.collides();
                    }                    
                }
            }
            
            gameGUI.drawObjects(gameObjects);
            
            try {
                Thread.sleep(sleepAmount);
            } catch (InterruptedException ex) {
                Logger.getLogger(HumVsCompGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
