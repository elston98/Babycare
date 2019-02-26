package com.wilson.elston.babycare;

public class Doc_Details {

    private String Doc_Name;
    private String Doc_Qualification;

    public Doc_Details(String dname,String dqualification)
    {
        Doc_Name=dname;
        Doc_Qualification=dqualification;

    }

    public Doc_Details(){

    }
    public void setDoc_Name(String doc_Name) {
        Doc_Name = doc_Name;
    }

    public String getDoc_Name() {
        return Doc_Name;
    }

    public String getDoc_Qualification() {
        return Doc_Qualification;
    }

    public void setDoc_Qualification(String doc_Qualification) {
        Doc_Qualification = doc_Qualification;
    }
}
