package com.pluralsight.week6;

public class Vehicles extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    @Override
    public double getValue() {
        double value = 0;
        if (year <= 3) {
            value = super.getOriginalCost() * 0.03 * year;
        } else if (year <=6) {
            value = super.getOriginalCost() * 0.06 * year;
        } else if (year <= 10) {
            value = super.getOriginalCost() * 0.86 * year;
        } else {
            value = 1000;
        }

        if (!makeModel.contains("Toyota") || !makeModel.contains("Honda")) {
            value *= 0.75;
        }

        return value;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "makeModel='" + makeModel + '\'' +
                ", year=" + year +
                ", odometer=" + odometer +
                '}';
    }

    public Vehicles(double originalCost, String dateAcquired, String description, String makeModel, int year, int odometer) {
        super(originalCost, dateAcquired, description);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
}
