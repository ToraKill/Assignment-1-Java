package com.example.st200486894labweek2;

import java.time.LocalDate;

public class Stats {

    int stats_Id;

  String stats_Title;


    String stats_Price;

    LocalDate stats_Release_Date;

    public int getStats_Id() {
        return stats_Id;
    }

    public void setStats_Id(int stats_id) {
        this.stats_Id = stats_id;
    }

    public String getStats_Title() {
        return stats_Title;
    }

    public void setStats_Title(String stats_Title) {
        this.stats_Title = stats_Title;
    }

    public String getStats_Price() {
        return stats_Price;
    }

    public void setStats_Price(String stats_Price) {
        this.stats_Price = stats_Price;
    }

    public LocalDate getStats_Release_Date() {
        return stats_Release_Date;
    }

    public void setStats_Release_Date(LocalDate game_release_date) {
        this.stats_Release_Date = stats_Release_Date;
    }

    public Stats(int stats_Id, String stats_Title, String stats_Price, LocalDate stats_Release_Date) {
        this.stats_Id = stats_Id;
        this.stats_Title = stats_Title;
        this.stats_Price = stats_Price;
        this.stats_Release_Date = stats_Release_Date;
    }

    public Stats(String stats_Title, String stats_Price, LocalDate stats_Release_Date) {
        this.stats_Id = -1;
        this.stats_Title = stats_Title;
        this.stats_Price = stats_Price;
        this.stats_Release_Date = stats_Release_Date;
    }


}
