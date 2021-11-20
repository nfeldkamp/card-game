package com.nfeldkamp;

import java.util.Random;


public class MainProgram {

    public static void main(String[] args) {
        //since in same package do not need to import Card

        Deck newDeck = new Deck();
        Deck newDeck2 = new Deck();
        //newGame.nextDeal();
        CardGameGoFish newGame = new CardGameGoFish();
        //CardGameWar newGame = new CardGameWar();
        Deck newDeck3 = new Deck();


//        String apple = "Apple";
//        System.out.println(MainProgram.has271(apple));
//        int number = 1234567129;
//        System.out.println(MainProgram.numberThing(number));



}
//    public static String has271(String str){
//        String result = "";
//        for (int i = str.length() - 1; i >= 0; i--) {
//            result = result + str.substring(i, i + 1);
//        }
//        //APPLE
//        //01234
//        //i = 4 E
//        //i = 3 L
//        //i = 2 P
//        //i = 1 P
//        //i = 0 A
//        return result;
//    }

//    public static int numberThing(int num) {
//        //765 - return largest num
//        String numString = String.valueOf(num);
//        String numbers = "";
//        numbers += num;
//        int highestNum = 0;
//        for(int i = 0; i < numString.length(); i++){
//            if(highestNum < Integer.parseInt(numString.substring(i, i + 1))){
//                highestNum = Integer.parseInt(numString.substring(i, i + 1));
//            }
//        }
//        return highestNum;
//    }

}
