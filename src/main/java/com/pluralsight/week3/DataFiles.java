package com.pluralsight.week3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataFiles {
    public static void main(String[] args) {
        try {

            System.out.println("Enter the name of a story:");
            Scanner scanner = new Scanner(System.in);
            FileInputStream fis = new FileInputStream(scanner.nextLine());
            Scanner fileScanner = new Scanner(fis);

            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
