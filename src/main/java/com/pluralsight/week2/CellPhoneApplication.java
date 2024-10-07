package com.pluralsight.week2;

import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {

        CellPhone myCellPhone1 = new CellPhone();

        CellPhone myCellPhone2 = new CellPhone();

        CellPhoneApplication.display(myCellPhone1);

        CellPhoneApplication.display(myCellPhone2);

        myCellPhone1.dial(myCellPhone2.getPhoneNumber());

        myCellPhone2.dial(myCellPhone1.getPhoneNumber());
    }

    public static void display (CellPhone phone) {
        System.out.println(phone.getSerialNumber());
        System.out.println(phone.getPhoneNumber());
        System.out.println(phone.getCarrier());
        System.out.println(phone.getModel());
        System.out.println(phone.getOwner());
    }

}
