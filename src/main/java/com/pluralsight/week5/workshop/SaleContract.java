package com.pluralsight.week5.workshop;

public class SaleContract extends Contract{
    private boolean wantFinance;

    public SaleContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean wantFinance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.wantFinance = wantFinance;
    }

    @Override
    public String toString() {
        return "SaleContract{" + super.toString() +
                "wantFinance=" + wantFinance +
                '}';
    }

    public double getSalesTax() {
        return super.getVehicleSold().getPrice() * 0.05;
    }

    public double getRecordingFee() {
        return 100;
    }

    public double getProcessingFee() {
        return super.getVehicleSold().getPrice() < 10000 ? 295 : 495;
    }

    public boolean wantFinance() {
        return wantFinance;
    }

    public void setWantFinance(boolean wantFinance) {
        this.wantFinance = wantFinance;
    }

    @Override
    public double getTotalPrice() {
        double originalPrice = super.getVehicleSold().getPrice();

        if (wantFinance) {

            return originalPrice >= 10000 ? (getMonthlyPayment() * 48) : (getMonthlyPayment() * 24);

        } else {
            return originalPrice + getSalesTax() + getProcessingFee() + getRecordingFee();
        }
    }

    @Override
    public double getMonthlyPayment() {
        if (wantFinance) {
            double originalPrice = super.getVehicleSold().getPrice();
            double totalPrice = originalPrice + getSalesTax() + getProcessingFee() + getRecordingFee();
            return originalPrice >= 10000 ? (1.0425 * totalPrice / 48) : (1.0525 * totalPrice /24);
        } else {
            return 0;
        }

    }
}
