package com.pluralsight;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBuilder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide the following information:");

        System.out.print("Full name: ");
        String name = scanner.nextLine();

        StringBuilder billingAddress = new StringBuilder();
        System.out.print("Billing Street: ");
        billingAddress.append(scanner.nextLine()).append("\n");
        System.out.print("Billing City: ");
        billingAddress.append(scanner.nextLine()).append("\n");
        System.out.print("Billing State: ");
        billingAddress.append(scanner.nextLine()).append("\n");
        System.out.print("Billing Zip: ");
        billingAddress.append(scanner.nextLine()).append("\n");

        StringBuilder shippingAddress = new StringBuilder();
        System.out.print("Shipping Street: ");
        shippingAddress.append(scanner.nextLine()).append("\n");
        System.out.print("Shipping City: ");
        shippingAddress.append(scanner.nextLine()).append("\n");
        System.out.print("Shipping State: ");
        shippingAddress.append(scanner.nextLine()).append("\n");
        System.out.print("Shipping Zip: ");
        shippingAddress.append(scanner.nextLine()).append("\n");

        System.out.println(name + "\nBilling Address:  "+billingAddress + "\nShipping Address: \n" + shippingAddress);

        System.out.println(name + "\nBilling Address:  "+billingAddress.reverse() + "\nShipping Address: \n" + shippingAddress.reverse());



    }
}
