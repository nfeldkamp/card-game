package com.nfeldkamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    //attribs

    //static final makes it constant, not part of every instance of this class
    //available for use in deck class
    public static final String[] SUITS_FOR_CARDS = {"HEARTS", "CLUBS", "SPADES", "DIAMONDS"};
    //no one can access this list directly to add cards
    private List<Card> cards = new ArrayList<>();//have to instantiate to ArrayList or it will give null exception
    private boolean newDeck = true;
    private int[] warScoreValues = {14, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private int[] defaultScoreValues = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    //constructors
    //overridden default constructor
    public Deck(String game) {
        //build deck of 52 cards
        //array is local to method
        int[] scoreValues = new int[13];
        if(game.equals("war")){
            scoreValues = warScoreValues;
        } else {
            scoreValues = defaultScoreValues;
        }
        String[] valueNames = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //for each suit
        for( String suit : SUITS_FOR_CARDS ) {
            //for each value
            for( int i = 0; i < valueNames.length; i++ ) {//need to add score here somehow
                //declare a new card
                    Card nextCard = new Card(suit, valueNames[i], scoreValues[i]);
                    cards.add(nextCard);
                }
            }
        //washes the new deck
        shuffle(12);
    }

    public Deck() {
        //build deck of 52 cards
        //array is local to method
        String[] valueNames = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //for each suit
        for( String suit : SUITS_FOR_CARDS ) {
            //for each value
            for( String valueName : valueNames ) {
                //declare a new card
                Card nextCard = new Card(suit, valueName);
                cards.add(nextCard);
            }
        }
        //washes the new deck
        shuffle(12);
    }

    //methods
public List randomDeckToShuffle(List<Card> deckToShuffle) {
    Random rand = new Random();
    //randomizes the cards to shuffle
    List<Card> firstHalf = new ArrayList<>();
    List<Card> secondHalf = new ArrayList<>();
    List<Card> bothHalves = new ArrayList<>();
    rand.nextInt(52);
    //firstHalf = this.cards.get(0); //needs to be rand.ints - rand.ints + 25
    for (int i = rand.nextInt(52); bothHalves.size() < 52; i++){
        if(firstHalf.size() < 26){//makes a first half cut of deck of 26 cards
        firstHalf.add(deckToShuffle.get(i));
        } else if (secondHalf.size() < 26){//makes a second half cut of deck of 26 cards
            secondHalf.add(deckToShuffle.get(i));
        } else { //adds first and second half to cards to shuffle
            bothHalves.addAll(firstHalf);
            bothHalves.addAll(secondHalf);

        }
        if(i == 51){//loops the index around if it goes past index that exists to add new cards
            i = 0;
        }
    }
    return bothHalves;
}

    //need to only allow a shuffle of 52 cards - if not full, need a new deck
    public List shuffle(int shuffleCount) {
        if (this.cards.size() == 52) {
            for (int j = 0; j <= shuffleCount; j++) {
                List<Card> randomDeck = randomDeckToShuffle(this.cards);
                List<Card> shuffledDeck = new ArrayList<>();
                for (int i = 0; i < (randomDeck.size() / 2) + 1; i++) {//this.cards.size() if(this.cards.size() > 51
                    shuffledDeck.add(randomDeck.get(i));//1-26
                    if ((randomDeck.size() / 2) > (i + 1)) {
                        shuffledDeck.add(randomDeck.get(((randomDeck.size() / 2) + 1) + i)); //27-52
                    }
                }
                this.cards = shuffledDeck;
            }
        }
        return this.cards;
    }

    //need to only allow a shuffle of 52 cards - if not full, need a new deck
    public List shuffle() {
        if (this.cards.size() == 52) {
            List<Card> shuffledDeck = new ArrayList<>();
            for (int i = 0; i < (this.cards.size() / 2) + 1; i++) {
                shuffledDeck.add(this.cards.get(i));//1-26
                if ((this.cards.size() / 2) > (i + 1)) {
                    shuffledDeck.add(this.cards.get(((this.cards.size() / 2) + 1) + i)); //27-52
                }
            }
            this.cards = shuffledDeck;
        }
        return this.cards;
    }

    public Card deal() {
        this.cards.get(0).flip();
        return cards.remove(0);
    }
    public Card deal(int cardsToDeal) {
        for (int i = 0; i < cardsToDeal; i++) {
            this.cards.get(0).flip();
            return cards.remove(0);
        }
        return this.cards.get(0);
    }

    public Card dealFacedown(){
        return cards.remove(0);
    }

    public int getSize(){
        return this.cards.size();
    }
}
