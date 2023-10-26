package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;


import static com.pluralsight.ANSIColors.*;
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
                case "1" -> filterByPresentMonth();
                case "2" -> filterByPreviousMonth();
                case "3" -> filterByYear();
                case "4" -> filterByPreviousYear();
                case "5" -> {
                    System.out.println("Please enter the vendor name: ");
                    String vendorInput = scanner.nextLine().trim();
                    filterTransactionsByVendor(vendorInput);
                }
                case "0" -> running = false;
                default -> System.out.println("Invalid option, please try again!");
            }
        }
    }

    public static void filterByPresentMonth() {
        System.out.println("The following are entries from the current month: ");
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.now();


            if (transaction.getDate().getMonth() == date.getMonth()) {

                System.out.printf("%s, %s, %.2f%n", transaction.getDate(), transaction.getVendor(), transaction.getAmount());

            }
            break;
        }

    }
    public static void filterByPreviousMonth() {
//        for (Transaction transaction : transactions) {
//
//
//        }

        System.out.println("The following are entries from the previous month: ");


    }

    public static void filterByYear() {
        System.out.println("The following are entries from the current year: ");

    }

    public static void filterByPreviousYear() {
        System.out.println("The following are entries from the previous year: ");

    }


    public static void filterTransactionsByVendor(String vendorInput) {

        System.out.println("The following are entries filtered by chosen vendor: ");
        for (Transaction transaction : transactions) {

            if (vendorInput.equalsIgnoreCase(transaction.getVendor())) {
                System.out.printf("%s, %s, %s, %s, %.2f%n", transaction.getDate(), transaction.getTime(), transaction.getVendor(), transaction.getDescription(), transaction.getAmount());
            }
            else {
                System.out.println("No results found... 😔");
            }
            break;
        }
    }
}


