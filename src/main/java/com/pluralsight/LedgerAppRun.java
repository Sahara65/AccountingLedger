package com.pluralsight;

import java.util.*;

public class LedgerAppRun {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Menus
        HomeScreen.homeMenu(scanner);
        LedgerScreen.ledgerMenu(scanner);
        ReportsScreen.reportsMenu(scanner);
    }
}