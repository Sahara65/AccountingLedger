package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

import static com.pluralsight.HomeScreen.*;
import static com.pluralsight.LedgerScreen.*;
import static com.pluralsight.ReportsScreen.*;


public class LedgerAppRun {
    private static final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final String FILE_NAME = "transactions.csv";

    public static void main(String[] args) {

        loadTransactions(FILE_NAME);
        Scanner scanner = new Scanner(System.in);

        HomeScreen.homeMenu(scanner);

        LedgerScreen.ledgerMenu(scanner);

        ReportsScreen.reportsMenu(scanner);


    }
}













