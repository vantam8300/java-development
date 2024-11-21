package com.pluralsight.week7.generic;

import java.util.ArrayList;

public class Box <T>{
    private ArrayList<T> content;

    public void print() {
        for (T t : content) {
            System.out.println(t);
        }
    }

    public ArrayList<T> getContent() {
        return content;
    }

    public void setContent(ArrayList<T> content) {
        this.content = content;
    }
}
