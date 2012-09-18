/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

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
        // TODO code application logic here
        
        GUI testi = new GUI();
        testi.setTitle("testiIkkuna");
        testi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testi.setSize(350,250);
        testi.setVisible(true);
        
    }
}
