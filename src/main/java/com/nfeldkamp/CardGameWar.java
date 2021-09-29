package com.techelevator;

import java.util.SortedMap;

public class CardGameWar {
    //attribs
    private Card playerOneCard;
    private Card playerTwoCard;
    private int playerOneScore;
    private int playerTwoScore;
    private Card computerCard;
    private int players;
    private DeckForWar newDeck = new DeckForWar();

    //constructor
    public CardGameWar(){
        System.out.println("----------WELCOME TO WAR----------");
    }


    //methods
    //need to add input for player count at some point then iterate through based on computer or two players
    //need to check if cards left in deck, stop if empty and evaluate scoring
    //need to make some sort of system to cont. dealing
    public void nextDeal(){
        this.playerOneCard = newDeck.deal();
        this.playerTwoCard = newDeck.deal();;
        System.out.println("Player One's card: " + playerOneCard);
        System.out.println("Player Two's card: " + playerTwoCard);
        if (this.playerOneCard.getScoreValue() == this.playerTwoCard.getScoreValue()){
            thisIsWar();
        }else if (this.playerOneCard.getScoreValue() > this.playerTwoCard.getScoreValue()) {
            //need to add scoring
            playerOneScore += 2;
            System.out.println("Player One wins this draw");
        } else {
            System.out.println("Player Two wins this draw");
            playerTwoScore += 2;
        }
    }

    public void thisIsWar(){
        this.playerOneCard = newDeck.deal();
        this.playerTwoCard = newDeck.deal();
        System.out.println("-------------THIS IS WAR!-------------");
        newDeck.deal(3);
        System.out.println("Player One: One, Two, Three, Flip");
        System.out.println("Player One's card: " + newDeck.deal());
        newDeck.deal(3);
        System.out.println("Player One: One, Two, Three, Flip");
        System.out.println("Player Two's card: " + newDeck.deal());
        if (this.playerOneCard.getScoreValue() == this.playerTwoCard.getScoreValue()){
            System.out.println("----------------DOUBLE----------------");
            thisIsWar();
        }else if (this.playerOneCard.getScoreValue() > this.playerTwoCard.getScoreValue()) {
            //need to add scoring
            playerOneScore += 8;
            System.out.println("Player One wins this draw");
        } else {
            System.out.println("Player Two wins this draw");
            playerTwoScore += 8;
        }
    }

}
