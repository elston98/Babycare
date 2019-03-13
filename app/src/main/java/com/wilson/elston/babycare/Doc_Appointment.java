package com.wilson.elston.babycare;

public class Doc_Appointment {
    private String Baby_Name;
    private String Reason;
    private String Date;
    private String Doc_Name;

    public Doc_Appointment(String baby_Name,String reason,String date,String doc_Name)
    {
        Baby_Name=baby_Name;
        Reason=reason;
        Date=date;
        Doc_Name=doc_Name;

    }
    public Doc_Appointment(){

    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public String getBaby_Name() {
        return Baby_Name;
    }

    public String getReason() {
        return Reason;
    }

    public String getDoc_Name() {
        return Doc_Name;
    }

    public void setBaby_Name(String baby_Name) {
        Baby_Name = baby_Name;
    }

    public void setDoc_Name(String doc_Name) {
        Doc_Name = doc_Name;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

}