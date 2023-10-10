package com.example.st200486894labweek2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController<stat> implements Initializable {


  @FXML
  private BarChart<String, Double> barChart;

  @FXML
  private CategoryAxis catagoryAxis;

  @FXML
  private NumberAxis numberAxis;

    
  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    ArrayList<Stat> stats = DBUtility.getStats();


    for (stat stat : Stat)
    {
      System.out.println(stat.getYear());
    }

    setBarChart();

  }

    // set chart
    void setBarChart()
    {
      // Clear the chart
      barChart.getData().clear();

      // Set up the chart
      catagoryAxis.setLabel("Year");
      numberAxis.setLabel("Amount paid");
      barChart.setTitle("Insurence Claims");

      // Create a series for the chart
      BarChart.Series<String, Double> series = new BarChart.Series<>();
      series.setName("Value");

      // Get the games from the database
      ArrayList<Stat> statistics = new ArrayList<>(); // creating an empty list to HOLD the video games
      statistics.addAll(DBUtility.getStats()); // add the games to the list

      // Create a series for the chart
      BarChart.Series<String, Double> seriesTwo = new BarChart.Series<>();
      series.setName("Insurence claims");

      // Add the data to the series
      for (Stat stat : statistics)
      {
        series.getData().add(new BarChart.Data<>(stat.getYear(), stat.getValue()));
      }

      // Add the series to the chart
      barChart.getData().add(series);
    }
  }
