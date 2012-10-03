/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.GameObject;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pongGUI.GUI;

/**
 * 
 * Abstrakti yläluokka, sisältää listat GameObject
 * -olioita ja KeyListener-olioita sekä ajan, jonka
 * pelilogiikka nukkuu yhdessä iteraatiossa.
 *
 * @author trusanen
 * 
 */
public abstract class Game implements KeyListener {
    
    public GUI gameGUI;
    public ArrayList<GameObject> gameObjects;
    public ArrayList<KeyListener> controlledObjects;
    public int sleepAmount;
    
    Game() {
        gameObjects = new ArrayList<>();
        controlledObjects = new ArrayList<>();
        sleepAmount = 30;
    }
    
    public abstract boolean checkIfGameEnds();
    
    public int run() {
        
        while(!checkIfGameEnds()) {
            
            updateObjects();
            
            drawObjects();
            
            sleep();
            
        }
        
        return 0;
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
    
    public GameObject createObject(GameObject obj) {
        gameObjects.add(obj);
        obj.setGame(this);
        
        if(obj instanceof KeyListener) {
            controlledObjects.add((KeyListener)obj);
        }
        
        return obj;
    }
    
}
