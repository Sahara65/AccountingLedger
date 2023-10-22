package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.ReportsScreen.reportsMenu;

public class LedgerScreen {
    static void ledgerMenu(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("""
                    Ledger
                    Please select an option:
                    D) Add Deposit
                    P) Make Payment (Debit)
                    L) Ledger
                    X) Exit""");


            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "A":
                    displayLedger();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    reportsMenu(scanner);
                    break;
                case "H":
                    running = false;
                default:
                    System.out.println("Invalid option, please try again!");
                    break;
            }
        }
    }

    private static void displayLedger() {

    }

    private static void displayDeposits() {

    }

    private static void displayPayments() {

    }
}
