package com.wilson.elston.babycare;

public class Day_Care {

    private String Center_Name;
    private  String Location;
    private String Website_url;

    public Day_Care(String cname,String location,String website_url)
    {
        Center_Name=cname;
        Location=location;
        Website_url=website_url;
    }
    public  Day_Care(){

    }

    public String getCenter_Name() {
        return Center_Name;
    }

    public String getLocation() {
        return Location;
    }

    public String getWebsite_url() {
        return Website_url;
    }

    public void setCenter_Name(String center_Name) {
        Center_Name = center_Name;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setWebsite_url(String website_url) {
        Website_url = website_url;
    }

}
