/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import GameClasses.MenuSelection;
import GameClasses.MenuText;
import pongGUI.GUI;

/**
 *
 * @author trusanen
 */
public class MainMenu extends Game {
    
    public MenuSelection selection;
    
    MainMenu(GUI newGameGUI) {
        super();
        
        gameGUI = newGameGUI;
        createObject(new MenuText(100, 100, "1 Pelaajan peli"));
        createObject(new MenuText(100, 150, "2 Pelaajan peli"));
        createObject(new MenuText(100, 200, "Lopeta"));
        selection = (MenuSelection)createObject(new MenuSelection(80, 100));
    }

    @Override
    public int checkIfGameEnds() {
        return selection.getChoice();
    }    
}
