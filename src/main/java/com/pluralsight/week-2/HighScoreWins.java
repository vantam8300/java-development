package com.pluralsight;

import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a game score: ");
        String input = scanner.nextLine();

        // split
        String[] firstSplit = input.split("\\|");
        String[] names = firstSplit[0].split(":");
        String[] scores = firstSplit[1].split(":");

        // compare and print
        int firstScore =  Integer.parseInt(scores[0]);
        int secondScore =  Integer.parseInt(scores[1]);
        if (firstScore > secondScore) {
            System.out.println("Winner: " + names[0]);
        } else if (firstScore < secondScore) {
            System.out.println("Winner: " + names[1]);
        } else {
            System.out.println("Tie");
        }
    }
}
