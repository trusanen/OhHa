/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.Ball;
import GameClasses.Bonus;
import GameClasses.Goal;
import GameClasses.Player1Paddle;
import GameClasses.Player2Paddle;
import GameClasses.Wall;
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
    public int run() {
        
        int state = 0;
        
        while(state == 0) {
            
            if(Math.random() < 0.1) {
                createObject(new Bonus(130 + Math.random()*235, 60 + Math.random()*130, 10, 10));
            }
            
            updateObjects();
            
            drawObjects();
            
            addObjects();
            
            removeObjects();
            
            sleep();
            
            state = checkIfGameEnds();
            
        }
        
        return state;
    }
    
    @Override
    public int checkIfGameEnds() {
        
        if(player1Goal.getScore() > 20 || player2Goal.getScore() > 20) {
            return 1;
        }
        
        return 0;
    }
    
}
