package com.nfeldkamp;

import java.util.List;
import java.util.Scanner;

public class CardGame {

    private static Scanner input = new Scanner(System.in);
    private int playerOneScore;
    private int playerTwoScore;
    private String playerOneName;
    private String playerTwoName;







    public void makeHand(List<Card> hand, int num, Deck deck){
        for(int i = 0; i < num; i++){
            hand.add(deck.deal());
        }
    }

    public void whoIsWinning(Deck deckName){
        if (this.playerOneScore == this.playerTwoScore) {
            if(deckName.getSize() == 0){
                System.out.println("--------------The Game Has Ended---------------");
                System.out.println("No one has won, it is a draw of: " + playerOneScore);
            } else {
                System.out.println("No one is winning, it is a draw of: " + playerOneScore);
            }
        } else if (this.playerOneScore > this.playerTwoScore) {
            if(deckName.getSize() == 0){
                System.out.println("--------------The Game Has Ended---------------");
                System.out.println(this.playerOneName + " has won with a score of " + playerOneScore);
            } else {
                System.out.println(this.playerOneName + " is winning with a score of " + playerOneScore);
            }
        } else {
            if(deckName.getSize() == 0){
                System.out.println("--------------The Game Has Ended---------------");
                System.out.println(this.playerTwoName + " has won with a score of " + playerTwoScore);
            } else {
                System.out.println(this.playerTwoName + " is winning with a score of " + playerTwoScore);
            }
        }
    }

    public String[] chooseAmountOfPlayers(){
        String[] playerData = new String[3];
        System.out.println("Are there one(1) or two(2) players?: ");
        playerData[0] = input.nextLine();
        if(playerData[0].equals("1")) {
            System.out.println("What is your name?: ");
            playerData[1] = input.nextLine();
            playerData[2] = "Computer Player";
        } else if (playerData[0].equals("2")) {
            System.out.println("What is the name of player one?: ");
            playerData[1] = input.nextLine();
            System.out.println("What is the name of player two?: ");
            playerData[2] = input.nextLine();
        } else {
            System.out.println("Please choose one(1) or two(2) players");
            chooseAmountOfPlayers();
        }
        return playerData;
    }
}
