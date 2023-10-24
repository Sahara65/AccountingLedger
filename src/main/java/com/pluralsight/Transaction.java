package com.pluralsight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String description;
    private String vendor;
    private double price;
    private LocalDate date;
    private LocalTime time;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Transaction(String description, String vendor, double price, LocalDate date, LocalTime time) {
        this.description = description;
        this.vendor = vendor;
        this.price = price;
        this.date = date = LocalDate.now();
        this.time = time = LocalTime.now();

    }



    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(String.valueOf(dateFormat));
    static final String TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
}
