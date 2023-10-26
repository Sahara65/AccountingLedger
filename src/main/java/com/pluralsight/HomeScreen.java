package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static com.pluralsight.LedgerScreen.*;
import static com.pluralsight.ANSIColors.*;
import static com.pluralsight.TransactionIO.*;

public class HomeScreen {
    public static void homeMenu(Scanner scanner) {
        System.out.println(green + bold + """
                                
                ┌───────────────────────────────────────────┐
                │   Welcome to The Accounting Ledger App!   │
                └───────────────────────────────────────────┘
                """ + resetBold);

        // Menu Choices
        while (true) {
            System.out.println(green + """
                    Please select an option:
                    D) Add Deposit
                    P) Make Payment
                    L) Ledger
                    X) Exit""");

            String input = userInputs(scanner);

            switch (input.toUpperCase()) {
                case "D" -> addDeposit(scanner);
                case "P" -> addPayment(scanner);
                case "L" -> ledgerMenu(scanner);
                case "X" -> {
                    System.out.println(red + bold + """
                            ┌───────────────────────────────────────────────────────────────┐
                            │   Now exiting... Thank you for using the Accounting Ledger!   │
                            └───────────────────────────────────────────────────────────────┘
                            """ + resetBold);
                    System.exit(0);
                }
                default -> System.out.println("Invalid option, please try again!");
            }
        }
    }

    // Add Payments
    private static void addPayment(Scanner scanner) {
        System.out.println(yellow + """
                ┌──────────────────────────────────────────┐
                │        Let's make that payment!          │
                └──────────────────────────────────────────┘
                """ + resetBold);

        // Date Input
        System.out.println(yellow + "Please enter the date of your payment as -> yyyy-MM-dd:");
        LocalDate dateInput = userDateInput(scanner);

        System.out.println(yellow + "(HH:mm) Now enter the time:");
        LocalTime timeInput = userTimeInput(scanner);

        System.out.println(yellow + "Now enter the description of your payment:");
        String description = userInputs(scanner);

        System.out.println(yellow + "Enter the vendor name:");
        String vendor = userInputs(scanner);

        System.out.println(yellow + "Now enter your payment amount:");
        double amount = userDoubleInputs(scanner) * -1;


        saveTransactions(fileName);
        Transaction newPayment = new Transaction(dateInput, timeInput, description, vendor, amount);
        transactions.add(newPayment);

        loadTransactions(fileName);

        System.out.println(yellow + "Your entry is: " + "\n" + newPayment);

        System.out.println(yellow + "Thank you! Returning you to previous menu...\n");
        System.out.println(yellow + bold + """
                ▒▒▒▒▒▒▒▒▒▒ 0% ██▒▒▒▒▒▒▒▒ 20% ████▒▒▒▒▒▒ 40% ██████▒▒▒▒ 60% ████████▒▒ 80% ██████████ 100%
                """ + resetBold);
    }

    // Add Deposits
    private static void addDeposit(Scanner scanner) {
        System.out.println(yellow + bold + """
                ┌──────────────────────────────────────────┐
                │         Let's make that deposit!         │
                └──────────────────────────────────────────┘
                """ + resetBold);

        // Date Input
        System.out.println(yellow + "Please enter the date of your deposit as -> yyyy-MM-dd:");
        LocalDate dateInput = userDateInput(scanner);

        // Time Input
        System.out.println(yellow + "(HH:mm) Now enter the time:");
        LocalTime timeInput = userTimeInput(scanner);

        // String Inputs
        System.out.println(yellow + "Now enter the description of your deposit:");
        String description = userInputs(scanner);

        System.out.println(yellow + "Enter the vendor name:");
        String vendor = userInputs(scanner);

        System.out.println(yellow + "Now enter your deposit amount:");
        double amount = userDoubleInputs(scanner);


        Transaction newDeposit = new Transaction(dateInput, timeInput, description, vendor, amount);
        transactions.add(newDeposit);

        System.out.println(yellow + "Your entry is: " + "\n" + newDeposit);

        saveTransactions(fileName);

        System.out.println("Thank you! Returning you to previous menu..");
        System.out.println(yellow + bold + """
                ▒▒▒▒▒▒▒▒▒▒ 0% ██▒▒▒▒▒▒▒▒ 20% ████▒▒▒▒▒▒ 40% ██████▒▒▒▒ 60% ████████▒▒ 80% ██████████ 100%
                """ + resetBold);

    }

    // Handles String Inputs
    public static String userInputs(Scanner scanner) {
        return scanner.nextLine().trim();
    }

    // Double Inputs
    public static double userDoubleInputs(Scanner scanner) {
        while (true) {
            try {
                double doubleInput = scanner.nextDouble();
                scanner.nextLine();
                return doubleInput;
            } catch (Exception e) {
                System.out.println("Invalid format.");
            }
        }
    }

    // LocalDate Inputs
    public static LocalDate userDateInput(Scanner scanner) {
        while (true) {
            try {
                LocalDate dateInput;

                String dateInput1 = userInputs(scanner);
                dateInput = LocalDate.parse(dateInput1);

                System.out.println(yellow + "You have entered: " + dateInput1);
                return dateInput;
            } catch (Exception e) {
                System.out.println(yellow + "Invalid date format. Please use yyyy-MM-dd");
            }
        }
    }

    // LocalTime Inputs
    public static LocalTime userTimeInput(Scanner scanner) {
        LocalTime timeInput;
        while (true) {
            try {
                String timeInput1 = userInputs(scanner);
                timeInput = LocalTime.parse(timeInput1);

                System.out.println(yellow + "You have entered: " + timeInput1);
                return timeInput;
            } catch (Exception e) {
                System.out.println(yellow + "Invalid format. Please use HH:mm");
            }
        }
    }
}