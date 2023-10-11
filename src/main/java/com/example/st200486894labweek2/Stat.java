package com.example.st200486894labweek2;

import java.time.LocalDate;

public class Stat {

    Double value;

    int year;
    private Double Value;

    public void setValue(Double value) {
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Stat(int Year, Double Value) {
        this.value = value;
        this.year = year;

    }

    public Stat(LocalDate Year, int Value) {

        this.value = value;
        this.year = year;
    }

    public double getValue() {
        this.Value = value;


        return 0;
    }}
