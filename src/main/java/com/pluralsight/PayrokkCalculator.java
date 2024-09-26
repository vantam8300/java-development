package com.pluralsight;


import java.util.Scanner;

public class PayrokkCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("what's your name: ");
        String name = scanner.nextLine();

        System.out.print("what's your hours worked: ");
        float hours = scanner.nextFloat();

        System.out.print("what's your pay rate: ");
        float payRate = scanner.nextFloat();

        float grossPay = 0f;

        if (hours > 40) {
            float OTHours = hours - 40;
            grossPay = ((40 * payRate) + (OTHours * payRate * 1.5f));
        } else {
            grossPay = (40 * payRate);
        }

        System.out.println("name: " + grossPay);

    }
}
