package controller;

import model.JCell;
import model.JUniverse;

/**
 * Created by eroshin on 14.04.2016.
 */
public class JGameController {

    private boolean isGame;
    private JUniverse curUniverse;

    public static final int NUMBER_TO_LIVE_H = 3;
    public static final int NUMBER_TO_LIVE_L = 2;

    public JGameController(int s){
        curUniverse = new JUniverse(s);
        isGame = true;
        curUniverse.initRandom();
    }

    public boolean getIsGame(){return isGame;}

    public JUniverse getCurUniverse(){return curUniverse;}

    public JUniverse liveOneDay(){
        JUniverse bak = new JUniverse(curUniverse.getUniverseSize());

        if (!isGame) {System.out.print("\n==========GAME OVER===============");return null;}

        for (JCell[] mcel: curUniverse.getUniverseField()) {
            for(JCell cel: mcel){
                if(checkCell(cel)) bak.getUniverseField()[cel.getX()][cel.getY()].inverseLive();
            }
        }

        if(checkGameOver(bak)) isGame = false;
        if(isGame)
            curUniverse.setUniverseField(bak.getUniverseField());
        return bak;
    }

    public boolean checkCell(JCell cel){
        JCell[] araound = curUniverse.getArroundCells(cel);
        int liveCount = 0;
        for (JCell c : araound){
            if (c.isLive()) liveCount++;
        }
        if (!cel.isLive() && liveCount==NUMBER_TO_LIVE_H) return true;
        if (cel.isLive() && (liveCount >=NUMBER_TO_LIVE_L && liveCount <=NUMBER_TO_LIVE_H)) return true;
        else return false;
    }



    public boolean checkGameOver(JUniverse bak){
        for(JCell[] cel : bak.getUniverseField())
            for(JCell c : cel)
                if(c.isLive() != curUniverse.getCell(new int[]{c.getX(),c.getY()}).isLive()) return false;
        return true;
    }

}
