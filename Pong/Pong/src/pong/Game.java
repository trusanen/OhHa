/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author trusanen
 */
public abstract class Game implements Runnable {
    
    public ArrayList<GameObject> gameObjects;
    public int sleepAmount;
    public JFrame frame;
    
    Game() {
        gameObjects = new ArrayList<>();
        sleepAmount = 30;
    }

}
