/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongGUI;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author trusanen
 */
public class PeliPaneeli extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        
        int alkux, alkuy, loppux, loppuy;
        
        alkux  = (int)(Math.random()*300);
        alkuy  = (int)(Math.random()*200);
        loppux = (int)(Math.random()*300);
        loppuy = (int)(Math.random()*200);

        g.drawRect(0,0,299,199);
        g.drawLine(alkux,alkuy,loppux,loppuy);
        g.drawString("("+alkux+","+alkuy+"),("+loppux+","+loppuy+")",1,12);
        
    }
    
}
