package com.intertech.icard.cardStatement;

public class CardStatement {

    private int year, day;
    private String pay;
    private String month;
    private String time;
    private String name;
    private String description;
    private String city;
    private String unit;

    public CardStatement(int year, String month, int day, String time, String pay, String name, String description, String city, String unit) {
        this.year = year;
        this.day = day;
        this.pay = pay;
        this.month = month;
        this.time = time;
        this.name = name;
        this.description = description;
        this.city = city;
        this.unit = unit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}