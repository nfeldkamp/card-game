package com.nfeldkamp;

import java.util.ArrayList;
import java.util.List;

public class DeckForWar extends Deck{
    public List<Integer> scoreValues = new ArrayList<Integer>();//14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13

    public DeckForWar(){
        super("war");
    }

}
