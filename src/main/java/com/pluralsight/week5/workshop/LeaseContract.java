package com.pluralsight.week5.workshop;

public class LeaseContract extends Contract{

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public String toString() {
        return "LeaseContract{" + super.toString() +
                "}";
    }

    public double getEndingValue() {
        return super.getVehicleSold().getPrice() * 0.5;
    }

    public double getLeaseFee() {
        return super.getVehicleSold().getPrice() * 0.07;
    }

    @Override
    public double getTotalPrice() {
        return getEndingValue() + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        return 1.04 * getTotalPrice() / 36;
    }
}
