package com.pluralsight.week5.workshop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AdminFileManager {

    public HashMap<String, String> getAccounts() {
        HashMap<String, String> accounts = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("accounts.csv"));
            String line;
            while((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                accounts.put(data[0], data[1]);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }
}
