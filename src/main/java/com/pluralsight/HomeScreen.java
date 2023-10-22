package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.LedgerScreen.ledgerMenu;
import static com.pluralsight.ANSIColors.*;

public class HomeScreen {
    public static void homeMenu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("""
                    Welcome to The Accounting Ledger App!
                    Please select an option:
                    D) Add Deposit
                    P) Make Payment
                    L) Ledger
                    X) Exit""");

            String input = scanner.nextLine().trim();

            switch (input.toUpperCase()) {
                case "D":
                    addDeposit(scanner);
                    break;
                case "P":
                    addPayment(scanner);
                    break;
                case "L":
                    ledgerMenu(scanner);
                    break;
                case "X":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again!");
                    break;
            }
        }

    }

    private static void addDeposit(Scanner scanner) {

        System.out.println("(yyyy-MM-dd) Please enter the date of your deposit:");
        String input = scanner.nextLine().trim();
        System.out.println("(HH:mm:ss) Now enter the time:");
        String input2 = scanner.nextLine().trim();
        System.out.println("Now enter your vendor:");
        String input3 = scanner.nextLine().trim();


    }

    private static void addPayment(Scanner scanner) {

    }

    public static void loadTransactions(String fileName) {

    }
}

