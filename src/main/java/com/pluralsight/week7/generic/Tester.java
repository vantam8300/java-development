package com.pluralsight.week7.generic;

public class Tester <T, U>{
    private T[] prop1;
    private U prop2;

    public Tester(T[] prop1, U prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }

    public <T extends Number> double getAverge(T[] numbers) {
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }

        return sum / numbers.length;
    }

    public void printT() {
        System.out.println(prop1);
    }

    public void printU() {
        System.out.println(prop2);
    }


    public T[] getProp1() {
        return prop1;
    }

    public void setProp1(T[] prop1) {
        this.prop1 = prop1;
    }

    public U getProp2() {
        return prop2;
    }

    public void setProp2(U prop2) {
        this.prop2 = prop2;
    }
}
