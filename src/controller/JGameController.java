package controller;

import model.JCell;
import model.JUniverse;

/**
 * Created by eroshin on 14.04.2016.
 */
public class JGameController {

    private boolean isGame;
    private JUniverse curUniverse;


    public void liveOneDay(){
        if (!isGame) return;

        for (JCell cel: curUniverse.getUniverseField().values()) {
            checkCell(cel);
        }

        if(checkGameOver()) isGame = false;
    }

    public void checkCell(JCell cel){

    }

    public boolean checkGameOver(){
        return false;
    }

}
