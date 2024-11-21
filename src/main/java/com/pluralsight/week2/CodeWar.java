package com.pluralsight.week2;

import java.util.*;


public class CodeWar {

/*
*               
*
* */
    public static void main(String[] args) {
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } ));
    }

    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        for (int i=0; i < lines.length; i++) {
            for (String symbol : commentSymbols) {
                int index = lines[i].indexOf(symbol);
                if (index != -1) {
                    lines[i] = lines[i].substring(0, index);
                }
            }
            lines[i] = lines[i].trim();
        }

        return String.join("\n", lines);
    }
}
