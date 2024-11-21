package com.pluralsight.week7.generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe", 28));
        people.add(new Person("Jane", "Smith", 34));
        people.add(new Person("Emily", "Davis", 22));
        people.add(new Person("Michael", "Brown", 45));
        people.add(new Person("Sarah", "Wilson", 29));
        people.add(new Person("David", "Taylor", 31));
        people.add(new Person("Emma", "Thomas", 26));
        people.add(new Person("James", "Anderson", 39));
        people.add(new Person("Olivia", "Martinez", 24));
        people.add(new Person("William", "Garcia", 50));

        System.out.println("first Name: ");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();

        List<Person> matchList = new ArrayList<>();

        for (Person p : people) {
            if (p.getFirstName().equalsIgnoreCase(inputName)) {
                matchList.add(p);
            }
        }

        for (Person p : matchList) {
            System.out.println(p.toString());
        }

        double average = 0.0;
        for (Person p : people) {
            average += p.getAge();
        }

        System.out.println("average age: " + average/people.size());

        double oldest = Double.MIN_VALUE;
        for (Person p : people) {
            if (p.getAge() > oldest) {
                oldest = p.getAge();
            }
        }

        System.out.println("oldest " + oldest);

        double youngest = Double.MAX_VALUE;
        for (Person p : people) {
            if (p.getAge() < youngest) {
                youngest = p.getAge();
            }
        }

        System.out.println("youngest " + youngest);
    }
}
