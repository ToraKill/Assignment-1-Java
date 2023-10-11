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
import java.util.*;

public class HelloController implements Initializable {


  @FXML
  private BarChart<String, Double> barChart;

  @FXML
  private CategoryAxis catagoryAxis;

  @FXML
  private NumberAxis numberAxis;

    
  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

// array list that calls stats from dbutility
    ArrayList<Stat> stats = DBUtility.getStats();
    for (Stat stat : stats)
    {
      //print id and year out to console
      System.out.println(stat.getId());
      System.out.println(stat.getYear());
    }
    setBarChart();
  }
    void setBarChart()
    {//labelling the chart sides
      barChart.getData().clear();
      catagoryAxis.setLabel("Year");
      numberAxis.setLabel("Money Paid");
      barChart.setTitle("Values");
//using series to form barchart
      BarChart.Series<String, Double> series = new BarChart.Series<>();
      series.setName("Values");

      ArrayList<Stat> statistics = new ArrayList<>();
      statistics.addAll(DBUtility.getStats());

      //for calulating the values into individiual months
      HashMap<String, Integer> yearsValues = new HashMap<>();

      // if the year does exist, then increase the current value by the stat.getValue()

      for (Stat stat : statistics)
      {
        String year = stat.getYear() + "";
        series.getData().add(new BarChart.Data<>(year, stat.getValue()));
      }
      barChart.getData().add(series);
    }
  }
