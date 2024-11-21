package com.pluralsight.week7;

public class Jewelry extends FixedAsset{
    private double karat;

    public Jewelry(double karat) {
        this.karat = karat;
    }

    @Override
    public double getValue() {
        return 0;
    }
}
