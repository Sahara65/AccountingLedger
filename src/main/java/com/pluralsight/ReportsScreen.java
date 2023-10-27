package com.pluralsight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static com.pluralsight.ANSIColors.*;
import static com.pluralsight.HomeScreen.progressBar;
import static com.pluralsight.TransactionIO.*;

public class ReportsScreen {

    static void reportsMenu(Scanner scanner) {
        boolean running = true;

        System.out.println(green + bold + """
                                
                ┌───────────────────────────────────────────┐
                │        Welcome to the Reports Menu!       │
                └───────────────────────────────────────────┘
                """ + resetBold);

        while (running) {
            System.out.println(green + """
                    Please select an option:
                    1) Month To Date
                    2) Previous Month
                    3) Year To Date
                    4) Previous Year
                    5) Search by Vendor
                    0) Back""");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> ReportsScreen.filterByPresentMonth(transactions);
                case "2" -> ReportsScreen.filterByPreviousMonth(transactions);
                case "3" -> ReportsScreen.filterByYear(transactions);
                case "4" -> ReportsScreen.filterByPreviousYear(transactions);
                case "5" -> {
                    System.out.println("Please enter the vendor name: ");
                    String vendorInput = scanner.nextLine().trim();
                    filterTransactionsByVendor(vendorInput, transactions);
                }
                case "0" -> {
                    running = false;
                    // Progress Bar Animation
                    progressBar();
                }
                default -> System.out.println("Invalid option, please try again!");
            }
        }
    }

    public static void filterByPresentMonth(ArrayList<Transaction> transactions) {
        System.out.println("The following are entries from the current month: ");
        LocalDate currentDate = LocalDate.now();

        for (Transaction transaction : transactions) {
            if (transaction.getDate().getYear() == currentDate.getYear() && transaction.getDate().getMonth() == currentDate.getMonth()) {
                System.out.printf("%s, %s, %s, %s, %.2f%n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
        }
    }

    public static void filterByPreviousMonth(ArrayList<Transaction> transactions) {
        System.out.println("The following are entries from the previous month: ");
        LocalDate currentDate = LocalDate.now();
        LocalDate previousMonth = currentDate.minusMonths(1);

        for (Transaction transaction : transactions)
            if (transaction.getDate().getYear() == previousMonth.getYear() && transaction.getDate().getMonth() == previousMonth.getMonth())
                System.out.printf("%s, %s, %s, %s, %.2f%n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
    }

    public static void filterByYear(ArrayList<Transaction> transactions) {
        System.out.println("The following are entries from the current year: ");

        int currentYear = LocalDate.now().getYear();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            int transactionYear = transactionDate.getYear();

            if (transactionYear == currentYear) {
                System.out.printf("%s, %s, %s, %s, %.2f%n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
        }
    }

    public static void filterByPreviousYear(ArrayList<Transaction> transactions) {
        System.out.println("The following are entries from the previous year: ");

        int currentYear = LocalDate.now().getYear();
        int previousYear = currentYear - 1;

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            int transactionYear = transactionDate.getYear();

            if (transactionYear == previousYear) {
                System.out.printf("%s, %s, %s, %s, %.2f%n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
        }
    }

    public static void filterTransactionsByVendor(final String vendorInput, final ArrayList<Transaction> transactions) {

        System.out.println("The following are entries filtered by chosen vendor: ");

        loadTransactions(fileName);

        for (final Transaction transaction : transactions) {

            if (vendorInput.equalsIgnoreCase(transaction.getVendor())) {
                System.out.printf("%s, %s, %s, %s, %.2f%n",
                        transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
        }
    }
}