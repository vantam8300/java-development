package com.pluralsight.week2;

public class CodeWar {
    String name;

    public static String toJadenCase(String phrase) {
        // TODO put your code below this comment
        //Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
        //Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"

        if (phrase.isEmpty()) {
            return null;

        }
        StringBuilder sb = new StringBuilder(phrase);

        sb.setCharAt(0, Character.toUpperCase(phrase.charAt(0)));
        boolean isFirstLetter = false;

        for (int i=1; i<phrase.length(); i++) {

            if (isFirstLetter) {
                sb.setCharAt(i, Character.toUpperCase(phrase.charAt(i)));
            }

            if (phrase.charAt(i) == ' ') {
                isFirstLetter = true;
            } else {
                isFirstLetter = false;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(sb.toString());
    }
}
