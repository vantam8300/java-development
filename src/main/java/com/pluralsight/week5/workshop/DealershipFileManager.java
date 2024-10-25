package com.pluralsight.week5.workshop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

            return dealerShip;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership(DealerShip dealerShip) {

    }
}
