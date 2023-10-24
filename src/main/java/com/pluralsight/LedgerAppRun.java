package com.pluralsight;

import java.io.*;
import java.util.*;

import static com.pluralsight.HomeScreen.*;

public class LedgerAppRun {

    private static final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public static final String fileName = "transactions.csv";

    public static void main(String[] args) throws FileNotFoundException {
        loadTransactions(fileName);
        Scanner scanner = new Scanner(System.in);

        // Menus
        homeMenu(scanner);
        LedgerScreen.ledgerMenu(scanner);
        ReportsScreen.reportsMenu(scanner);
    }

    // Input + Output
//    public static ArrayList<Transaction> writeTransactions() throws IOException {
//        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("transactions.csv"));
//        return transactions;
//    }
//    public static ArrayList<Transaction> readTransactions() throws FileNotFoundException {
//        BufferedReader fileReader = new BufferedReader(new FileReader("transactions.csv"));
//        return transactions;
//    }
}