/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pongGUI;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author trusanen
 */
public class GUI extends JFrame implements MouseMotionListener {
    
    PeliPaneeli pp;
    
    public GUI() {
        PeliPaneeli pp = new PeliPaneeli();
        addMouseMotionListener(this);
        add(pp);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Hiiri raahaa.");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Hiiri liikkui.");
    }
    
}
