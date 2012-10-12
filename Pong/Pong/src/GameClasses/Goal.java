/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * 
 * Maalialue-luokka. Pallon törmätessä maalialue-olioon
 * se palautuu keskelle ja lisää pistemäärää yhdellä.
 *
 * @author trusanen
 */
public class Goal extends GameObject {
    
    private int score;
    private double width;
    private double height;
    
    /**
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     * @param width Maalin leveys.
     * @param height Maalin korkeus.
     */
    public Goal(double topLeftx, double topLefty, double width, double height) {
        super(topLeftx, topLefty, width, height);
        
        this.width = width;
        this.height = height;
        score = 0;
    }
    
    /**
     *
     * @return Palauttaa, kuinka monta maalia tähän maaliin on tehty.
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Lisää pisteitä yhdellä.
     */
    public void score() {
        score += 1;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics g) {
        g.drawString(Integer.toString(score), (int)(x + (width / 2) - 3), (int)(y + (height / 2)));
    }

    @Override
    public void collides(GameObject other) {
        if(other instanceof Ball) {
            score();
        }
    }
    
}
