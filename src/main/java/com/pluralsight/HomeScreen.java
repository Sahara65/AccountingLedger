package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static com.pluralsight.LedgerScreen.*;
import static com.pluralsight.ANSIColors.*;

public class HomeScreen {
    public static void homeMenu(Scanner scanner) {
        System.out.println(green + bold + """
                                
                ┌───────────────────────────────────────────┐
                │   Welcome to The Accounting Ledger App!   │
                └───────────────────────────────────────────┘
                """ + resetBold);

        // Choices
        while (true) {
            System.out.println(green + """
                    Please select an option:
                    D) Add Deposit
                    P) Make Payment
                    L) Ledger
                    X) Exit""");

            String input = scanner.nextLine().trim();

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

        LocalDate dateInput;
        LocalTime timeInput;

        // Date Input
        while (true) {
            try {
                System.out.println("Please enter the date of your payment as -> yyyy-MM-dd:");

                String dateInput1 = scanner.nextLine().trim();
                dateInput = LocalDate.parse(dateInput1);

                System.out.println("You have entered: " + dateInput1);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format.");
            }
        }
        try {

            // Time Input
            while (true) {
                try {
                    System.out.println("(HH:mm) Now enter the time:");

                    String timeInput1 = scanner.nextLine().trim();
                    timeInput = LocalTime.parse(timeInput1);

                    System.out.println("You have entered: " + timeInput1);
                    break;
                }
                catch (Exception e){
                    System.out.println("Invalid format.");
                }
            }
            // Other Inputs
            System.out.println("Now enter the description of your payment:");
            String description = scanner.nextLine().trim();

            System.out.println("Enter the vendor name:");
            String vendor = scanner.nextLine().trim();

            System.out.println("Now enter your payment amount:");
            double amount = -Math.abs(scanner.nextDouble());
            scanner.nextLine();

            // Need to display new entry and then return to previous menu

            System.out.println("Thank you! Returning you to previous menu...");
            System.out.println(bold + """
                    ▒▒▒▒▒▒▒▒▒▒ 0% ██▒▒▒▒▒▒▒▒ 20% ████▒▒▒▒▒▒ 40% ██████▒▒▒▒ 60% ████████▒▒ 80% ██████████ 100%
                    """ + resetBold);
        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
        }
    }

    // Add Deposits
    private static void addDeposit(Scanner scanner) {


        System.out.println(yellow + bold + """
                ┌──────────────────────────────────────────┐
                │         Let's make that deposit!         │
                └──────────────────────────────────────────┘
                """ + resetBold);

        LocalDate dateInput;
        LocalTime timeInput;

        // Date Input
        while (true) {
            try {
                System.out.println("Please enter the date of your deposit as -> yyyy-MM-dd:");

                String dateInput1 = scanner.nextLine().trim();
                dateInput = LocalDate.parse(dateInput1);

                System.out.println("You have entered: " + dateInput1);


                break;
            } catch (Exception e) {
                System.out.println("Invalid format.");
            }

        }
        // Time Input
        while (true) {
            try {
                System.out.println("(HH:mm) Now enter the time:");

                String timeInput1 = scanner.nextLine().trim();
                timeInput = LocalTime.parse(timeInput1);

                System.out.println("You have entered: " + timeInput1);
                break;
            }
            catch (Exception e){
                System.out.println("Invalid format.");
            }
        }
        // Other Inputs
        try {
            System.out.println("Now enter the description of your deposit:");
            String description = scanner.nextLine().trim();

            System.out.println("Enter the vendor name:");
            String vendor = scanner.nextLine().trim();

            System.out.println("Now enter your deposit amount:");
            double amount = Math.abs(scanner.nextDouble());

            scanner.nextLine();

            System.out.println("Thank you! Returning you to previous menu..");
            System.out.println(bold + """
                    ▒▒▒▒▒▒▒▒▒▒ 0% ██▒▒▒▒▒▒▒▒ 20% ████▒▒▒▒▒▒ 40% ██████▒▒▒▒ 60% ████████▒▒ 80% ██████████ 100%
                    """ + resetBold);
        } catch (Exception a) {
            System.out.println("Oops incorrect input, try again.");
        }

        // Need to display new entry and then return to previous menu

    }

    // Load Transactions
    public static void loadTransactions(String fileName) {

    }
}




