package controller;

import model.JUniverse;

/**
 * Created by eroshin on 14.04.2016.
 */
public class JGameController {

    private boolean isGame;
    private JUniverse curUniverse;


    public void liveOneDay(){
        if (!isGame) return;


        if(checkGameOver()) isGame = false;
    }

    public boolean checkGameOver(){
        return false;
    }

}
