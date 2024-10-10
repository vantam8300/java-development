package com.pluralsight.week3;


import java.util.Random;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        // Create an array of 10 favorite quotes
        String[] quotes = new String[10];
        quotes[0] = "The only limit to our realization of tomorrow is our doubts of today.";
        quotes[1] = "Success is not final, failure is not fatal: It is the courage to continue that counts.";
        quotes[2] = "The way to get started is to quit talking and begin doing.";
        quotes[3] = "In the end, we will remember not the words of our enemies, but the silence of our friends.";
        quotes[4] = "The purpose of our lives is to be happy.";
        quotes[5] = "Life is what happens when you're busy making other plans.";
        quotes[6] = "Get busy living or get busy dying.";
        quotes[7] = "You have within you right now, everything you need to deal with whatever the world can throw at you.";
        quotes[8] = "Believe you can and you're halfway there.";
        quotes[9] = "Don't watch the clock; do what it does. Keep going.";

        // Initialize the scanner
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean keepGoing = true;

        // Loop to allow multiple quote selections
        while (keepGoing) {
            System.out.println("\nSelect a number between 1 and 10 to see a quote or type 0 for a random quote:");
            try {
                // Get user input
                int userChoice = scanner.nextInt();

                // Display random quote if the user selects 0
                if (userChoice == 0) {
                    int randomIndex = random.nextInt(10);
                    System.out.println("Random Quote: " + quotes[randomIndex]);
                }
                // Check if the input is within the valid range
                else if (userChoice >= 1 && userChoice <= 10) {
                    System.out.println("Quote: " + quotes[userChoice - 1]);
                }
                // Handle out of bounds input
                else {
                    System.out.println("Please enter a valid number between 1 and 10.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 10.");
                scanner.next(); // Clear invalid input from scanner
            }

            // Ask the user if they want to see another quote
            System.out.println("\nDo you want to see another quote? (yes/no)");
            String userResponse = scanner.next().toLowerCase();
            if (!userResponse.equals("yes")) {
                keepGoing = false;
            }
        }

        System.out.println("Goodbye!");
        scanner.close();

    }
}
