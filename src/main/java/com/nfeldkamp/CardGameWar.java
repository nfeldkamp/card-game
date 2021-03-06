package com.nfeldkamp;

import java.util.Scanner;

public class CardGameWar {
    //attribs
    private static Scanner input = new Scanner(System.in);
    private Card playerOneCard;
    private Card playerTwoCard;
    private String playerOneName;
    private String playerTwoName;
    private int playerOneScore;
    private int playerTwoScore;
    private String players;
    int[] scoresForWar = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private Deck newDeck = new Deck(scoresForWar);

    //constructor
    public CardGameWar(){
        System.out.println("-------------WELCOME TO-------------");
        System.out.println("8b      db      d8 ,adPPYYba, 8b,dPPYba,  ");
        System.out.println("`8b    d88b    d8' \"\"     `Y8 88P'   \"Y8  ");
        System.out.println(" `8b  d8'`8b  d8'  ,adPPPPP88 88          ");
        System.out.println("  `8bd8'  `8bd8'   88,    ,88 88          ");
        System.out.println("    YP      YP     `\"8bbdP\"Y8 88 ");
        chooseAmountOfPlayers();
        System.out.println("To put the first cards down press enter!");
        while(input.nextLine().equals("")) {
            if (this.newDeck.getSize() >= 2) {
                System.out.println("Press enter to face-off again.");
                nextDeal();
            } else
                System.out.println("Thanks for playing!");
        }
    }


    //methods
    //need to add input for player count at some point then iterate through based on computer or two players
    //need to check if cards left in deck, stop if empty and evaluate scoring
    //need to make some sort of system to cont. dealing
    public void nextDeal(){
        if(newDeck.getSize() != 0) {
            this.playerOneCard = newDeck.deal();
            this.playerTwoCard = newDeck.deal();
            System.out.println(this.playerOneName + "'s card: " + playerOneCard);
            System.out.println(this.playerTwoName + "'s card: " + playerTwoCard);
            if (this.playerOneCard.getScoreValue() == this.playerTwoCard.getScoreValue()) {
                thisIsWar();
            } else if (this.playerOneCard.getScoreValue() > this.playerTwoCard.getScoreValue()) {
                //need to add scoring
                playerOneScore += 2;
                System.out.println(this.playerOneName + " wins this draw");
                whoIsWinning();
            } else {
                System.out.println(this.playerTwoName + " wins this draw");
                playerTwoScore += 2;
                whoIsWinning();
            }
        }
    }

    public void thisIsWar(){
        //need to add amount of card check here - if not enough end game? use what is there? dunno
        this.playerOneCard = newDeck.deal();
        this.playerTwoCard = newDeck.deal();
        System.out.println("-------------THIS IS WAR!-------------");
        System.out.println("        (  o)");
        System.out.println("      ????????????????????? ]???????????????????????????   ???     ??? ");
        System.out.println(" ???????????????????????????????????????????????????                 ");
        System.out.println("I?????????????????????????????????????????????????????????].");
        System.out.println(" ?????????????????????????????????????????????...");

        if(newDeck.getSize() > 4 && newDeck.getSize() < 8){
            newDeck.deal((newDeck.getSize() / 2) - 1);
        } else if (newDeck.getSize() >= 8) {
            newDeck.deal(3);
        }
        System.out.println(this.playerOneName + ": One, Two, Three, Flip");
        System.out.println(this.playerOneName + "'s card: " + newDeck.deal());
        if(newDeck.getSize() > 2 && newDeck.getSize() < 4){
            newDeck.deal(newDeck.getSize() - 1);
        }else if (newDeck.getSize() >= 4) {
            newDeck.deal(3);
        }
        System.out.println(this.playerTwoName + ": One, Two, Three, Flip");
        System.out.println(this.playerTwoName +"'s card: " + newDeck.deal());
        if(newDeck.getSize() > 2){
        if (this.playerOneCard.getScoreValue() == this.playerTwoCard.getScoreValue()) {
            System.out.println("----------------DOUBLE----------------");
            thisIsWar();
        } else {
            whoIsWinning();
        }
        }else if (this.playerOneCard.getScoreValue() > this.playerTwoCard.getScoreValue()) {
            //need to add scoring
            playerOneScore += 8;
            System.out.println(this.playerOneName + " wins this draw");
            whoIsWinning();
        } else {
            System.out.println(this.playerTwoName + " wins this draw");
            playerTwoScore += 8;
            whoIsWinning();
        }
    }

    public void whoIsWinning(){
        if (this.playerOneScore == this.playerTwoScore) {
            if(newDeck.getSize() == 0){
                System.out.println("--------------The Game Has Ended---------------");
                System.out.println("No one has won, it is a draw of: " + playerOneScore);
            } else {
                System.out.println("No one is winning, it is a draw of: " + playerOneScore);
            }
        } else if (this.playerOneScore > this.playerTwoScore) {
            if(newDeck.getSize() == 0){
                System.out.println("--------------The Game Has Ended---------------");
                System.out.println(this.playerOneName + " has won with a score of " + playerOneScore);
            } else {
                System.out.println(this.playerOneName + " is winning with a score of " + playerOneScore);
            }
        } else {
                if(newDeck.getSize() == 0){
                    System.out.println("--------------The Game Has Ended---------------");
                    System.out.println(this.playerTwoName + " has won with a score of " + playerTwoScore);
                } else {
                    System.out.println(this.playerTwoName + " is winning with a score of " + playerTwoScore);
                }
        }
    }

    public void chooseAmountOfPlayers(){
        System.out.println("Are there one(1) or two(2) players?: ");
        this.players = input.nextLine();
        if(this.players.equals("1")) {
            System.out.println("What is your name?: ");
            this.playerOneName = input.nextLine();
            this.playerTwoName = "Computer Player";
        } else if (this.players.equals("2")) {
            System.out.println("What is the name of player one?: ");
            this.playerOneName = input.nextLine();
            System.out.println("What is the name of player two?: ");
            this.playerTwoName = input.nextLine();
        } else {
            System.out.println("Please choose one(1) or two(2) players");
            chooseAmountOfPlayers();
        }
    }

}
