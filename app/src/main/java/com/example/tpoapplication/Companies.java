package com.example.tpoapplication;

/**
 * Created by HP INDIA on 07-Feb-18.
 */

public class Companies {
    private String name, date, venue, eligibility;
    private int ImgId;
    public Companies(){}
    public Companies(String name, String date, String venue, String eligibility, int ImgId){
        this.name = name;
        this.date = date;
        this.eligibility = eligibility;
        this.venue = venue;
        this.ImgId = ImgId;
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

    public String getEligibility() {
        return eligibility;
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
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
