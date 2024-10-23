package com.pluralsight.week5;

public class Reservation {
    private String RoomType;
    private double price;
    private int numOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, double price, int numOfNights, boolean isWeekend) {
        RoomType = roomType;
        this.price = price;
        this.numOfNights = numOfNights;
        this.isWeekend = isWeekend;
    }

    public String getRoomType() {
        return RoomType;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public double getPrice() {
        return this.RoomType.equals("king") ? 139.00 : this.RoomType.equals("double") ? 124 : 0;
    }

    public int getNumOfNights() {
        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    public double getReservationTotal() {
        return isWeekend ? getPrice() * numOfNights * 1.1 : getPrice() * numOfNights;
    }
}
