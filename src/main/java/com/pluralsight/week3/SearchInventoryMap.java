package com.pluralsight.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {
    // the key is the product id, the value is a product object
    static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();

    public static void main(String[] args) {
        // this method loads product objects into inventory
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        boolean searchAgain = true;
        while (searchAgain) {
            System.out.print("What item # are you interested in? ");
            int id = Integer.parseInt(scanner.nextLine());
            Product matchedProduct = inventory.get(id);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("We carry %s and the price is $%.2f\n",
                    matchedProduct.getName(), matchedProduct.getPrice());
            System.out.println("Do you want to search again? \n");

            searchAgain = scanner.nextLine().equalsIgnoreCase("yes");
        }

    }

    private static void loadInventory() {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
            while ((line = br.readLine()) != null ) {
                String[] data = line.split("\\|");
                Product p = new Product(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]));

                inventory.put(p.getId(), p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
