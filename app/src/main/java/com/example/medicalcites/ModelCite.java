package com.example.medicalcites;

public class ModelCite {
    private String name;
    private int identification;
    private String type_cite;
    private String date;
    private String time;
    private String profetional;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getType_cite() {
        return type_cite;
    }

    public void setType_cite(String type_cite) {
        this.type_cite = type_cite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProfetional() {
        return profetional;
    }

    public void setProfetional(String profetional) {
        this.profetional = profetional;
    }
}
