package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;


import static com.pluralsight.ANSIColors.green;
import static com.pluralsight.TransactionIO.transactions;

public class ReportsScreen {
    static void reportsMenu(Scanner scanner) {
        boolean running = true;

        System.out.println(green + """
                \033[1m
                ┌───────────────────────────────────────────┐
                │        Welcome to the Reports Menu!       │
                └───────────────────────────────────────────┘\033[0m
                """);

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
                case "1": filterByPresentMonth();

                case "2": filterByPreviousMonth();

                case "3": filterByYear();

                case "4": filterByPreviousYear();

                case "5":
                    filterTransactionsByVendor();



                case "0":
                    running = false;
                default:
                    System.out.println("Invalid option, please try again!");
                    break;
            }
        }
    }

    public static void filterByPresentMonth() {
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.now();

            if (transaction.getDate().getMonth() == date.getMonth() && transaction.getDate().getYear() == date.getYear()) {

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


        System.out.println("Here are all entries by previous month: ");


    }

    public static void filterByYear() {
        System.out.println("Here are all entries by current year: ");

    }

    public static void filterByPreviousYear() {
        System.out.println("Here are all entries by previous year: ");

    }


    public static void filterTransactionsByVendor() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the vendor name: ");
        String vendorInput = scanner.nextLine().trim();

        for (Transaction transaction : transactions) {

            if (transaction.getVendor().equalsIgnoreCase(vendorInput)) {
                System.out.println(transaction.getDate() + " " + transaction.getVendor() + " " + transaction.getAmount());

            }
        }
    }
}

//    private static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate) {
//
//    }
//}
