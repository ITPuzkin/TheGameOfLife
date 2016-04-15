package model;

/**
 * Created by eroshin on 14.04.2016.
 */
public class JCell {


    private int[] coord;
    private boolean live;

    public JCell(int [] c){
        coord = c;
    }

    public boolean isLive(){return live;}
    public int getX(){return coord[0];}
    public int getY(){return coord[1];}

    public void inverseLive(){live=!live;}
}
