package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

public class ReportsScreen {
    static void reportsMenu(Scanner scanner) {
        boolean running = true;

        System.out.println("""
                ┌───────────────────────────────────────────┐
                │        Welcome to the Reports Menu!       │
                └───────────────────────────────────────────┘
                """);

        while (running) {
            System.out.println("""
                    Please select an option:
                    1) Month To Date
                    2) Previous Month
                    3) Year To Date
                    4) Previous Year
                    5) Search by Vendor
                    0) Back""");


            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":

                case "2":

                case "3":


                case "4":

                case "5":

                case "0":
                    running = false;
                default:
                    System.out.println("Invalid option, please try again!");
                    break;
            }
        }
    }


    private static void filterTransactionsByDate(LocalDate startDate, LocalDate endDate) {

    }

    private static void filterTransactionsByVendor(String vendor) {

    }
}
