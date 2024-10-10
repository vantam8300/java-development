package com.pluralsight.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
            ArrayList<Product> inventory = getInventory();
            home(inventory);

    }
    public static void home (ArrayList<Product> inventory) {

        System.out.println("1- List all products\n" +
                "2- Lookup a product by its id\n" +
                "3- Find all products within a price range\n" +
                "4- Add a new product\n" +
                "5- Quit the application\n" +
                "Enter command:");

        int option = Integer.parseInt(scanner.nextLine());

        if (option == 1) {
            displayAll(inventory);
            home(inventory);
        } else if (option == 2) {
            lookUpByID(inventory);
            home(inventory);
        } else if (option == 3) {
            lookUpByPrice(inventory);
            home(inventory);
        } else if (option == 4) {
            add(inventory);
            home(inventory);
        } else if (option == 5) {
            System.out.println("Thank you for using application");
        } else {
            System.out.println("you enter invalid number try again: ");
            home(inventory);
        }
    }
    public static void add (ArrayList<Product> inventory) {
        System.out.println("Enter the product ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the product name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the product price: ");
        float price = Float.parseFloat(scanner.nextLine());

        Product p = new Product(id, name, price);
        inventory.add(p);

        System.out.println("product was added successful");
    }

    public static void lookUpByPrice (ArrayList<Product> inventory) {
        System.out.println("Enter the max price: ");
        int max = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the min price: ");
        int min = Integer.parseInt(scanner.nextLine());

        for (Product p : inventory) {
            if (p.getPrice() >= min && p.getPrice() <= max) {
                System.out.printf("id: %d | Name: %s | Price: $%.2f \n", p.getId(), p.getName(), p.getPrice());
            }
        }
    }

    public static void lookUpByID (ArrayList<Product> inventory) {
        System.out.println("Enter the product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product p : inventory) {
            if (p.getId() == id) {
                System.out.printf("id: %d | Name: %s | Price: $%.2f \n", p.getId(), p.getName(), p.getPrice());
            }
        }
    }
    public static void displayAll (ArrayList<Product> inventory) {
        System.out.println("We carry the following inventory: ");
        Collections.sort(inventory, Comparator.comparing(Product::getName));
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d | Name: %s | Price: $%.2f \n", p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));
            while ((line = br.readLine()) != null ) {
                String[] data = line.split("\\|");
                Product p = new Product(Integer.parseInt(data[0]), data[1], Float.parseFloat(data[2]));

                inventory.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
}
