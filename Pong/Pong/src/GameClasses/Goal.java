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
    
    public Goal(double newx, double newy, double width, double height) {
        super(newx, newy, width, height);
        this.width = width;
        this.height = height;
        score = 0;
    }
    
    public int getScore() {
        return score;
    }
    
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
