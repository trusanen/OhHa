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
        
        int state = 1;
        
        GUI gameGUI = new GUI();
        Game gameLogic = new HumVsCompGame(gameGUI);

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
        
        state = gameLogic.run();
        
        dialog.dispose();
        
    }

}
