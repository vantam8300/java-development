package com.pluralsight.week5.workshop;

public abstract class Contract {
    private String Date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    private double totalPrice;
    private double monthlyPayment;

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

    @Override
    public String toString() {
        return
                "Date='" + Date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicleSold=" + vehicleSold +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment
                ;
    }

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        Date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}
