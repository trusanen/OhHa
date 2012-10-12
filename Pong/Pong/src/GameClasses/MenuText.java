/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 *
 * Tekstiluokka. Piirtää annetun tekstin pelialueelle.
 * 
 * @author trusanen
 */
public class MenuText extends GameObject {
    
    private String menuText;
    
    /**
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     * @param text Piirrettävä teksti.
     */
    public MenuText(double topLeftx, double topLefty, String text) {
        super(topLeftx, topLefty);
        
        menuText = text;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawString(menuText, (int)x, (int)y);
    }

    @Override
    public void collides(GameObject other) {
        
    }
    
}
