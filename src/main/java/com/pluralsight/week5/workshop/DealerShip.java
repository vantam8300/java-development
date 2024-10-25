package com.pluralsight.week5.workshop;


import java.util.ArrayList;
import java.util.List;

public class DealerShip {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle>  inventory;

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        return null;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        return null;
    }

    public List<Vehicle> getVehicleByYear(int min, int max) {
        return null;
    }

    public List<Vehicle> getVehicleByColor(String color) {
        return null;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        return null;
    }

    public List<Vehicle> getVehicleByType(String vehicleType) {
        return null;
    }

    public List<Vehicle> getAllVehicle() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
    }

    public DealerShip(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }
}
