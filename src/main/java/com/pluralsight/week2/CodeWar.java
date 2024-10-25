package com.pluralsight.week2;

import java.util.*;


public class CodeWar {

/*
*               
*
* */
    public static void main(String[] args) {
        // your code
        int n = 10;
        List<Integer> myList = new ArrayList<>();
        myList.add(1);

        int index =0;
        while (myList.size() < n) {
            int y = 2 * myList.get(index) + 1;
            int z = 3 * myList.get(index) + 1;
            myList.add(y);
            myList.add(z);
            index++;
        }

        for (int i : myList) {
            System.out.print(i + " ");

        }
    }

}
