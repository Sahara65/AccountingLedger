package com.pluralsight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static com.pluralsight.HomeScreen.progressBar;
import static com.pluralsight.ReportsScreen.reportsMenu;
import static com.pluralsight.ANSIColors.*;
import static com.pluralsight.TransactionIO.*;

public enum LedgerScreen {
    ;
    // Ledger Menu
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
            // Choices
            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> {
                    progressBar();
                    reportsMenu(scanner);
                }
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

        System.out.println("""
                ┌────────────┬───────┬─────────────────────────────────────┬──────────────────┬────────────────┐
                │   Date     │  Time │           Description               │      Vendor      │     Amount     │
                ├────────────┼───────┼─────────────────────────────────────┼──────────────────┼────────────────┤
                """);

        dateTimeSorter();
        for (Transaction transaction : transactions) {
            System.out.printf("│ %s │ %s │ %-30.35s        %-11.16s        %-10.2f      \n",
                    transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
        }
        System.out.println("""
                └────────────┴───────┴─────────────────────────────────────┴──────────────────┴────────────────┘
                """);
    }

    // Displaying all Deposits
    private static void displayDeposits() {
        System.out.println(bold + """
                ┌───────────────────────────────────────────┐
                │           Displaying Deposits!            │
                └───────────────────────────────────────────┘
                """ + resetBold);

        loadTransactions(fileName);

        System.out.println("""
                ┌────────────┬───────┬─────────────────────────────────────┬──────────────────┬────────────────┐
                │   Date     │  Time │           Description               │      Vendor      │     Amount     │
                ├────────────┼───────┼─────────────────────────────────────┼──────────────────┼────────────────┤
                """);

        dateTimeSorter();
        for (Transaction transaction : transactions) {
            if (0 < transaction.getAmount()) {
                System.out.printf("│ %s │ %s │ %-30.35s        %-11.16s        %-10.2f      \n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
        }
        System.out.println("""
                └────────────┴───────┴─────────────────────────────────────┴──────────────────┴────────────────┘
                """);
    }
    // Displaying all Payments
    private static void displayPayments() {
        System.out.println(
                bold + """
                        ┌───────────────────────────────────────────┐
                        │           Displaying Payments!            │
                        └───────────────────────────────────────────┘
                        """ + resetBold);

        loadTransactions(fileName);

        System.out.println("""
                ┌────────────┬───────┬─────────────────────────────────────┬──────────────────┬────────────────┐
                │   Date     │  Time │           Description               │      Vendor      │     Amount     │
                ├────────────┼───────┼─────────────────────────────────────┼──────────────────┼────────────────┤
                """);

        dateTimeSorter();
        for (Transaction transaction : transactions) {
            if (0 > transaction.getAmount()) {
                System.out.printf("│ %s │ %s │ %-30.35s        %-11.16s        %-10.2f      \n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
        }
        System.out.println("""
                └────────────┴───────┴─────────────────────────────────────┴──────────────────┴────────────────┘
                """);
    }
    // Date + Time sorter so arrange data from newest to oldest
    public static void dateTimeSorter() {

        Comparator<Transaction> dateComparator = (t1, t2) -> {
            int dateComparison = t2.getDate().compareTo(t1.getDate());
            if (0 == dateComparison) {
                return t2.getTime().compareTo(t1.getTime());
            }
            return dateComparison;
        };
        transactions.sort(dateComparator);
    }
}

