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
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    public static void main(String[] args) {

        loadTransactions(FILE_NAME);
        Scanner scanner = new Scanner(System.in);

        HomeScreen.homeMenu(scanner);

        LedgerScreen.ledgerMenu(scanner);

        ReportsScreen.reportsMenu(scanner);


            }
        }













