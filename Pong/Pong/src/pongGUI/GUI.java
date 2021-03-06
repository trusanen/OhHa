/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongGUI;

import GameClasses.GameObject;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

/**
 * 
 * Käyttöliittymäluokka. Sisältää piirtologiikan.
 *
 * @author trusanen
 */
public class GUI extends JPanel {
    
    private ArrayList<GameObject> gameObjects;
    
    public GUI() {}
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        for(GameObject obj : gameObjects) {
            obj.draw(g);
        }
    }
    
    public void drawObjects(ArrayList newGameObjects) {
        gameObjects = newGameObjects;
        repaint();
    }
    
}
