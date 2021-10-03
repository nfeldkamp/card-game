package com.nfeldkamp;

import java.util.Scanner;

public class CardGame {

    private static Scanner input = new Scanner(System.in);
    private String players;
    private int playerOneScore;
    private int playerTwoScore;
    private String playerOneName;
    private String playerTwoName;







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
