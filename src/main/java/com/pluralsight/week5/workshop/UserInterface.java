package com.pluralsight.week5.workshop;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private DealerShip dealerShip;
    static Scanner scanner = new Scanner(System.in);
    // color for the console
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String MAGENTA = "\u001B[35m";
    static final String CYAN = "\u001B[36m";

    public UserInterface() {
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
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
            String homeOption = (String) promptUser("1 - Find vehicles within a price range" +
                    "2 - Find vehicles By make / model\n" +
                    "3 - Find vehicles by year range\n" +
                    "4 - Find vehicles by color\n" +
                    "5 - Find vehicles by mileage range\n" +
                    "6 - Find vehicles by type (car, truck, SUV, van)\n" +
                    "7 - List All vehicles\n" +
                    "8 - Add a vehicle\n" +
                    "9 - Remove a vehicle\n" +
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
                case 99:
                    System.out.println(CYAN + "Thank you for using application" + RESET);
                    exit = true;
                    break;
                default:
                    System.out.println(RED + "You enter invalid input please try again!!!" + RESET);
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {

    }

    public void processAddVehicleRequest() {
        displayVehicles(dealerShip.getAllVehicle());
    }

    public void processRemoveVehicleRequest() {

    }
}
