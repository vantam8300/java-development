package com.pluralsight.week2;

import java.util.Scanner;

public class CellPhone {
    private int serialNumber;
    private String model;
    private String carrier;
    private String phoneNumber;
    private String owner;

    public CellPhone() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the serial number?");
        this.serialNumber = scanner.nextInt();
        scanner.nextLine();


        System.out.println("What model is the phone?");
        this.setModel(scanner.nextLine());

        System.out.println("Who is the carrier?");
        this.setCarrier(scanner.nextLine());

        System.out.println("What is the phone number?");
        this.setPhoneNumber(scanner.nextLine());

        System.out.println("Who is the owner of the phone?");
        this.setOwner(scanner.nextLine());
    }

    public void dial(String phoneNumber) {
        System.out.println(this.getOwner() + "'s phone is calling " + phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
