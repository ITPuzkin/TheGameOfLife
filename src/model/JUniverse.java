package model;

import java.util.HashMap;

/**
 * Created by eroshin on 14.04.2016.
 */
public class JUniverse {

    public static final int NUMBER_AROUND = 8;

    private JCell[][] universeField;
    private int universeSize;

    public JUniverse(int size){
        universeSize = size;
        universeField = new JCell[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                int bak[] = {i,j};
                universeField[i][j] = new JCell(bak);
            }
        }
    }

    public void setUniverseField(JCell[][] un){
        universeField = un;
    }

    public void initRandom(){
        universeField[2][2].inverseLive();
        universeField[2][3].inverseLive();
        universeField[2][4].inverseLive();
        
        universeField[5][6].inverseLive();
        universeField[6][6].inverseLive();
        universeField[7][6].inverseLive();

    }

    public JCell getCell(int[] coord){
        return universeField[coord[0]][coord[1]];
    }

    public int getUniverseSize(){return universeSize;}

    public JCell[] getArroundCells(JCell cel){
        JCell[] bak = new JCell[NUMBER_AROUND];
        bak[0] = getCell(new int[] {getCoordField(cel.getX()-1),getCoordField(cel.getY()-1)});
        bak[1] = getCell(new int[] {getCoordField(cel.getX()-1),getCoordField(cel.getY()+1)});
        bak[2] = getCell(new int[] {getCoordField(cel.getX()-1),getCoordField(cel.getY())});
        bak[3] = getCell(new int[] {getCoordField(cel.getX()+1),getCoordField(cel.getY()-1)});
        bak[4] = getCell(new int[] {getCoordField(cel.getX()+1),getCoordField(cel.getY()+1)});
        bak[5] = getCell(new int[] {getCoordField(cel.getX()+1),getCoordField(cel.getY())});
        bak[6] = getCell(new int[] {getCoordField(cel.getX()),getCoordField(cel.getY()+1)});
        bak[7] = getCell(new int[] {getCoordField(cel.getX()),getCoordField(cel.getY()-1)});
        return bak;
    }

    public int getCoordField(int x){
        if(x < 0) return universeSize + x;
        else if (x < universeSize) return x;
        else return x - universeSize;
    }

    public JCell[][] getUniverseField(){return universeField;}
}
