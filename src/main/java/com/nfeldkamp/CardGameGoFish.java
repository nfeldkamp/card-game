package com.nfeldkamp;

import java.util.*;

public class CardGameGoFish extends CardGame {
    private static Scanner input = new Scanner(System.in);
    private List<Card> playerOneHand = new ArrayList<>();
    private List<Card> playerTwoHand = new ArrayList<>();
    private List<Card> currentHand;
    private List<Card> notCurrentHand;
    private String playerOneName;
    private String playerTwoName;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String[] playerData;
    private String inquiringCard = "";
    private String otherPlayer;
    int[] scoresGoFish = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private Deck newDeck = new Deck(scoresGoFish);
    private String currentPlayer;
    private Random rand = new Random();
    private int startingPlayer = rand.nextInt(2);



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
        //TODO show starting hand?
        nextTurn();
        while(input.nextLine().equals("")) {
            if (this.newDeck.getSize() >= 2) {
                System.out.println("Press enter to start your next turn.");
                nextTurn();
            } else
                System.out.println("Thanks for playing!");
        }
    }

//    public void nextTurn(){
//        //TODO need to check that deck isn't empty, and if it is tally score and say who wins
//        //add score system
//        if(playerOneScore != 0 || playerTwoScore != 0){
//            System.out.println("Current Score: " + playerOneName + ": " + playerOneScore
//                    + " | " + playerTwoName + ": " + playerTwoScore);
//        }
//        //randomly choose first player to go
//        Random rand = new Random();
//        //if (rand.nextInt(2) == 1)
//        //TODO make this handle both turns with one set of code; current turn and not turn or whatever
//        if(newDeck.getSize() != 0) {
//            String currentHand = "";
//            Collections.sort(playerOneHand, new SortbyScore());
//            for (Card card : playerOneHand){
//                currentHand += "[" + card.getFaceValue() + " of " + card.getSuit() + "]  ";
//            }
//            System.out.println(currentHand);
//        }
//        System.out.println("Which card would you like to inquire about?(Enter number(1) or First letter(A)");
//        inquiringCard = input.nextLine();
//        if(newDeck.isValid(inquiringCard)) {
//            System.out.println("Hey, " + playerTwoName + " do you have any " + inquiringCard + "s?");
//            if(cardInHand(inquiringCard, playerTwoHand)){
//                //TODO does player have to give all of the card inquired about or just 1?
//                //TODO change this sout if so
//                //TODO can ask again if they have one of the card you want
//                System.out.println("Hey, " + playerOneName + " I happen to have a " + inquiringCard + ".");
//                //switch card between p1 and p2
//                tradeCard(inquiringCard, playerOneHand, playerTwoHand);
//                //checks for 4 of a kind
//                isFourOfAKind(playerOneHand);
//            } else {
//                System.out.println("Hey, " + playerOneName + " GO FISH!");
//                playerOneHand.add(newDeck.deal(1));
//                //shows card if card drawn matches card looking for
//                //get another turn
//                if(playerOneHand.get(playerOneHand.size() - 1).getFaceValue().equals(inquiringCard)){
//                    //ASCII art here
//                    System.out.println("                                                        .");
//                    System.out.println("            ___---\"\"\"\"\"\"\"\"\"\"\"\"\"\"---____                / |");
//                    System.out.println("       _--\"\"   \\)))))))))))))))))))))))\"\"\"\"\"___       /  |");
//                    System.out.println("    _-\" _       \\))))))_-\"|))))))))))))))))))))\"\"\"---' __|");
//                    System.out.println(" _-\"   / \\       |))))|   |)))))))))))))))))))))))))/--  |");
//                    System.out.println("<___.  \\_/       |))))|   |))))))))))))))))))))))))<-    |");
//                    System.out.println(" \"-_             |))))|   |)))))))))))))))))))))))))\\--__|");
//                    System.out.println("    \"-_         /)))))) -_|))))))))))))))))))))___---.   |");
//                    System.out.println("       \"--__   /)))))))))))))))))))))))_____\"\"\"       \\  |");
//                    System.out.println("            \"\"\"---______________---\"\"\"\"                \\ |");
//                    System.out.println("                                                        '");
//                    System.out.println("You caught the fish! Go again!");
//                    System.out.println(
//                            "You show your new card " + "[" + playerOneHand.get(playerOneHand.size() - 1).getFaceValue() +
//                                    " of " + playerOneHand.get(playerOneHand.size() - 1).getSuit() + "]  "
//                    );
//                    isFourOfAKind(playerOneHand);
//                    nextTurn();
//                }
//                //checks for 4 of a kind
//                isFourOfAKind(playerOneHand);
//            }
//            nextTurn();
//
//            //check for empty string, maybe check for card values? - done - test
//            //add computer hand check for inquiring card - done - test
//            //add sout return yes/no - test
//            //remove from their hand if yes - handle still
//            //add draw if no - test
//            //check for 4 of a kind on both? dunno?
//            //craft computer turn - make this do both, alternate players
//            //go back to start next turn
//        }
//        System.out.println("Please choose a valid card:");
//        nextTurn();
//    }

    public void nextTurn(){
        //add score system
        if(playerOneScore != 0 || playerTwoScore != 0){
            System.out.println("Current Score: " + playerOneName + ": " + playerOneScore
                    + " | " + playerTwoName + ": " + playerTwoScore);
        }
        //randomly choose first player to go

        //TODO handle better
        //TODO add color ie: Computer Player turn: <make this red and say who goes first
        if (startingPlayer == 0){
            currentHand = playerOneHand;
            notCurrentHand = playerTwoHand;
            otherPlayer = playerTwoName;
            currentPlayer = playerOneName;
        } else {
            currentHand = playerTwoHand;
            notCurrentHand = playerOneHand;
            otherPlayer = playerOneName;
            currentPlayer = playerTwoName;
        }
        //TODO make this handle both turns with one set of code; current turn and not turn or whatever
        //TODO need to check that deck isn't empty, and if it is tally score and say who wins - Working?
        if(playerData[0].equals("1") && currentHand == playerOneHand || playerData[0].equals("2")) {
            System.out.println(currentPlayer + " your hand is:");
            if (newDeck.getSize() != 0) {
                String sortedHand = "";
                Collections.sort(currentHand, new SortbyScore());
                for (Card card : currentHand) {
                    sortedHand += "[" + card.getFaceValue() + " of " + card.getSuit() + "]  ";
                }
                System.out.println(sortedHand);
                System.out.println("Which card would you like to inquire about?(Enter number(1) or First letter(A)");
                inquiringCard = input.nextLine();
            }
        } else {
            System.out.println("The computer player has " + playerTwoHand.size() + " cards, and they are face down.");
            inquiringCard = String.valueOf(rand.nextInt(playerTwoHand.size()));
        }

        if(newDeck.isValid(inquiringCard)) {
            System.out.println("Hey, " + otherPlayer + " do you have any " + inquiringCard + "s?");
            if(cardInHand(inquiringCard, notCurrentHand)){
                //TODO does player have to give all of the card inquired about or just 1?
                //TODO change this sout if so
                //TODO can ask again if they have one of the card you want
                System.out.println("Hey, " + currentPlayer + " I happen to have a " + inquiringCard + ".\n");
                //switch card between p1 and p2
                tradeCard(inquiringCard, currentHand, notCurrentHand);
                //checks for 4 of a kind
                isFourOfAKind(currentHand);
            } else {
                System.out.println("Hey, " + currentPlayer + " GO FISH!\n");
                currentHand.add(newDeck.deal(1));
                //shows card if card drawn matches card looking for
                //get another turn
                if(currentHand.get(currentHand.size() - 1).getFaceValue().equals(inquiringCard)){
                    //ASCII art here
                    System.out.println("                                                        .");
                    System.out.println("            ___---\"\"\"\"\"\"\"\"\"\"\"\"\"\"---____                / |");
                    System.out.println("       _--\"\"   \\)))))))))))))))))))))))\"\"\"\"\"___       /  |");
                    System.out.println("    _-\" _       \\))))))_-\"|))))))))))))))))))))\"\"\"---' __|");
                    System.out.println(" _-\"   / \\       |))))|   |)))))))))))))))))))))))))/--  |");
                    System.out.println("<___.  \\_/       |))))|   |))))))))))))))))))))))))<-    |");
                    System.out.println(" \"-_             |))))|   |)))))))))))))))))))))))))\\--__|");
                    System.out.println("    \"-_         /)))))) -_|))))))))))))))))))))___---.   |");
                    System.out.println("       \"--__   /)))))))))))))))))))))))_____\"\"\"       \\  |");
                    System.out.println("            \"\"\"---______________---\"\"\"\"                \\ |");
                    System.out.println("                                                        '");
                    System.out.println("You caught the fish! Go again!");
                    System.out.println(
                            "You show your new card " + "[" + currentHand.get(currentHand.size() - 1).getFaceValue() +
                                    " of " + currentHand.get(currentHand.size() - 1).getSuit() + "]  "
                    );
                }
                isFourOfAKind(currentHand);
            }
            if (startingPlayer == 0){
                startingPlayer = 1;
            } else {
                startingPlayer = 0;
            }
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

    //FIXME Working?
    public boolean isFourOfAKind(List<Card> playerHandToCheck){//check if card in hand
            List<Integer> cardIndexes = new ArrayList<>();
            String cardName = playerOneHand.get(playerOneHand.size() - 1).getFaceValue();
            for (Card card : playerHandToCheck) {
                if (card.getFaceValue().equals(cardName)) {
                    cardIndexes.add(playerHandToCheck.indexOf(card));
                }
                if(cardIndexes.size() == 4) {
                    playerHandToCheck.remove(cardIndexes.get(0));
                    playerHandToCheck.remove((cardIndexes.get(1)) - 1);
                    playerHandToCheck.remove((cardIndexes.get(2)) - 2);
                    playerHandToCheck.remove((cardIndexes.get(3)) - 3);
                    playerOneScore ++;
                    System.out.println(
                            "You place four " + inquiringCard + "s on the table, and now have "
                                    + playerOneScore + " set(s) of four cards."
                    );
                    return true;
                }
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


