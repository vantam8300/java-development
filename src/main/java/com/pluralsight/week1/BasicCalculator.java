package com.pluralsight.week1;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Enter the Second number: ");
        int secondNum = scanner.nextInt();

        System.out.println("Possible calculations: ");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultify");
        System.out.println("(D)ivide");

        String operation = scanner.next();

        System.out.println("Please select an option: " + operation);
        System.out.println(operation);
        int result = 0;
        String sign = "";
        switch (operation) {
            case "A":
                result = firstNum + secondNum;
                sign = "+";
                break;
            case "S":
                result = firstNum - secondNum;
                sign = "-";
                break;
            case "M":
                result = firstNum * secondNum;
                sign = "*";
                break;
            case "D":
                result = firstNum / secondNum;
                sign = "/";
                break;
            default:
                throw new IllegalArgumentException("Invalid Operation");
        }

        System.out.println(firstNum + " " + sign + " " + secondNum + " = " + result);
    }
}

