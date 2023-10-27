package com.pluralsight;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class LedgerAppRun {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        // Main Menu
        HomeScreen.homeMenu(scanner);
    }
}