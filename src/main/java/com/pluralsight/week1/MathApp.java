package com.pluralsight.week1;

public class MathApp {
    public static void main(String[] args) {
        //1
        float bobSalary = 100_000f;
        float garySalary = 50_000f;
        float highestSalary = Math.max(bobSalary, garySalary);
        System.out.println("the highest salary is " + highestSalary);

        //2
        float carPrice = 100_000f;
        float trucPrice = 110_000f;
        float smallestPrice = Math.min(carPrice, trucPrice);
        System.out.println("the smallest price is " + smallestPrice);

        //3
        float radius = 7.25f;
        float areaCircle = (float) Math.PI * radius * radius;
        System.out.println("the area of the circle is " + areaCircle);

        //4
        System.out.println("the result of square root of 5.0 is " + Math.sqrt(5.0f));

        //5
        double distance2Points = Math.sqrt(Math.pow(85-5, 2) + Math.pow(50-10, 2));
        System.out.println("distance between (5,0) and (85,50) is " + distance2Points);

        //6
        System.out.println("absolute value of -3.8 is " + Math.abs(-3.8f));

        //7
        System.out.println("random number from 0 to 1: " + Math.random());
    }
}
