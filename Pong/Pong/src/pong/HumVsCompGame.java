/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.Ball;
import GameClasses.Goal;
import GameClasses.Paddle;
import GameClasses.Player1Paddle;
import GameClasses.Wall;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pongGUI.GUI;

/**
 *
 * Pelaaja vastaan tietokone -peli.
 * 
 * @author trusanen
 */
public class HumVsCompGame extends Game {

    private double fieldx;
    private double fieldy;
    private double fieldWidth;
    private double fieldHeight;
    
    private Goal player1Goal;
    private Goal player2Goal;
    
    HumVsCompGame(GUI newGameGUI) {
        super();
        gameGUI = newGameGUI;
        Ball.clearNumberOfBalls();
        
        fieldx = 100;
        fieldy = 50;
        fieldWidth = 200;
        fieldHeight = 200;
        
        Ball gameBall = (Ball)createObject(new Ball(250, 145, 10, 10));
        
        createObject(new Player1Paddle(100, 125, 10, 50));
        createObject(new Paddle(395, 125, 10, 50, gameBall));
        
        player1Goal = (Goal)createObject(new Goal(80, 50, 10, 210));
        player2Goal = (Goal)createObject(new Goal(415, 50, 10, 210));
        
        createObject(new Wall(100, 50, 305, 5));
        createObject(new Wall(100, 255, 305, 5));
        
    }
    
    public double[] getFieldMeasures() {
        
        double[] measures = new double[4];
        
        measures[0] = fieldx;
        measures[1] = fieldy;
        measures[2] = fieldWidth;
        measures[3] = fieldHeight;
        
        return measures;
    }
    
    @Override
    protected int checkIfGameEnds() {
        
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
