/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.GameObject;
import java.awt.event.KeyEvent;
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
    public ArrayList<GameObject> addedObjects;
    public ArrayList<GameObject> removedObjects;
    public int sleepAmount;
    
    Game() {
        gameObjects = new ArrayList<>();
        controlledObjects = new ArrayList<>();
        addedObjects = new ArrayList<>();
        removedObjects = new ArrayList<>();
        sleepAmount = 30;
    }
    
    public abstract int checkIfGameEnds();
    
    public int run() {
        
        int state = 0;
        
        while(state == 0) {
            
            updateObjects();
            
            drawObjects();
            
            addObjects();
            
            removeObjects();
            
            sleep();
            
            state = checkIfGameEnds();
            
        }
        
        return state;
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
    
    public void addObjects() {
        
        for(GameObject obj : addedObjects) {
            gameObjects.add(obj);
            
            if(obj instanceof KeyListener) {
                controlledObjects.add((KeyListener)obj);
            }
        }
        
        addedObjects.clear();
        
    }
    
    public void removeObjects() {
        
        for(GameObject obj : removedObjects) {
            gameObjects.remove(obj);

            if(obj instanceof KeyListener) {
                controlledObjects.remove((KeyListener)obj);
            }
        }

        removedObjects.clear();
    }
    
    public void sleep() {
        
        try {
            Thread.sleep(sleepAmount);
        } catch (InterruptedException ex) {
            Logger.getLogger(HumVsCompGame.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public GameObject createObject(GameObject obj) {
        
        addedObjects.add(obj);
        obj.setGame(this);
        
        return obj;
    }
    
    public void removeObject(GameObject obj) {
        
        removedObjects.add(obj);
        
    }
    
}
