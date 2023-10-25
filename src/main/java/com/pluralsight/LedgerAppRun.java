package com.pluralsight;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static com.pluralsight.HomeScreen.*;
import static com.pluralsight.TransactionIO.fileName;
import static com.pluralsight.TransactionIO.loadTransactions;

public class LedgerAppRun {


    public static void main(String[] args) throws FileNotFoundException {
        loadTransactions(fileName);
        Scanner scanner = new Scanner(System.in);

        // Menus
        homeMenu(scanner);
        LedgerScreen.ledgerMenu(scanner);
        ReportsScreen.reportsMenu(scanner);
    }
}
