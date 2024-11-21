package com.pluralsight.week6;

public class Vehicle {
    String color;
    int numberOfPassengers;
    int cargoCapacity;
    int fuelCapacity;

    public Vehicle(int fuelCapacity, int cargoCapacity, int numberOfPassengers, String color) {
        this.fuelCapacity = fuelCapacity;
        this.cargoCapacity = cargoCapacity;
        this.numberOfPassengers = numberOfPassengers;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
}
