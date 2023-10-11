package com.example.st200486894labweek2;

public class Stat {

    int id;

    Double value;

    int year;

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
//constructers
    public Stat(int id, Double value, int year) {
        this.id = id;
        this.value = value;
        this.year = year;
    }

    public Stat(Double value, int year) {
        this.id = -1;
        this.value = value;
        this.year = year;
    }
}
