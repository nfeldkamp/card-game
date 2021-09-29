package com.techelevator;

public class Card {

    //read only if no getter or setter
    //attribs
    private boolean isFaceUp = false;
    private String suit;
    private String color;
    private int scoreValue;
    private String faceValue;

    //constructor - public nameOfClass
    //can make card with no params or code
    //puts card in memory with default attribs
    //if constructor not provided this is what it technically does:
    //    public Card(){
    //
    //    }

    //constructors
    //card is overloaded because there is more than one way to use it
    public Card(String suit, String faceValue) {
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public Card(String suit, String faceValue, int scoreValue) {
        this.suit = suit;
        this.faceValue = faceValue;
        this.scoreValue = scoreValue;
    }

    public boolean flip() {
        this.isFaceUp = !this.isFaceUp;
        return this.isFaceUp;
    }

    //getter/setter
    //can generate getter/setter with right click
    //these methods can see private attribs because it is part of class
    //can write to these attribs because it is inside the card
    //code outside class can only write to public attribs
    //java expects getter/setter and private attribs
    public boolean isFaceUp() {
        return isFaceUp;
    }

    public String getSuit() {
        return suit;
    }

    public String getColor() {
        return color;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    //setting with private attrib, take value named attrib name
    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public String getFaceValue() {
        return faceValue;
    }

   public String toString() {
       if (isFaceUp) {
           return "The " + faceValue + " of " + suit;
       } else {
           return "Card is facedown";
        }
   }
}
