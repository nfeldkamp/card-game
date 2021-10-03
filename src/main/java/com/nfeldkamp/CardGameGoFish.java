package com.nfeldkamp;

import java.util.Scanner;

public class CardGameGoFish extends CardGame {
    private static Scanner input = new Scanner(System.in);
    private Card playerOneHand;
    private Card playerTwoCard;
    private String playerOneName;
    private String playerTwoName;
    private int playerOneScore;
    private int playerTwoScore;
    private String players;
    private Deck newDeck = new Deck();


    //constructor
    public CardGameGoFish(){
        System.out.println("-------------WELCOME TO-------------");
        System.out.println("  _____         ______ _     _     ");
        System.out.println(" / ____|       |  ____(_)   | |    ");
        System.out.println("| |  __  ___   | |__   _ ___| |__  ");
        System.out.println("| | |_ |/ _ \\  |  __| | / __| '_ \\ ");
        System.out.println("| |__| | (_) | | |    | \\__ \\ | | |");
        System.out.println(" \\_____|\\___/  |_|    |_|___/_| |_|");
        chooseAmountOfPlayers();
        System.out.println("To put the first cards down press enter!");
        while(input.nextLine().equals("")) {
            if (this.newDeck.getSize() >= 2) {
                System.out.println("Press enter to face-off again.");
                newDeal();
            } else
                System.out.println("Thanks for playing!");
        }
    }

    public void newDeal(){
        if(newDeck.getSize() != 0) {

        }
    }
    //2 players 7 cards dealt, remaining face down in a draw pile
    //randomly choose first player
    //ask player if they have a specific card rank
    //if they have one or more you can ask again
    //if they don't have any - Go Fish
    //draw top card
    //if you draw the card you asked for, show it and get another turn
    //once you have 4 of the same rank/number, put them down on table
    //play continues till someone has no card or deck is empty
    //winner is one with most sets of four
}
