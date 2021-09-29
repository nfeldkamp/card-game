package com.techelevator;

import java.util.Random;

public class MainProgram {

    public static void main(String[] args){
        //since in same package do not need to import Card

        Deck newDeck = new Deck();
        Deck newDeck2 = new Deck();
        CardGameWar newGame = new CardGameWar();
        newGame.nextDeal();

    }
}
