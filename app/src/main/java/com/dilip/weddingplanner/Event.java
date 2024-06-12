package com.dilip.weddingplanner;

public class Event {
    private String name;
    private String date;
    private String place;
    private String time;
    private String description;

    public Event(String name, String date, String time, String place, String description) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.place = place;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    public String getDescription() {
        return description;
    }
}

