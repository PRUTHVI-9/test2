package com.example.test2;

public class Listitem {
    String source;
    String destination;
    String date;


    public Listitem(String source, String destination, String date) {
        this.source = source;
        this.destination = destination;
        this.date = date;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
