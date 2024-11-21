package com.pluralsight.week5.workshop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private DealerShip dealerShip;
    static Scanner scanner = new Scanner(System.in);
    DealershipFileManager fileManager;
    ContractDataManager contractManager;

    // color for the console
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";

    public UserInterface() {
    }

    private void init() {
        fileManager = new DealershipFileManager();
        contractManager = new ContractDataManager();
        this.dealerShip = fileManager.getDealership();
    }

    private static Object promptUser(String message, String type, boolean isOptional) {
        String input;
        while (true) {
            System.out.print(CYAN + message + RESET);
            input = scanner.nextLine();

            switch (type.toLowerCase()) {
                case "string":
                    if (isOptional && input.isEmpty()) {
                        return null;
                    }

                    if (!isOptional && input.isEmpty()) {
                        System.out.println(RED + "Input cannot be empty. Please try again." + RESET);
                    } else {
                        return input;
                    }
                    break;
                case "double":
                    try {
                        double value = Double.parseDouble(input);
                        if (value < 0) {
                            System.out.println(RED + "Amount must be greater than zero." + RESET);
                        } else {
                            return value;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Invalid number format. Please enter a valid amount." + RESET);
                    }
                    break;
                case "int":
                    try {
                        return Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println(RED + "Invalid number format. Please enter a valid integer." + RESET);
                    }
                    break;
                case "date":
                    try {
                        if (!input.isEmpty()) {
                            LocalDate date = LocalDate.parse(input);
                            if (date.isAfter(LocalDate.now())) {
                                System.out.println(RED + "The date cannot be in the future." + RESET);
                            }
                        }
                        return input;
                    } catch (DateTimeParseException e) {
                        System.out.println(RED + "Invalid date format. Please use YYYY-MM-DD." + RESET);
                    }
                    break;
                default:
                    System.out.println(RED + "Invalid input type." + RESET);
            }
        }
    }

    public void display() {
        init();
        boolean exit = false;
        while (!exit) {
            String homeOption = (String) promptUser("1 - Find vehicles within a price range\n" +
                    "2 - Find vehicles By make / model\n" +
                    "3 - Find vehicles by year range\n" +
                    "4 - Find vehicles by color\n" +
                    "5 - Find vehicles by mileage range\n" +
                    "6 - Find vehicles by type (car, truck, SUV, van)\n" +
                    "7 - List All vehicles\n" +
                    "8 - Add a vehicle\n" +
                    "9 - Remove a vehicle\n" +
                    "10 - Sale/Lease Vehicle\n" +
                    "11 - Admin\n" +
                    "99 - Quit\n", "string", false);

            switch (Integer.parseInt(homeOption)) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processSaleLeaseVehicleRequest();
                    break;
                case 11:
                    processAdminRequest();
                    break;
                case 99:
                    System.out.println(CYAN + "Thank you for using application" + RESET);
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
    }

    private void processAdminRequest() {
        AdminInterface admin = new AdminInterface();
        admin.display();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public void processGetByPriceRequest() {
        double min = (double) promptUser("Min Price ", "double", true);
        double max = (double) promptUser("Max Price ", "double", true);
        displayVehicles(dealerShip.getVehicleByPrice(min, max));
    }

    public void processGetByMakeModelRequest() {
        String make = (String) promptUser("Make ", "string", true);
        String model = (String) promptUser("Model ", "string", true);
        displayVehicles(dealerShip.getVehicleByMakeModel(make, model));
    }

    public void processGetByYearRequest() {
        int min = (int) promptUser("Min Year ", "int", true);
        int max = (int) promptUser("Max Year ", "int", true);
        displayVehicles(dealerShip.getVehicleByYear(min, max));
    }

    public void processGetByColorRequest() {
        String color = (String) promptUser("Color ", "string", true);
        displayVehicles(dealerShip.getVehicleByColor(color));
    }

    public void processGetByMileageRequest() {
        int min = (int) promptUser("Min Mileage ", "int", true);
        int max = (int) promptUser("Max Mileage ", "int", true);
        displayVehicles(dealerShip.getVehicleByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest() {
        String type = (String) promptUser("Vehicle Type ", "string", true);
        displayVehicles(dealerShip.getVehicleByType(type));
    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealerShip.getAllVehicle());

    }

    public void processSaleLeaseVehicleRequest() {
        String option = (String) promptUser("Sale or Lease? ", "string", false);
        String name = (String) promptUser("Customer Name? ", "string", false);
        String email = (String) promptUser("Customer Email? ", "string", false);
        int vin = (int) promptUser("Vin? ", "int", false);
        System.out.println("want to fiance? (true/false) ");
        boolean fiance = scanner.nextBoolean();
        scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String ld = LocalDate.now().format(dtf);

        Vehicle vehicle = null;
        for (Vehicle v : dealerShip.getAllVehicle()) {
            if (v.getVin() == vin) {
                vehicle = v;
                dealerShip.removeVehicle(v);
                break;
            }
        }
        Contract c = null;
        if (option.equalsIgnoreCase("sale")) {
            c = new SaleContract(ld, name, email, vehicle, fiance);
        } else if (option.equalsIgnoreCase("lease")) {
            c = new LeaseContract(ld, name, email, vehicle);
        }

        fileManager.saveDealership(dealerShip, false);
        contractManager.saveContract(c);
    }

    public void processAddVehicleRequest() {
        int vin = (int) promptUser("Vin ", "int", false);
        int year = (int) promptUser("Year ", "int", false);
        String make = (String) promptUser("Make ", "string", false);
        String model = (String) promptUser("Model ", "string", false);
        String type = (String) promptUser("Vehicle Type ", "string", false);
        String color = (String) promptUser("Color ", "string", false);
        int odo = (int) promptUser("Odo ", "int", false);
        double price = (double) promptUser("Price ", "double", false);
        Vehicle v = new Vehicle(vin, year, make, model, type, color, odo, price);

        this.dealerShip.addVehicle(v);
        fileManager.saveDealership(dealerShip, true);
    }

    public void processRemoveVehicleRequest() {
        int vin = (int) promptUser("Vin ", "int", false);
        for (Vehicle v : dealerShip.getAllVehicle()) {
            if (v.getVin() == vin) {
                dealerShip.removeVehicle(v);
                break;
            }
        }
        fileManager.saveDealership(dealerShip, false);
    }
}
