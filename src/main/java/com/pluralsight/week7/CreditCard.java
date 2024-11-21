package com.pluralsight.week7;

public class CreditCard implements Valuable{

    private String name;
    private String accountNumber;
    private double balance;

    public CreditCard(double balance, String accountNumber, String name) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public void charge(double amount) {

    }

    public void pay(double amount) {

    }

    @Override
    public double getValue() {
        return 0;
    }
}
