package org.proyect.hibernatejavafx.javafxcontrollers;

import org.proyect.hibernatejavafx.View;
import org.proyect.hibernatejavafx.ViewSwitcher;

public class MenuController {

    public void toPlayers(){
        ViewSwitcher.switchTo(View.PLAYERS);
    }

    public void toGames(){
        ViewSwitcher.switchTo(View.GAMES);
    }

    public void toVideoGames(){
        ViewSwitcher.switchTo(View.VIDEOGAMES);
    }

}
