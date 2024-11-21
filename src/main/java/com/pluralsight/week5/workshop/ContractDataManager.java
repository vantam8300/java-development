package com.pluralsight.week5.workshop;

import java.io.*;
import java.util.ArrayList;

public class ContractDataManager {
    public void saveContract (Contract contract) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true));
            bw.newLine();
            if (contract instanceof SaleContract) {
                SaleContract sc = (SaleContract) contract;
                bw.write("SALE|" + sc.getDate() + "|" + sc.getCustomerName() + "|" + sc.getCustomerEmail() + "|" +sc.getVehicleSold().getVin() + "|" + sc.getVehicleSold().getYear() + "|" + sc.getVehicleSold().getMake() + "|" + sc.getVehicleSold().getModel() + "|" + sc.getVehicleSold().getVehicleType() + "|" + sc.getVehicleSold().getColor() + "|" + sc.getVehicleSold().getOdometer() + "|" + sc.getVehicleSold().getPrice() + "|" + sc.getSalesTax() + "|" + sc.getRecordingFee() + "|" + sc.getProcessingFee() + "|" + sc.getTotalPrice() + "|" + (sc.wantFinance() ? "YES" : "NO" ) + "|" + sc.getMonthlyPayment());
            } else if (contract instanceof LeaseContract) {
                LeaseContract lc = (LeaseContract) contract;
                bw.write("LEASE|" + lc.getDate() + "|" + lc.getCustomerName() + "|" + lc.getCustomerEmail() + "|" +lc.getVehicleSold().getVin() + "|" + lc.getVehicleSold().getYear() + "|" + lc.getVehicleSold().getMake() + "|" + lc.getVehicleSold().getModel() + "|" + lc.getVehicleSold().getVehicleType() + "|" + lc.getVehicleSold().getColor() + "|" + lc.getVehicleSold().getOdometer() + "|" + lc.getVehicleSold().getPrice() + "|" + lc.getEndingValue() + "|" + lc.getLeaseFee() + "|" + lc.getTotalPrice() + "|" + lc.getMonthlyPayment());
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Contract> getContracts() {
        try {
            ArrayList<Contract> contracts = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader("contracts.csv"));

            String line;

            while((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                Contract contract = getContract(data);

                contracts.add(contract);
            }
            br.close();
            return contracts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Contract getContract(String[] data) {
        Contract contract = null;
        if (data[0].equals("SALE")) {
            Vehicle vehicle = new Vehicle(Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6], data[7], data[8], data[9], Integer.parseInt(data[10]), Double.parseDouble(data[11]));
            contract = new SaleContract(data[1], data[2], data[3], vehicle, data[16].equals("YES"));
        } else if (data[0].equals("LEASE")) {
            Vehicle vehicle = new Vehicle(Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6], data[7], data[8], data[9], Integer.parseInt(data[10]), Double.parseDouble(data[11]));
            contract = new LeaseContract(data[1], data[2], data[3], vehicle);
        }
        return contract;
    }
}
