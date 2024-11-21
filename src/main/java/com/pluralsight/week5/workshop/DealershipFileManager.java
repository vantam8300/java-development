package com.pluralsight.week5.workshop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    public DealerShip getDealership() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));

            String line;
            line = br.readLine();

            String[] data = line.split("\\|");

            DealerShip dealerShip = new DealerShip(data[0], data[1], data[2]);

            while((line = br.readLine()) != null) {
                String[] splitData = line.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(splitData[0]), Integer.parseInt(splitData[1]), splitData[2], splitData[3], splitData[4], splitData[5], Integer.parseInt(splitData[6]), Double.parseDouble(splitData[7]));

                dealerShip.addVehicle(vehicle);
            }
            br.close();
            return dealerShip;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership(DealerShip dealerShip, boolean isAdd) {
        try {
            BufferedWriter bw;
            if (isAdd) {
                bw = new BufferedWriter(new FileWriter("inventory.csv", true));
                Vehicle v = dealerShip.getAllVehicle().get(dealerShip.getAllVehicle().size()-1);
                bw.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|"+ v.getModel() + "|"+ v.getVehicleType() + "|"+ v.getColor() + "|"+ v.getOdometer() + "|"+ v.getPrice());
            } else {
                bw = new BufferedWriter(new FileWriter("inventory.csv"));
                String name = dealerShip.getName();
                String address = dealerShip.getAddress();
                String phone = dealerShip.getPhone();
                bw.write(name + "|" + address + "|" + phone);
                bw.newLine();
                List<Vehicle> vehicles = dealerShip.getAllVehicle();
                for (Vehicle v : vehicles) {
                    bw.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|"+ v.getModel() + "|"+ v.getVehicleType() + "|"+ v.getColor() + "|"+ v.getOdometer() + "|"+ v.getPrice());
                    bw.newLine();
                }
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
