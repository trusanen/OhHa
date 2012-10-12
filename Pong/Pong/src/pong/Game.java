/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.GameObject;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pongGUI.GUI;

/**
 * 
 * Abstrakti pelien yläluokka, sisältää pelioliot sekä ohjatut
 * oliot, ajan, jonka logiikka nukkuu yhdessä iteraatiossa sekä
 * yleistä toiminnallisuutta pelilogiikan silmukasta olioiden
 * luomiseen ja tuhoamiseen.
 *
 * @author trusanen
 * 
 */
public abstract class Game implements KeyListener {
    
    /**
     * Graafinen käyttöliittymä.
     */
    protected GUI gameGUI;
    /**
     * Kaikkien peliolioiden lista.
     */
    protected ArrayList<GameObject> gameObjects;
    /**
     * Ohjattujen peliolioiden lista.
     */
    protected ArrayList<KeyListener> controlledObjects;
    /**
     * Pelioliot, jotka ovat juuri tietyllä iteraatiolla luotu.
     */
    protected ArrayList<GameObject> addedObjects;
    /**
     * Pelioliot, jotka ovat juuri tietyllä iteraatiolla tuhottu.
     */
    protected ArrayList<GameObject> removedObjects;
    /**
     * Kuinka paljon pelisilmukka nukkuu joka iteraatiolla.
     */
    protected int sleepAmount;
    
    Game() {
        gameObjects = new ArrayList<>();
        controlledObjects = new ArrayList<>();
        addedObjects = new ArrayList<>();
        removedObjects = new ArrayList<>();
        sleepAmount = 30;
    }
    
    /**
     *
     * @return Palauttaa tilan, johon ohjelma siirtyy pelisilmukan loputtua.
     */
    protected abstract int checkIfGameEnds();
    
    /**
     * 
     * Default pelisilmukka. Normaalisti pelisilmukka etenee seuraavasti:
     * 1. Oliot päivitetään.
     * 2. Oliot piirretään.
     * 3. Luodut oliot siirretään addedObjects-listasta gameObjects listaan.
     * 4. Poistetut oliot poistetaan gameObjects-listasta
     * 5. Tutkitaan, loppuiko peli
     * 6. Nukutaan tietty määrä.
     *
     * @return Silmukka kutsuu checkIfGameEnds()-metodia ja palauttaa siitä saadun tilan.
     * 
     * @see pong.Game#checkIfGameEnds() 
     */
    public int run() {
        
        int state = 0;
        
        while(state == 0) {
            
            updateObjects();
            
            drawObjects();
            
            addObjects();
            
            removeObjects();
            
            state = checkIfGameEnds();
            
            sleep();
            
        }
        
        return state;
    }
            
    private boolean checkCollision(GameObject obj1, GameObject obj2) {
        
        if(obj1.getRectangle().collidesWith(obj2.getRectangle()) || obj2.getRectangle().collidesWith(obj1.getRectangle())) {
            return true;
        }
        return false;
    }
    
    /**
     * Käy läpi kaikki oliot gameObjects listasta, päivittää niiden tilan
     * ja tutkii, törmäävätkö ne.
     */
    protected void updateObjects() {
        
        for(GameObject obj : gameObjects) {

            obj.update();

            for(GameObject other : gameObjects) {
                if(!obj.equals(other) && checkCollision(obj, other)) {
                    obj.collides(other);
                }
            }
        }
    }
    
    /**
     * Käy läpi kaikki oliot gameObjects-listasta ja piirtää ne.
     */
    protected void drawObjects() {
        gameGUI.drawObjects(gameObjects);
    }
    
    /**
     * Käy läpi kaikki oliot addedObjects-listasta ja listää ne gameObjects-listaan.
     * Jos oliota voi ohjata näppäimistöllä, metodi lisää ne myös controlledObjects-listaan.
     */
    protected void addObjects() {
        
        for(GameObject obj : addedObjects) {
            gameObjects.add(obj);
            
            if(obj instanceof KeyListener) {
                controlledObjects.add((KeyListener)obj);
            }
        }
        
        addedObjects.clear();
        
    }
    
    /**
     * Käy läpi kaikki oliot removedObjects-listasta ja poistaa ne gameObjects-listasta.
     * Jos oliota voi ohjata näppäimistöllä, metodi poistaa ne myös controlledObjects-listasta.
     */
    protected void removeObjects() {
        
        for(GameObject obj : removedObjects) {
            gameObjects.remove(obj);

            if(obj instanceof KeyListener) {
                controlledObjects.remove((KeyListener)obj);
            }
        }

        removedObjects.clear();
    }
    
    /**
     * Pysäyttää ohjelman suorituksen hetken ajaksi.
     */
    protected void sleep() {
        
        try {
            Thread.sleep(sleepAmount);
        } catch (InterruptedException ex) {
            Logger.getLogger(HumVsCompGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * Tällä hetkellä tyhjä.
     * 
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /**
     *
     * Käy läpi kaikki oliot controlledObjects-listasta ja ajaa niiden
     * keyPressed-metodin.
     * 
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        for(KeyListener obj : controlledObjects) {
            obj.keyPressed(e);
        }
    }

    /**
     * 
     * Käy läpi kaikki oliot controlledObjects-listasta ja ajaa niiden
     * keyReleased-metodin.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        for(KeyListener obj : controlledObjects) {
            obj.keyReleased(e);
        }
    }
    
    /**
     *
     * Lisää parametrina annetun olion addedObjects-listaan ja asettaa
     * sen game-attribuutiksi tämän olion.
     * 
     * @param obj Uusi, juuri luotu olio.
     * @return Palauttaa parametrina annetun olion
     */
    public GameObject createObject(GameObject obj) {
        
        addedObjects.add(obj);
        obj.setGame(this);
        
        return obj;
    }
    
    /**
     *
     * Lisää parametrina annetun olion removedObjects-listaan.
     * 
     * @param obj
     */
    public void removeObject(GameObject obj) {
        
        removedObjects.add(obj);
        
    }
}
