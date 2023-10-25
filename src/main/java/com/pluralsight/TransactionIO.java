package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TransactionIO {

    public static ArrayList<Transaction> transactions = loadTransactions();
    public static ArrayList<Transaction> loadTransactions(){

        return new ArrayList<>();
    }

    public static final String fileName = "transactions.csv";

    public static <transactions> void loadTransactions(String fileName) {


        File file = new File(fileName);

        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userInputSections = line.split("\\|");
                if (userInputSections.length == 5) {
                   LocalDate dateInput = LocalDate.parse(userInputSections[0]);
                   LocalTime timeInput = LocalTime.parse(userInputSections[1]);
                    String vendor = userInputSections[2];
                    String description = userInputSections[3];
                    double amount = Double.parseDouble(userInputSections[4]);

                    Transaction t = new Transaction(dateInput, timeInput, vendor, description, amount);
                    transactions.add(t);

                    bufferedReader.close();
                }
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public static void saveTransactions(String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

            for (Transaction transactions : transactions) {
                String userInputSections = String.format("%s,d %s, %s, %s, %.2f\n",
                transactions.getDate(),
                transactions.getTime(),
                transactions.getVendor(),
                transactions.getDescription(),
                transactions.getAmount());

                bufferedWriter.write(userInputSections);
                bufferedWriter.close();

            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }

    public static void displayAllPayments(ArrayList<Transaction> transactions) {

    }



}
