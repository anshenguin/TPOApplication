package com.example.tpoapplication;

/**
 * Created by HP INDIA on 07-Feb-18.
 */

public class Companies {
    private String name, date, venue, eligibility, salary, ImgURL;
    public Companies(){}
    public Companies(String name,String date, String venue, String eligibility, String ImgId, String salary){
        this.name = name;
        this.eligibility = eligibility;
        this.venue = venue;
        this.ImgURL = ImgId;
        this.salary = salary;
        this.date = date;
    }

    public Companies(String name){
        this.name = name;
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

    public String getImgId() {
        return ImgURL;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setImgId(String imgId) {
        ImgURL = imgId;
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
