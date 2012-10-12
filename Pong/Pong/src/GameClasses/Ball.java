/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 * 
 * Pallo-luokka. Sisältää pelipallon toimintalogiikan.
 *
 * @author trusanen
 */
public class Ball extends GameObject {
    
    private Paddle owner;
    private double width;
    private double height;
    private static int numberOfBalls = 0;
    
    /**
     * 
     *
     * @param topLeftx Uusi vasemman yläkulman x-koordinaatti.
     * @param topLefty Uusi vasemman yläkulman y-koordinaatti.
     * @param width Pallon leveys.
     * @param height Pallon korkeus
     */
    public Ball(double topLeftx, double topLefty, double width, double height) {
        
        super(topLeftx, topLefty, width, height);
        numberOfBalls += 1;
        
        this.width = width;
        this.height = height;
        
        randomizeStartingSpeed();
        
    }
    
    /**
     *
     * @return Viimeksi palloon osunut maila, voi olla myös NULL.
     */
    public Paddle getOwner() {
        return owner;
    }
    
    /**
     *
     * @return Pallon mitat, leveys ja korkeus.
     */
    public double[] getMeasures() {
        
        double[] ballMeasures = new double[2];
        
        ballMeasures[0] = width;
        ballMeasures[1] = height;
        
        return ballMeasures;
    }
    
    /**
     *
     * @return Kuinka monta palloa on pelissä?
     */
    public int getNumberOfBalls() {
        return numberOfBalls;
    }
    
    /**
     * 
     * Laittaa pallojen määräksi nolla, kun peli loppuu.
     *
     */
    public static void clearNumberOfBalls() {
        numberOfBalls = 0;
    }
    
    private void randomizeStartingSpeed() {
        
        double rnd = Math.random();
        
        if(rnd < 0.5) {
            speedx = 2.5;
        }
        else {
            speedx = -2.5;
        }
            
        if(rnd < 0.5) {
            speedy = Math.random() * 2;
        }
        else {
            speedy = -Math.random() * 2;
        }
        
    }
    
    /**
     *
     */
    public void createParticle() {
        
        Particle particle = new Particle(x + (Math.random() * width), y + (Math.random() * height));
        
        game.createObject(particle);
        
        particle.setSpeed(-(0.5 * speedx - 0.1) + Math.random() * 0.2, -(0.5 * speedy - 0.1) + Math.random() * 0.2);
        
    }
    
    /**
     *
     * @param other
     * @return
     */
    public double calculateBounceAngle(GameObject other) {
        
        double othery = other.getRectangle().getCoordinates()[1];
        double otherHeight = other.getRectangle().getCoordinates()[3];
        
        if(speedy < 0) {

            return 0.1 * ( y + (height/2) - 
                    (othery + (otherHeight/2)));
        }
        else {
            return 0.1 * ( y + (height/2) - 
                    (othery + (otherHeight/2)));
        }
        
    }
    
    /**
     *
     * @return
     */
    public double changeXDirection() {
        
        if(speedx > 0) {
            return -speedx - 0.2;
        }
        else {
            return -speedx + 0.2;
        }
        
    }
    
    /**
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.drawOval((int)x, (int)y, (int)width, (int)height);
    }

    /**
     *
     */
    @Override
    public void update() {
        move();
        
        if(Math.random() < 0.5) {
            createParticle();
        }
    }

    /**
     *
     * @param other
     */
    @Override
    public void collides(GameObject other) {
        
        if(!((other instanceof Bonus) || (other instanceof Ball) || (other instanceof Particle))) {
            
            x = oldx;
            y = oldy;

            collisionRectangle.setCoordinates(oldx, oldy);

            if(other instanceof Paddle) {

                collideWithPaddle((Paddle)other);

            }
            if(other instanceof Wall) {
                
                collideWithWall((Wall)other);

            }
            if(other instanceof Goal) {
                
                collideWithGoal((Goal)other);

            }
        }
    }
    
    private void collideWithPaddle(Paddle other) {
        
        speedx = changeXDirection();
        speedy = calculateBounceAngle(other);

        owner = (Paddle)other;        
        
    }
    
    private void collideWithWall(Wall other) {
        
        x = oldx;
        y = oldy;

        collisionRectangle.setCoordinates(oldx, oldy);

        speedy = -speedy;
        
    }
    
    private void collideWithGoal(Goal other) {
        
        other.collides(this);

        if(numberOfBalls < 2) {

            setCoordinates(250, 145);
            collisionRectangle.setCoordinates(250, 145);

            randomizeStartingSpeed();
            
        }
        else {
            numberOfBalls -= 1;
            game.removeObject(this);
        }
        
    }
}
