package com.pluralsight.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // create a deck of card and shuffle
        Deck deck = new Deck();
        deck.shuffle();

        // create number of hand
        System.out.print("How many player will be playing this game: ");
        int numbOfHand = Integer.parseInt(scanner.nextLine());
        List<Hand> hands = new ArrayList<>();

        for (int i=0; i<numbOfHand; i++) {
            System.out.print("Enter player's name: ");
            Hand hand = new Hand(scanner.nextLine());
            hands.add(hand);
        }

        // deal 2 card to each hand
        for (int i=0; i<2; i++) {
            for (Hand hand : hands) {
                // get first card in the deck
                Card cardFromDeck = deck.deal();

                // add to player's hand
                hand.deal(cardFromDeck);
            }
        }

        // compare the value
        int max = 0;
        String winner = "";
        for (Hand hand : hands) {
            // display cards each hand
            hand.displayCards();
            // display value
            int initalValue = hand.getValue();
            System.out.println(initalValue + "\n");
            // hit or stay
            boolean hit = true;
            while (hit) {
                if (initalValue > 21) {
                    break;
                }
                System.out.print(hand.getName() + ", do you want to hit or stay? (hit/stay) ");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("hit")) {
                    // get first card in the deck
                    Card cardFromDeck = deck.deal();

                    // add to player's hand
                    hand.deal(cardFromDeck);
                } else {
                    hit = false;
                }

                // display cards each hand
                hand.displayCards();
                // display value
                System.out.println(hand.getValue());
                initalValue = hand.getValue();
            }

            int valueOfHand = hand.getValue();
            if (valueOfHand > max && valueOfHand <= 21) {
                max = valueOfHand;
                winner = hand.getName();
            }
        }

        System.out.println("the winner is: " + winner);
    }
}
