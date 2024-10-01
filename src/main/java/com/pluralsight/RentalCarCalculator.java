package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your pickup date: ");
        String pickUpDate = scanner.nextLine();

        System.out.println("number of days for rental: ");
        int dayRental = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Whether want a electronic toll tag at $3.95/day (yes/no): ");
        String tollTag = scanner.nextLine();

        System.out.println("Whether want a GPS at $2.95/day (yes/no): ");
        String gps = scanner.nextLine();

        System.out.println("Whether want roadside assistance at $3.95/day (yes/no): ");
        String roadside = scanner.nextLine();

        System.out.println("Please enter your age: ");
        int age = scanner.nextInt();

        float rentalCost = dayRental * 29.99f;
        float optionCost = 0f;

        if (tollTag.equals("yes") || tollTag.equals("Yes")) {
            optionCost += dayRental * 3.95f;
        }

        if (gps.equals("yes") || gps.equals("Yes")) {
            optionCost += dayRental * 2.95f;
        }

        if (roadside.equals("yes") || roadside.equals("Yes")) {
            optionCost += dayRental * 3.95f;
        }

        float underageSurcharge = age < 25 ? rentalCost * 0.3f : 0f;

        float totalCost = rentalCost + optionCost + underageSurcharge;
        System.out.printf("The pickup date is %s. Number of days for rental is %d. The basic car rental is %.2f with options cost is %.2f and underage surcharge is %.2f so the total is %.2f", pickUpDate, dayRental, rentalCost, optionCost, underageSurcharge, totalCost);
    }
}
