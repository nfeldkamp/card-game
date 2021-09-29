package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class DeckForWar extends Deck{
    public List<Integer> scoreValues = new ArrayList<Integer>();//14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
    public int[] newArray = {1, 2, 3};

    public DeckForWar(){
        super("war");
    }




    //    public Deck() {
//        //build deck of 52 cards
//        //array is local to method
//        String[] valueNames = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
//        //for each suit
//        for( String suit : SUITS_FOR_CARDS ) {
//            //for each value
//            for( String valueName : valueNames ) {
//                //declare a new card
//                Card nextCard = new Card(suit, valueName);
//                cards.add(nextCard);
//            }
//        }
//        //washes the new deck
//        shuffle(12);
//    }
}
