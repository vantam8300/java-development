package com.pluralsight.week7;

public class BankAccount implements Valuable{
    private String name;
    private String accountNumber;
    private double balance;

    public BankAccount(double balance, String accountNumber, String name) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public void deposit(double amount) {

    }

    public void withdraw(double amount) {

    }

    @Override
    public double getValue() {
        return 0;
    }
}
