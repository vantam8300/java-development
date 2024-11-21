package com.pluralsight.week7;

public abstract class FixedAsset implements Valuable{
    private String name;
    private double marketValue;

    public void Asset(String name, double value) {
        this.name = name;
        this.marketValue = value;
    }
}
