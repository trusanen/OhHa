/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import pongGUI.GUI;


/**
 * Pääluokka, luo pelin ja graafisen käyttöliittymän.
 *
 * @author trusanen
 */
public class Pong {

    /**
     * Pääsilmukka, luo pelin ja graafisen käyttöliittymän, 
     * luo niiden asetukset ja ajaa pelilogiikan.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int state = 0;
        
        GUI gameGUI = new GUI();
        Game gameLogic = new MainMenu(gameGUI);

        JDialog dialog = new JDialog();
        dialog.add(gameGUI);
        
        dialog.setSize(500, 300);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            System.exit(0);
            }
        });
        
        dialog.addKeyListener(gameLogic);
        
        dialog.setVisible(true);
        
        while(state != 4) {
            state = gameLogic.run();
            
            if(state == 1) {
                dialog.removeKeyListener(gameLogic);
                gameLogic = new MainMenu(gameGUI);
                dialog.addKeyListener(gameLogic);
            }
            if(state == 2) {
                dialog.removeKeyListener(gameLogic);
                gameLogic = new HumVsCompGame(gameGUI);
                dialog.addKeyListener(gameLogic);
            }
            if(state == 3) {
                dialog.removeKeyListener(gameLogic);
                gameLogic = new HumVsHumGame(gameGUI);
                dialog.addKeyListener(gameLogic);
            }
        }
        
        dialog.dispose();
        
    }

}
