package com.pluralsight.week7.generic;

import java.util.ArrayList;
import java.util.List;

public class FixedList <T>{
    private List<T>  items;
    private int maxSize;

    public FixedList(int maxSize) {
        this.maxSize = maxSize;
        items = new ArrayList<>();
    }

    public void add(T item) {
        if (items == null || items.size() < maxSize) {
            items.add(item);
        } else {
            System.out.println("reach the max size");
        }
    }

    public List<T> getItems() {
        return items;
    }
}
