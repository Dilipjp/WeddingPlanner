package com.dilip.weddingplanner;

public class Customer {
    private String name;
    private String date;
    private String place;

    public Customer(String name, String date, String place) {
        this.name = name;
        this.date = date;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getPlace() {
        return place;
    }
}

