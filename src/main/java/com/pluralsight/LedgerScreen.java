package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.HomeScreen.progressBar;
import static com.pluralsight.ReportsScreen.reportsMenu;
import static com.pluralsight.ANSIColors.*;
import static com.pluralsight.TransactionIO.*;

public class LedgerScreen {
    static void ledgerMenu(Scanner scanner) {

        System.out.println(bold + """
                
                ┌───────────────────────────────────────────┐
                │        Welcome to the Ledger Menu!        │
                └───────────────────────────────────────────┘
                """ + resetBold);

        while (true) {
            System.out.println(green + """
                    
                    Please select an option:
                    A) Display All Entries
                    D) Display Deposit Entries
                    P) Display Payments Entries
                    R) Go to Reports Menu
                    H) Return to Home""");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> {progressBar(); reportsMenu(scanner);}
                case "H" -> {
                    System.out.println("Back to home we go!");
                    progressBar();
                    return;
                }
                default -> System.out.println("Invalid option, please try again!");
            }
        }
    }

    // Display All Ledger Entries
    private static void displayLedger() {
        System.out.println(bold + """
                ┌───────────────────────────────────────────┐
                │           Displaying Entries!             │
                └───────────────────────────────────────────┘
                """ + resetBold);

        loadTransactions(fileName);

        for (Transaction transaction : transactions) {
            System.out.printf("%s, %s, %s, %s, %.2f%n", transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
        }
    }

    private static void displayDeposits() {
        System.out.println(bold + """
                ┌───────────────────────────────────────────┐
                │           Displaying Deposits!            │
                └───────────────────────────────────────────┘
                """ + resetBold);

        loadTransactions(fileName);

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.printf("%s, %s, %s, %s, %.2f%n", transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
        }
    }
    private static void displayPayments () {
        System.out.println(
                bold + """
                            ┌───────────────────────────────────────────┐
                            │           Displaying Payments!            │
                            └───────────────────────────────────────────┘
                            """ + resetBold);

        loadTransactions(fileName);

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < 0) {
                System.out.printf("%s, %s, %s, %s, %.2f%n", transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }

        }
    }
}

