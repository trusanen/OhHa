/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;
import pong.SkitsoGame;

/**
 * 
 * Bonus-luokka. Pallon osuessa bonus-olioon mailan koko kasvaa
 * ja peliin ilmestyy 2 palloa lisää.
 *
 * @author trusanen
 */
public class Bonus extends GameObject {
    
    private double width;
    private double height;
    private double i = 0.0;
    
    /**
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     * @param width Bonuksen leveys.
     * @param height Bonuksen korkeus.
     */
    public Bonus(double topLeftx, double topLefty, double width, double height) {
        super(topLeftx, topLefty, width, height);
        
        this.width = width;
        this.height = height;
    }

    /**
     *
     * Päivitä-metodi. Tässä tapauksessa ei tee mitään.
     * 
     */
    @Override
    public void update() {
        
    }

    /**
     * 
     * Piirto-metodi. Määrittelee, mitä piirretään.
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.drawRoundRect((int)x, (int)y, (int)width, (int)height, 2, 2);
        g.drawRoundRect((int)(x - 2), (int)(y - 2), (int)(width + 4), (int)(height + 4), 3, 3);
    }

    /**
     *
     * Törmäys-metodi. Määrittelee, mitä tapahtuu, kun olio
     * törmää eri olioiden kanssa.
     * 
     * @param other
     */
    @Override
    public void collides(GameObject other) {
        
        if(other instanceof Ball) {
            
            collidesWithBall((Ball)other);

        }
        
    }
    
    private void collidesWithBall(Ball other) {
                    
        Paddle paddle = ((Ball)other).getOwner();

        if(paddle != null && !(game instanceof SkitsoGame)) {
            paddle.grow();
        }

        if(((Ball)other).getNumberOfBalls() < 50) {
            game.createObject(new Ball(x, y, 10, 10));
            game.createObject(new Ball(x, y, 10, 10));
        }
        game.removeObject(this);
        
    }
    
}
