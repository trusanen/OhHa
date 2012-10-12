/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import CollisionClasses.Rectangle;
import java.awt.Graphics;
import pong.Game;

/**
 * Abstrakti peliolio-yläluokka. Paikkamäärittelyt,
 * nopeusmäärittelyt ja törmäyksentunnistusmäärittelyt.
 *
 * @author trusanen
 */
public abstract class GameObject extends Object {
    
    private static int objectIds = 0;
    
    private int objectId;
    /**
     * Game-olio, joka omistaa tämän olion.
     */
    public Game game;
    /**
     * Vasemman yläkulman x-koordinaatti.
     */
    protected double x;
    /**
     * Vasemman yläkulman y-koordinaatti.
     */
    protected double y;
    /**
     * Vanha, edellisen päivityskierroksen x-koordinaatti.
     */
    protected double oldx;
    /**
     * Vanha, edellisen päivityskierroksen y-koordinaatti.
     */
    protected double oldy;
    /**
     * Nopeus x-suunnassa.
     */
    protected double speedx;
    /**
     * Nopeus y-suunnassa.
     */
    protected double speedy;
    /**
     * Törmäyslogiikan tarvitsema neliö.
     */
    protected Rectangle collisionRectangle;
    
    /**
     * Päivitä-metodi. Tätä kutsutaan kerran pelikierroksessa.
     */
    public abstract void update();
    /**
     *
     * Piirrä-metodi. Tätä kutsutaan kerran pelikierroksessa.
     * 
     * @param g
     */
    public abstract void draw(Graphics g);
    /**
     *
     * Törmäys-metodi. Tätä kutsutaan, kun olio törmää johonkin toiseen
     * olioon.
     * 
     * @param other
     */
    public abstract void collides(GameObject other);
    
    /**
     * 
     * Konstruktori. Tässä törmäysneliön leveys ja korkeus määritellään
     * nolliksi.
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     */
    protected GameObject(double topLeftx, double topLefty) {
        
        setObjectId();
        x = topLeftx;
        y = topLefty;
        oldx = topLeftx;
        oldy = topLefty;
        collisionRectangle = new Rectangle(x, y, 0, 0);
        
    }
    
    /**
     * 
     * Konstruktori.
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     * @param width Olion leveys.
     * @param height Olion korkeus.
     */
    protected GameObject(double topLeftx, double topLefty, double width, double height) {
        
        setObjectId();
        x = topLeftx;
        y = topLefty;
        oldx = topLeftx;
        oldy = topLefty;
        collisionRectangle = new Rectangle(topLeftx, topLefty, width, height);
    }
    
    private void setObjectId() {
        objectId = objectIds;
        objectIds += 1;
    }
    
    /**
     *
     * @return Palauttaa yksilöllisen oliotunnisteen.
     */
    public int getObjectId() {
        return objectId;
    }
    
    /**
     *
     * @return Palauttaa x- ja y-koordinaatit.
     */
    public double[] getCoordinates() {
        
        double[] coordinates = new double[2];
        
        coordinates[0] = x;
        coordinates[1] = y;
        
        return coordinates;
    }
    
    /**
     *
     * @return Palauttaa törmäyksissä tarvittavan neliön.
     */
    public Rectangle getRectangle() {
        return collisionRectangle;
    }
    
    /**
     *
     * @return Palauttaa nopeudet x- ja y-suunnassa.
     */
    public double[] getSpeed() {
        
        double[] speeds = new double[2];
        
        speeds[0] = speedx;
        speeds[1] = speedy;
        
        return speeds;        
    }
    
    /**
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     */
    public void setCoordinates(double topLeftx, double topLefty) {
        x = topLeftx;
        y = topLefty;
    }
    
    /**
     *
     * @param newSpeedx Uusi nopeus x-suunnassa.
     * @param newSpeedy Uusi nopeus y-suunnassa.
     */
    public void setSpeed(double newSpeedx, double newSpeedy) {
        speedx = newSpeedx;
        speedy = newSpeedy;
    }
    
    /**
     *
     * @param rect Uusi törmäyksessä tarvittava neliö.
     */
    public void setRectangle(Rectangle rect) {
        collisionRectangle = rect;
    }
    
    /**
     *
     * @param game Olion omistava Game-olio.
     */
    public void setGame(Game game) {
        this.game = game;
    }
    
    /**
     *
     * Liikuttaa oliota x- ja y-suunnassa vastaavien nopeuksien verran.
     * Liikuttaa myös törmäysneliötä.
     * 
     */
    public void move() {
        oldx = x;
        oldy = y;
        
        x = x + speedx;
        y = y + speedy;
        
        collisionRectangle.move(speedx, speedy);
    }
    
}
