package com.pluralsight.week6;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<Asset> myList = new ArrayList<>();
        Asset h1 = new House(800000, "10/28/2024", "my house", "123 abc street", 1, 2000, 5000);
        Asset h2 = new House(800000, "10/28/2024", "my house2", "456 abc street", 1, 2000, 5000);

        Asset v1 = new Vehicles(30000, "01/01/2020", "my car", "toyota", 2020, 30000);
        Asset v2 = new Vehicles(50000, "01/01/2020", "my car2", "bmw", 2020, 30000);

        myList.add(h1);
        myList.add(h2);
        myList.add(v1);
        myList.add(v2);

        for (Asset a : myList) {
            System.out.println(a.toString());
        }
    }
}
