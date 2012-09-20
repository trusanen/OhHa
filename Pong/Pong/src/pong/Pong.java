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
 *
 * @author trusanen
 */
public class Pong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GUI gameGUI = new GUI();
        Game gameLogic = new HumVsCompGame(gameGUI);

        JDialog dialog = new JDialog();
        dialog.add(gameGUI);
        
        dialog.setSize(300, 100);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            System.exit(0);
            }
        });

        dialog.setVisible(true);
        
        Thread logicThread = new Thread(gameLogic);
        
        logicThread.start();
        
    }
}
