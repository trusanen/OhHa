/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * 
 * Muuri-peliolio. Pallon törmätessä muuri-olioon
 * sen y-nopeus vaihtuu.
 *
 * @author trusanen
 */
public class Wall extends GameObject {
    
    private double width;
    private double height;
    
    /**
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     * @param width Muurin leveys.
     * @param height Muurin korkeus.
     */
    public Wall(double topLeftx, double topLefty, double width, double height) {
        super(topLeftx, topLefty, width, height);
        
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public void collides(GameObject other) {
        
    }
    
}
