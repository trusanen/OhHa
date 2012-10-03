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
    
    private Goal player1Goal;
    private Goal player2Goal;
    
    HumVsHumGame(GUI newGameGUI) {
        super();
        gameGUI = newGameGUI;
        
        createObject(new Ball(250, 145, 10, 10));
        createObject(new Player1Paddle(100, 125, 10, 50));
        createObject(new Player2Paddle(395, 125, 10, 50));
        createObject(new Wall(100, 50, 305, 5));
        createObject(new Wall(100, 255, 305, 5));
        player1Goal = (Goal)createObject(new Goal(80, 50, 20, 210));
        player2Goal = (Goal)createObject(new Goal(405, 50, 20, 210));
        
    }
    
    @Override
    public boolean checkIfGameEnds() {
        
        if(player1Goal.getScore() > 4 || player2Goal.getScore() > 4) {
            return true;
        }
        
        return false;
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
