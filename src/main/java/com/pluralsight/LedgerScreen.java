package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.ReportsScreen.reportsMenu;
import static com.pluralsight.ANSIColors.*;

public class LedgerScreen {
    static void ledgerMenu(Scanner scanner) {

        System.out.println(bold + """
                ┌───────────────────────────────────────────┐
                │        Welcome to the Ledger Menu!        │
                └───────────────────────────────────────────┘
                """ + resetBold);

        while (true) {
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
                    System.out.println(bold + """
                    ▒▒▒▒▒▒▒▒▒▒ 0% ██▒▒▒▒▒▒▒▒ 20% ████▒▒▒▒▒▒ 40% ██████▒▒▒▒ 60% ████████▒▒ 80% ██████████ 100%
                    """ + resetBold);
                    return;
                }
                default -> System.out.println("Invalid option, please try again!");
            }
        }
    }
    // Displaying Ledger
    private static void displayLedger() {

        System.out.println(bold + """
                ┌───────────────────────────────────────────┐
                │           Displaying Ledger!              │
                └───────────────────────────────────────────┘
                """ + resetBold);
    }

    private static void displayDeposits() {

        System.out.println(bold + """
                ┌───────────────────────────────────────────┐
                │           Displaying Deposits!            │
                └───────────────────────────────────────────┘
                """ + resetBold);
    }

    private static void displayPayments() {

        System.out.println(
                bold + """
                ┌───────────────────────────────────────────┐
                │           Displaying Payments!            │
                └───────────────────────────────────────────┘
                """ + resetBold);
    }
}
