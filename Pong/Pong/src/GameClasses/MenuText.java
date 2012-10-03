/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameClasses;

import java.awt.Graphics;

/**
 *
 * @author trusanen
 */
public class MenuText extends GameObject {
    
    private String menuText;
    
    public MenuText(double x, double y, String text) {
        super(x, y);
        
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
