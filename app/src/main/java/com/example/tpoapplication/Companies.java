package com.example.tpoapplication;

/**
 * Created by HP INDIA on 07-Feb-18.
 */

public class Companies {
    private String name, date, venue;
    public Companies(){}
    public Companies(String name, String date, String venue){
        this.name = name;
        this.date = date;
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

}
