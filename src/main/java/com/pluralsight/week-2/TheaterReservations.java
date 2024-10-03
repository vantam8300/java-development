package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt user
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        String date = scanner.nextLine();

        System.out.print("How many tickets would you like? ");
        int ticket = scanner.nextInt();

        // format and parse String to date
        String[] dateArray = date.split("/");
        LocalDate ld = LocalDate.of(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]));

        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate movieDate = LocalDate.parse(ld.toString(), formatter);

        // print
        System.out.printf("%d tickets reserved for %s under %s", ticket, movieDate, name);
    }
}
