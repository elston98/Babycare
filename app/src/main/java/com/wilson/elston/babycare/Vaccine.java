package com.wilson.elston.babycare;

import android.widget.EditText;

class Vaccine {
    public  String date;
    public  String name;
    public Vaccine(String name, String date) {
        this.date=date;
        this.name=name;
    }
    public Vaccine()
    {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
