package com.pluralsight.week3;

import java.io.*;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class PayRollCalculator {
    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the name of the file employee file to process: ");

            FileReader fileReader = new FileReader(scanner.nextLine());

            BufferedReader bufReader = new BufferedReader(fileReader);

            String input;

            bufReader.readLine();

            System.out.print("Enter the name of the payroll file to create: ");

            String outPutFile = scanner.nextLine();

            FileWriter fw = new FileWriter(outPutFile);
            BufferedWriter bufWriter = new BufferedWriter(fw);


            if (outPutFile.endsWith(".csv")) {
                writeToCSV(bufReader, bufWriter);
            } else if (outPutFile.endsWith(".json")) {
                writeToJSON(bufReader, bufWriter);
            }

            bufReader.close();
            bufWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

    public static void writeToJSON(BufferedReader bufReader, BufferedWriter bufWriter) {
        String input;
        JSONArray jsonArray = new JSONArray();
        try {
            while ((input = bufReader.readLine()) != null) {

                String[] employee = input.split("\\|");

                Employee e = new Employee(Integer.parseInt(employee[0]), employee[1], Double.parseDouble(employee[2]), Double.parseDouble(employee[3]));

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", e.getEmployeeId());
                jsonObject.put("name", e.getName());
                jsonObject.put("grossPay", e.getGrossPay());
                jsonArray.put(jsonObject);
            }
            bufWriter.write(jsonArray.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }

    public static void writeToCSV(BufferedReader bufReader, BufferedWriter bufWriter) {
        String input;
        JSONArray jsonArray = new JSONArray();
        try {
            while ((input = bufReader.readLine()) != null) {

                String[] employee = input.split("\\|");

                Employee e = new Employee(Integer.parseInt(employee[0]), employee[1], Double.parseDouble(employee[2]), Double.parseDouble(employee[3]));

                bufWriter.write("ID: " + e.getEmployeeId() + " | Name: " + e.getName() + "| Gross Pay: " + e.getGrossPay() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }

    }
}
