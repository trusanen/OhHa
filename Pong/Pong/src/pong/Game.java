/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.GameObject;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class Game implements Runnable, KeyListener {
    
    public ArrayList<GameObject> gameObjects;
    public ArrayList<KeyListener> controlledObjects;
    public int sleepAmount;
    
    Game() {
        gameObjects = new ArrayList<>();
        controlledObjects = new ArrayList<>();
        sleepAmount = 30;
    }
}
