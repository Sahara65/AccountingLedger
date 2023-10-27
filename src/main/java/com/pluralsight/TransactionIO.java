package com.pluralsight;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public enum TransactionIO {
    ;
    public static final String fileName = "transactions.csv";
    public static final ArrayList<Transaction> transactions = loadTransactions(fileName);

    public static ArrayList<Transaction> loadTransactions(String fileName) {

        ArrayList<Transaction> loadedTransactions = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TransactionIO.fileName, StandardCharsets.UTF_8))) {
            String lines;
            while (null != (lines = bufferedReader.readLine())) {
                String[] userInputSections = lines.split(",");
                if (5 == userInputSections.length) {
                    LocalDate dateInput = LocalDate.parse(userInputSections[0]);
                    LocalTime timeInput = LocalTime.parse(userInputSections[1]);
                    String description = userInputSections[2];
                    String vendor = userInputSections[3];
                    double amount = Double.parseDouble(userInputSections[4]);

                    Transaction t = new Transaction(dateInput, timeInput, vendor, description, amount);
                    loadedTransactions.add(t);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        return loadedTransactions;
    }

    public static void saveTransactions(String fileName) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

            for (Transaction transactions : transactions) {
                String userInputSections = String.format("%s,%s,%s,%s,%.2f\n",
                        transactions.getDate(),
                        transactions.getTime(),
                        transactions.getDescription(),
                        transactions.getVendor(),
                        transactions.getAmount());

                bufferedWriter.write(userInputSections);
                bufferedWriter.close();
                break;
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
    }



