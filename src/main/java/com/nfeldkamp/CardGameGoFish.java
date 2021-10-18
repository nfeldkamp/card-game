package com.nfeldkamp;

import java.util.*;

public class CardGameGoFish extends CardGame {
    private static Scanner input = new Scanner(System.in);
    private List<Card> playerOneHand = new ArrayList<>();
    private List<Card> playerTwoHand = new ArrayList<>();
    private String playerOneName;
    private String playerTwoName;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String[] playerData;
    private String players;
    private String inquiringCard = "";
    int[] scoresGoFish = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private Deck newDeck = new Deck(scoresGoFish);


    //constructor
    public CardGameGoFish(){
        System.out.println("-------------WELCOME TO-------------");
        //https://ascii.co.uk/text
        System.out.println("  _____         ______ _     _     ");
        System.out.println(" / ____|       |  ____(_)   | |    ");
        System.out.println("| |  __  ___   | |__   _ ___| |__  ");
        System.out.println("| | |_ |/ _ \\  |  __| | / __| '_ \\ ");
        System.out.println("| |__| | (_) | | |    | \\__ \\ | | |");
        System.out.println(" \\_____|\\___/  |_|    |_|___/_| |_|");
        playerData = chooseAmountOfPlayers();
        playerOneName = playerData[1];
        playerTwoName = playerData[2];
        makeHand(playerOneHand, 7, newDeck);
        makeHand(playerTwoHand, 7, newDeck);
        System.out.println(playerOneName + " your starting hand is.");
        nextTurn();
        while(input.nextLine().equals("")) {
            if (this.newDeck.getSize() >= 2) {
                System.out.println("Press enter to start your next turn.");
                nextTurn();
            } else
                System.out.println("Thanks for playing!");
        }
    }

    public void nextTurn(){
        //TODO randomly choose first player to go
        //TODO make this handle both turns with one set of code; current turn and not turn or whatever
        if(newDeck.getSize() != 0) {
            String currentHand = "";
            Collections.sort(playerOneHand, new SortbyScore());
            for (Card card : playerOneHand){
                currentHand += "[" + card.getFaceValue() + " of " + card.getSuit() + "]  ";
            }
            System.out.println(currentHand);
        }
        System.out.println("Which card would you like to inquire about?(Enter number(1) or First letter(A)");
        inquiringCard = input.nextLine();
        if(newDeck.isValid(inquiringCard)) {
            System.out.println("Hey, " + playerTwoName + " do you have any " + inquiringCard + "s?");
            if(cardInHand(inquiringCard, playerTwoHand)){
                //TODO does player have to give all of the card inquired about or just 1?
                //TODO change this sout if so
                //TODO can ask again if they have one of the card you want
                System.out.println("Hey, " + playerOneName + " I happen to have a " + inquiringCard + ".");
                //switch card between p1 and p2
                tradeCard(inquiringCard, playerOneHand, playerTwoHand);
                //checks for 4 of a kind
                if(isFourOfAKind(inquiringCard, playerOneHand)){
                    //TODO add score system for reply
                    System.out.println(
                            "You place four " + inquiringCard + " on the table, and now have "
                                    + playerOneScore + " sets of four"
                    );
                }

            } else {
                System.out.println("Hey, " + playerOneName + " GO FISH!");
                playerOneHand.add(newDeck.deal(1));
                //shows card if card drawn matches card looking for
                //get another turn
                if(playerOneHand.get(playerOneHand.size() - 1).getFaceValue().equals(inquiringCard)){
                    //TODO add ASCII art here
                    System.out.println("You caught the fish! Go again!");
                    System.out.println(
                            "You show your new card " + "[" + playerOneHand.get(playerOneHand.size() - 1).getFaceValue() +
                                    " of " + playerOneHand.get(playerOneHand.size() - 1).getSuit() + "]  "
                    );
                    nextTurn();
                }
                //checks for 4 of a kind
                isFourOfAKind(playerOneHand.get(playerOneHand.size() - 1).getFaceValue(), playerOneHand);
                //TODO show score? maybe only if it is more than 0? not sure
            }
            //TODO add discard
            nextTurn();

            //check for empty string, maybe check for card values? - done - test
            //add computer hand check for inquiring card - done - test
            //add sout return yes/no - test
            //remove from their hand if yes - handle still
            //add draw if no - test
            //check for 4 of a kind on both? dunno?
            //craft computer turn - make this do both, alternate players
            //go back to start next turn
        }
        System.out.println("Please choose a valid card:");
        nextTurn();
    }

    public Boolean cardInHand(String cardName, List<Card> playerHand){//check if card in hand
        for(Card card: playerHand){
            if(card.getFaceValue().equals(cardName)){
                return true;
            }
        }
        return false;
    }

    public void tradeCard(String cardName, List<Card> playerHandToAddTo, List<Card> playerHandToRemoveFrom){//check if card in hand
        for(Card card: playerHandToRemoveFrom){
            if(card.getFaceValue().equals(cardName)){
                playerHandToRemoveFrom.remove(card);
                playerHandToAddTo.add(card);
                break;
            }
        }
    }

    //FIXME Not working
    public boolean isFourOfAKind(String cardName, List<Card> playerHandToCheck){//check if card in hand
        int numberOfMatches = Collections.frequency(playerHandToCheck, cardName);
        if (numberOfMatches == 4) {
            for (Card card : playerHandToCheck) {
                if (card.getFaceValue().equals(cardName)) {
                    playerHandToCheck.remove(card);
                }
            }
            playerOneScore += 1;
            return true;
        }
        return false;
    }

    class SortbyScore implements Comparator<Card>
    {
        // Used for sorting in ascending order of
        // scoreValue
        public int compare(Card a, Card b)
        {
            return a.getScoreValue() - b.getScoreValue();
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
