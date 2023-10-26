package com.pluralsight;

import java.io.*;
import java.util.*;

public class LedgerAppRun {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        // Menus
        HomeScreen.homeMenu(scanner);
        LedgerScreen.ledgerMenu(scanner);
        ReportsScreen.reportsMenu(scanner);
    }
}