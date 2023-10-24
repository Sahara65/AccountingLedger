package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static com.pluralsight.HomeScreen.*;

public class LedgerAppRun {
    private static final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    public static final String FILE_NAME = "transactions.csv";

    public static void main(String[] args) {
        loadTransactions(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        // Menus
        HomeScreen.homeMenu(scanner);
        LedgerScreen.ledgerMenu(scanner);
        ReportsScreen.reportsMenu(scanner);
    }

    // Input + Output
    public static ArrayList<Transaction> writeTransactions() throws FileNotFoundException {
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return transactions;
    }
    public static ArrayList<Transaction> readTransactions() throws FileNotFoundException {
        FileReader fileReader = new FileReader("transactions.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return transactions;
    }
}