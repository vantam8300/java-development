package com.pluralsight.week1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectingWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordArray = new ArrayList<String>();

        try {
            FileWriter fw = new FileWriter("test.txt");
            while (true) {
                System.out.print("enter a word ");
                String word = scanner.nextLine();
                if (!word.isEmpty()) {
                    if (!wordArray.contains(word)) {
                        wordArray.add(word);
                        fw.write(word + "\n");
                    }
                } else {
                    break;
                }
            }
            wordArray.forEach((n) -> System.out.println(n));
            fw.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        String shortestWord = wordArray.get(0);
        String longestWord = wordArray.get(0);

        int totalLength = 0;
        for (String word : wordArray) {
            totalLength += word.length();

            if (word.length() < shortestWord.length()) {
                shortestWord = word;
            }

            if (longestWord.length() < word.length()) {
                longestWord = word;
            }
        }

        float averageLength = (float) totalLength / wordArray.size();

        System.out.println("Shortest Word: " + shortestWord);
        System.out.println("longest Word: " + longestWord);
        System.out.println("Average length: " + averageLength);
    }
}
