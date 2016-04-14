package model;

import java.util.HashMap;

/**
 * Created by eroshin on 14.04.2016.
 */
public class JUniverse {

    private HashMap<int[],JCell> universeField;

    public JUniverse(int size){
        universeField = new HashMap<>(size*size);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++) {
                int bak[] = {i,j};
                universeField.put(bak, new JCell());
            }
        }
    }

    public HashMap<int[],JCell> getArroundCells(int[] coord){
        HashMap<int[],JCell> around = new HashMap<>(8);

    }

    public HashMap<int[],JCell> getUniverseField(){return universeField;}
}
