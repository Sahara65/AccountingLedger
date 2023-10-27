package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    // Declaring entry types
    private String description;
    private String vendor;
    private double amount;
    private LocalDate date;
    private LocalTime time;
    // Constructor for Entries
    public Transaction(LocalDate dateInput, LocalTime timeInput, String description, String vendor, double amount) {
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
        this.date = dateInput;
        this.time = timeInput;

    }

    // Getters for entry types
    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\n" +
                "Time: " + time + "\n" +
                "Vendor: " + vendor + "\n" +
                "Amount: " + amount + "\n" +
                "Description: " + description;
    }
}
