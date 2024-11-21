package com.pluralsight.week6;

public class House extends Asset{
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    @Override
    public double getValue() {
        double valuePerSquareFoot = 0;
        switch (condition) {
            case 1:
                valuePerSquareFoot = 180.0;
                break;
            case 2:
                valuePerSquareFoot = 130.0;
                break;
            case 3:
                valuePerSquareFoot = 90.0;
                break;
            default:
                valuePerSquareFoot = 80.0;
                break;
        }
        return (valuePerSquareFoot * squareFoot) + (0.25 * lotSize);
    }

    @Override
    public String toString() {
        return "House{" +
                "address='" + address + '\'' +
                ", condition=" + condition +
                ", squareFoot=" + squareFoot +
                ", lotSize=" + lotSize +
                '}';
    }

    public House(double originalCost, String dateAcquired, String description, String address, int condition, int squareFoot, int lotSize) {
        super(originalCost, dateAcquired, description);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}
