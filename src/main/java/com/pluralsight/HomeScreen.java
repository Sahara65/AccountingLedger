package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static com.pluralsight.LedgerAppRun.*;
import static com.pluralsight.LedgerScreen.ledgerMenu;
import static com.pluralsight.ANSIColors.*;
import static com.pluralsight.Transaction.*;

public class HomeScreen {


    public static void homeMenu(Scanner scanner) {
        boolean running = true;
        System.out.println(green + """
                ┌───────────────────────────────────────────┐
                │   Welcome to The Accounting Ledger App!   │
                └───────────────────────────────────────────┘
                """);

        while (running) {
            System.out.println(green + """
                    Please select an option:
                    D) Add Deposit
                    P) Make Payment
                    L) Ledger
                    X) Exit""" + reset);

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D" -> addDeposit(scanner);
                case "P" -> addPayment(scanner);
                case "L" -> ledgerMenu(scanner);
                case "X" -> {
                    System.out.println(red + """
                            ┌───────────────────────────────────────────────────────────────┐
                            │   Now exiting... Thank you for using the Accounting Ledger!   │
                            └───────────────────────────────────────────────────────────────┘
                            """);
                    System.exit(0);
                }
                default -> System.out.println("Invalid option, please try again!");
            }
        }

    }

    private static void addDeposit(Scanner scanner) {


        System.out.println(yellow + """
                ┌──────────────────────────────────────────┐
                │        Let's make that deposit!          │
                └──────────────────────────────────────────┘
                """);

        try {

            System.out.println("Please enter the date of your deposit:");
            String date = scanner.nextLine().trim();

            System.out.println("(HH:mm:ss) Now enter the time:");
            String time = scanner.nextLine().trim();

            System.out.println("Now enter the description of your deposit:");
            String description = scanner.nextLine().trim();

            System.out.println("Enter the vendor name:");
            String vendor = scanner.nextLine().trim();

            System.out.println("Now enter your deposit amount:");
            double amount = Double.parseDouble(scanner.nextLine().trim());

            System.out.println("Thank you! Returning you to previous menu..");
            System.out.println("""
                                        
                    ▒▒▒▒▒▒▒▒▒▒ 0% ██▒▒▒▒▒▒▒▒ 20% ████▒▒▒▒▒▒ 40% ██████▒▒▒▒ 60% ████████▒▒ 80% ██████████ 100%
                    """);
        } catch (Exception e) {
            System.out.println("Oops incorrect input, try again.");
        }
        // Display new entry and then return to previous menu
    }

    private static void addPayment(Scanner scanner) {

        System.out.println(yellow + """
                ┌──────────────────────────────────────────┐
                │        Let's make that payment!          │
                └──────────────────────────────────────────┘
                """);


        try {
            System.out.println("Please enter the date of your payment:");
            String date = scanner.nextLine().trim();
            System.out.println("(HH:mm:ss) Now enter the time:");
            String time = scanner.nextLine().trim();
            System.out.println("Now enter the description of your payment:");
            String description = scanner.nextLine().trim();
            System.out.println("Enter the vendor name:");
            String vendor = scanner.nextLine().trim();
            System.out.println("Now enter your payment amount:");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            // Display new payment and then return to previous menu

            System.out.println("Thank you! Returning you to previous menu..");
            System.out.println("""
                                        
                    ▒▒▒▒▒▒▒▒▒▒ 0% ██▒▒▒▒▒▒▒▒ 20% ████▒▒▒▒▒▒ 40% ██████▒▒▒▒ 60% ████████▒▒ 80% ██████████ 100%
                    """);
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
        }

    }

    public static void loadTransactions(String fileName) {

    }


}


