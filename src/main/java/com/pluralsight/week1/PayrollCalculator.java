package com.pluralsight.week1;


import java.util.Scanner;

public class PayrollCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String name = getName();

        float hours = getHours();

        float payRate = getPayRate();

        float grossPay = getGrossPay(hours, payRate);

        System.out.println("name: " + name + " " + grossPay);
        scanner.close();
    }
    public static float getGrossPay(float hours, float payRate) {
        float grossPay = 0f;
        if (hours > 40) {
            float OTHours = hours - 40;
            grossPay = ((40 * payRate) + (OTHours * payRate * 1.5f));
        } else {
            grossPay = (40 * payRate);
        }
        return grossPay;
    }
    public static float getHours() {
        System.out.print("what's your hours worked: ");
        return  scanner.nextFloat();
    }

    public static String getName() {
        System.out.print("what's your name: ");
        return scanner.nextLine();
    }

    public static float getPayRate() {
        System.out.print("what's your pay rate: ");
        return  scanner.nextFloat();
    }
}
