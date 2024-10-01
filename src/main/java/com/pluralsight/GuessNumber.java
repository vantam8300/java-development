package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Integer> guesses = new ArrayList<Integer>();

    public static void main(String[] args) {
        int randomNum = generateRandom();
        guess(randomNum);
        printResult(guesses, randomNum);
    }

    private static void printResult(ArrayList<Integer> guesses, int randomNum) {
        try {
            FileWriter fw = new FileWriter("test.txt");

            fw.write("You guessed: ");

            for(int guess : guesses) {
                fw.write(guess + " ");
            }

            fw.write("\nnumber of guess: ");
            fw.write(guesses.size() + " \n");

            fw.write("Correct Number is " + randomNum);

            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void guess(int randomNum) {
        while (true) {
            System.out.print("Please guess a number: ");

            if (!scanner.hasNextInt()) {
                System.out.println("invalid input. Please try again");
                scanner.next();
                continue;
            }

            int guessNum = scanner.nextInt();

            guesses.add(guessNum);

            if (guessNum < randomNum) {
                System.out.println("your guess number is smaller than the random number");
            } else if (guessNum > randomNum) {
                System.out.println("your guess number is greater than the random number");
            } else {
                System.out.println("it's correct");
                if (guesses.size() < 5) {
                    System.out.println("you are awesome");
                }
                scanner.close();

                return;
            }
        }
    }

    private static int generateRandom () {
        Random random = new Random();
        return random.nextInt(10);
    }

}
