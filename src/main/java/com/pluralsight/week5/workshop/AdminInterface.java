package com.pluralsight.week5.workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AdminInterface {
    AdminFileManager adminManager;
    ContractDataManager contractManager;
    ArrayList<Contract> contracts;
    HashMap<String, String> accounts;
    Scanner scanner = new Scanner(System.in);
    public AdminInterface() {

    }
    public void init() {
        adminManager = new AdminFileManager();
        contractManager = new ContractDataManager();
        contracts = contractManager.getContracts();
        accounts = adminManager.getAccounts();
    }

    public void display() {
        init();
        boolean found = login();
        if (found) {
            boolean exit = false;
            while (!exit) {
                System.out.print("1 - List All Contracts\n" +
                        "99 - back");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        processGetContractsRequest();
                        break;
                    case 99:
                        exit = true;
                        break;
                    default:
                        System.out.println("You enter invalid input please try again!!!");
                }
            }
        }
    }
    private void displayContracts(List<Contract> contracts) {
        for (Contract c : contracts) {
            System.out.println(c);
        }
    }
    private void processGetContractsRequest() {
        displayContracts(contracts);
    }

    public boolean login() {
        boolean match = false;
        boolean tryAgain = true;
        while (!match && tryAgain) {
            System.out.print("user name: ");
            String name = scanner.nextLine();
            System.out.print("password: ");
            String password = scanner.nextLine();

            for (String acc : accounts.keySet()) {
                if (acc.equals(name) && accounts.get(acc).equals(password)) {
                    match = true;
                }
            }

            if (!match) {
                System.out.println("incorrect user name or password");
                System.out.println("want to try again (true/false)");
                tryAgain = scanner.nextBoolean();
                scanner.nextLine();
            }
        }


        return match;
    }


}
