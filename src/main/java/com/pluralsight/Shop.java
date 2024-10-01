package com.pluralsight;


import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        String[] articles = {"Cheese", "Bread", "Coffee", "Wine"};
        int[] prices = {8, 2, 4, 3};
        Scanner scanner = new Scanner(System.in);
        // print a list of product
        for (int i=0; i< articles.length; i++) {
            System.out.println(i + " " + articles[i]);
        }
        System.out.println("choose a product");
        int product = scanner.nextInt();
        System.out.println("enter an amount");
        int amount = scanner.nextInt();
        int total = prices[product] * amount;
        System.out.println("you bought " + amount + " of " + articles[product] + " with the total was " + total);

    }
}
