package model;

/**
 * Created by eroshin on 14.04.2016.
 */
public class JCell {


    private int[] coord;
    private boolean isLive;

    public JCell(int [] c){
        coord = c;
    }

    public int getX(){return coord[0];}
    public int getY(){return coord[1];}

}
