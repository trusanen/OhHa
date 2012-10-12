/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * Maila-luokka, pelaajien mailojen yläluokka. Sisältää tekoälyn
 * ja mailan toimintalogiikan.
 *
 * @author trusanen
 */
public class Paddle extends GameObject {
    

    private double width;
    private double height;
    private Ball gameBall;
    
    /**
     *
     * @param topLeftx
     * @param topLefty
     * @param width
     * @param height
     */
    public Paddle(double topLeftx, double topLefty, double width, double height) {
        super(topLeftx, topLefty, width, height);
        this.width = width;
        this.height = height;
    }
    
    /**
     *
     * @param topLeftx
     * @param topLefty
     * @param width
     * @param height
     * @param gameBall
     */
    public Paddle(double topLeftx, double topLefty, double width, double height, Ball gameBall) {
        super(topLeftx, topLefty, width, height);
        this.width = width;
        this.height = height;
        this.gameBall = gameBall;
    }
    
    /**
     * Kasvatus-metodi. Kasvattaa mailan ja sen törmäysneliön kokoa 5:llä ja 
     * siirtää sen oikeaan paikkaan, jos se meinaa mennä seinien päälle.
     */
    public void grow() {
        
        if(height < 195) {
            height = height + 5;

            if((y + height) > 255) {
                y = y - ((y + height) - 255);
            }

            collisionRectangle.grow();
        }
    }
    
    private void runAI() {
        if(gameBall != null) {
            if((gameBall.y + (gameBall.getMeasures()[1] / 2)) > (y + (height / 2))) {
                speedy = 2;
            }
            else {
                speedy = -2;
            }
        }
    }

    @Override
    public void update() {
        
        if(!((this instanceof Player1Paddle) || (this instanceof Player2Paddle))) {
            runAI();
        }
        
        move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public void collides(GameObject other) {
        
        if(other instanceof Wall) {
            collidesWithWall((Wall)other);
        }
    }
    
    private void collidesWithWall(Wall other) {
        
            y = oldy;
            collisionRectangle.setCoordinates(x, oldy);
    }
}
