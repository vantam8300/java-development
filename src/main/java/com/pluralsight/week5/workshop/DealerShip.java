package com.pluralsight.week5.workshop;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DealerShip {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle>  inventory;

    public List<Vehicle> getVehicleByPrice(double min, double max) {
        return inventory.stream().filter(vehicle -> vehicle.getPrice() >= min && vehicle.getPrice() <= max).collect(Collectors.toList());
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {

        return inventory.stream().filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)).collect(Collectors.toList());
    }

    public List<Vehicle> getVehicleByYear(int min, int max) {
        return inventory.stream().filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max).collect(Collectors.toList());
    }

    public List<Vehicle> getVehicleByColor(String color) {

        return inventory.stream().filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        return inventory.stream().filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max).collect(Collectors.toList());
    }

    public List<Vehicle> getVehicleByType(String vehicleType) {
        return inventory.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType)).collect(Collectors.toList());
    }

    public List<Vehicle> getAllVehicle() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public DealerShip(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
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
