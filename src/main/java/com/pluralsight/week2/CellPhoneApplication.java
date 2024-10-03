package com.pluralsight.week2;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CellPhone myCellPhone = new CellPhone();

        System.out.println("What is the serial number?");
        myCellPhone.setSerialNumber(scanner.nextInt());
        scanner.nextLine();

        System.out.println("What model is the phone?");
        myCellPhone.setModel(scanner.nextLine());

        System.out.println("Who is the carrier?");
        myCellPhone.setCarrier(scanner.nextLine());

        System.out.println("What is the phone number?");
        myCellPhone.setPhoneNumber(scanner.nextLine());

        System.out.println("Who is the owner of the phone?");
        myCellPhone.setOwner(scanner.nextLine());

        System.out.println(myCellPhone.getSerialNumber());
        System.out.println(myCellPhone.getPhoneNumber());
        System.out.println(myCellPhone.getCarrier());
        System.out.println(myCellPhone.getModel());
        System.out.println(myCellPhone.getOwner());
    }
}
