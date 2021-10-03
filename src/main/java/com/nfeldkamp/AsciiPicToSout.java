
package com.nfeldkamp;

import java.util.Scanner;

public class AsciiPicToSout {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("How many lines would you like to enter?: ");
        String[] inputLines = new String[(input.nextInt() + 1)];
        for (int i = 0; i < inputLines.length; i++) {
            inputLines[i] = input.nextLine();
        }

        System.out.println("\n Formatted ascii image for sout: ");
        for (int i = 1; i < inputLines.length; i++) {
            System.out.println("System.out.println(\"" + inputLines[i] + "\");");
        }
    }
}
