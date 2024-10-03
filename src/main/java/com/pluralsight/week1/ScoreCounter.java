package com.pluralsight.week1;

import java.util.Scanner;

public class ScoreCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = 0;

        for (int i=0; i<5; i++) {
            System.out.print("to enter test scores between 1 and 10 ");
            if (scanner.nextInt() > 7) {
                count ++;
            }
        }

        System.out.println("number of scores greater than 7: " + count);


    }
}
