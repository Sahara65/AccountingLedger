package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.ReportsScreen.reportsMenu;

public class LedgerScreen {
    static void ledgerMenu(Scanner scanner) {
        boolean running = true;

        System.out.println("""
                ┌───────────────────────────────────────────┐
                │        Welcome to the Ledger Menu!        │
                └───────────────────────────────────────────┘
                """);

        while (running) {
            System.out.println("""
                    Please select an option:
                    A) Display All Entries
                    D) Display Deposit Entries
                    P) Display Payments
                    R) Go to Reports Menu
                    H) Return to Home""");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A" -> displayLedger();
                case "D" -> displayDeposits();
                case "P" -> displayPayments();
                case "R" -> reportsMenu(scanner);
                case "H" -> {
                    System.out.println("Back to home we go!");
                    return;
                }
                default -> System.out.println("Invalid option, please try again!");
            }
        }
    }

    private static void displayLedger() {

        System.out.println("""
                ┌───────────────────────────────────────────┐
                │           Displaying Ledger!              │
                └───────────────────────────────────────────┘
                """);
    }

    private static void displayDeposits() {

        System.out.println("""
                ┌───────────────────────────────────────────┐
                │           Displaying Deposits!            │
                └───────────────────────────────────────────┘
                """);
    }

    private static void displayPayments() {

        System.out.println("""
                ┌───────────────────────────────────────────┐
                │           Displaying Payments!            │
                └───────────────────────────────────────────┘
                """);
    }
}
