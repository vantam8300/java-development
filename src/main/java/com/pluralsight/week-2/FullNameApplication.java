package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {

    static Scanner scanner = new Scanner(System.in);
    static String[] fullNameArray = {};

    public static void main(String[] args) {

        fullNameArray = promptUser();

        printName();
    }
    private static String[] promptUser() {

        // validate
        while (fullNameArray.length < 2) {
            // prompt user
            System.out.println("Please enter your full name");
            String fullName = scanner.nextLine();

            // split the full name
            fullNameArray = fullName.split("\\s");

            if (fullNameArray.length < 2) {
                System.out.println("Invalid input, Please Enter at least first and last name");
            }
        }
        scanner.close();
        return fullNameArray;
    }

    private static void printName() {

        // print first name
        System.out.println("First Name: " + fullNameArray[0]);

        // print middle name
        if (fullNameArray.length >= 3) {

            String middleName = "";
            for (int i=1; i < fullNameArray.length -1; i++) {
                middleName += fullNameArray[i] + " ";
            }

            System.out.println("Middle Name: " + middleName);
        }

        //print last name
        System.out.println("Last Name: " + fullNameArray[fullNameArray.length -1]);
    }
}
