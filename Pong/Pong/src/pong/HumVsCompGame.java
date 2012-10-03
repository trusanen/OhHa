/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.Ball;
import GameClasses.GameObject;
import GameClasses.Goal;
import GameClasses.Paddle;
import GameClasses.Player1Paddle;
import GameClasses.Wall;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import pongGUI.GUI;

/**
 *
 * Pelaaja vastaan tietokone -peli.
 * 
 * @author trusanen
 */
public class HumVsCompGame extends Game {

    private Goal player1Goal;
    private Goal player2Goal;
    
    HumVsCompGame(GUI newGameGUI) {
        super();
        gameGUI = newGameGUI;
        
        Ball gameBall = new Ball(250, 145, 10, 10);
        
        Player1Paddle player1 = new Player1Paddle(100, 125, 10, 50);
        Paddle player2 = new Paddle(395, 125, 10, 50, gameBall);
        
        player1Goal = new Goal(80, 50, 10, 210);
        player2Goal = new Goal(415, 50, 10, 210);
        
        gameObjects.add(gameBall);
        gameObjects.add(player1);
        gameObjects.add(player2);
        gameObjects.add(new Wall(100, 50, 305, 5));
        gameObjects.add(new Wall(100, 255, 305, 5));
        gameObjects.add(player1Goal);
        gameObjects.add(player2Goal);
        
        controlledObjects.add(player1);
        
    }
    
    @Override
    public int checkIfGameEnds() {
        
        if(player1Goal.getScore() > 4 || player2Goal.getScore() > 4) {
            return 1;
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
