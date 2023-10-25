package com.pluralsight;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static com.pluralsight.HomeScreen.*;


public class LedgerAppRun {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        // Menus
        homeMenu(scanner);
        LedgerScreen.ledgerMenu(scanner);
        ReportsScreen.reportsMenu(scanner);
    }
}
