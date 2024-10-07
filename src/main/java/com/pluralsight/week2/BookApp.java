package com.pluralsight.week2;

import java.util.Scanner;

public class BookApp {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // create an array to store 20 books
        Book[] books = new Book[20];

        for (int i=1; i<=20; i++) {
            books[i-1] = new Book(i,"isbn"+i,"Book"+i,false,"");
        }

       home(books);
    }

    public static void checkOut(Book[] books) {
        System.out.println("Enter ID of the book you want to check out: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                book.checkOut(name);
            }
        }
    }

    public static void checkIn(Book[] books) {
        System.out.println("Enter ID of the book you want to check in: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Book book : books) {
            if (book.getId() == id) {
                book.checkIn();
            }
        }
    }
    public static void displayAvailable(Book[] books) {
        System.out.println("Available Books");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("id: " + book.getId() + " ISBN: " + book.getIsbn() + " Title: " + book.getTitle());
            }
        }
    }

    public static void displayCheckedOutBook(Book[] books) {
        System.out.println("Checked Out Books");
        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("id: " + book.getId() + " ISBN: " + book.getIsbn() + " Title: " + book.getTitle());
            }
        }
    }
    public static void home(Book[] books) {
        System.out.println("(1) Show Available Books");
        System.out.println("(2) Show Checked Out Books");
        System.out.println("(3) Exit - closes out of the Application");

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            displayAvailable(books);
            System.out.println("C - to Check Out a book");
            System.out.println("X - to go back to the Home Screen");
            String wantCheckOut = scanner.nextLine();
            if (wantCheckOut.equals("C")) {
                checkOut(books);
                home(books);

            } else if (wantCheckOut.equals("X")) {
                home(books);
            }
        } else if (option == 2) {
                displayCheckedOutBook(books);
                System.out.println("C - to Check In a book");
                System.out.println("X - to go back to the Home Screen");
                String wantCheckIn = scanner.nextLine();
                if (wantCheckIn.equals("C")) {
                    checkIn(books);
                    home(books);

                } else if (wantCheckIn.equals("X")) {
                    home(books);
                }
        } else {
            System.out.println("Thank you for using the application");
        }
    }
}
