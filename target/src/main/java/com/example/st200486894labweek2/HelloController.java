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

public class HelloController implements Initializable {


  @FXML
  private BarChart<String, Double> barChart;

  @FXML
  private CategoryAxis catagoryAxis;

  @FXML
  private NumberAxis numberAxis;

    
  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    ArrayList<Stat> stats = DBUtility.getStats();
    for (Stats stat : stats)
    {
      System.out.println(year.getyear());
    }
    setBarChart();
  }
    void setBarChart()
    {
      barChart.getData().clear();
      catagoryAxis.setLabel("Year");
      numberAxis.setLabel("Money Paid");
      barChart.setTitle("Values");

      BarChart.Series<String, Double> series = new BarChart.Series<>();
      series.setName("Values");

      ArrayList<Stat> statistics = new ArrayList<>();
      statistics.addAll(DBUtility.getStats());

      BarChart.Series<String, Double> seriesTwo = new BarChart.Series<>();
      series.setName("Claims made");

      for (Stat stat : statistics)
      {
        series.getData().add(new BarChart.Data<>(stat.getStats(), stat.getValue()));
        seriesTwo.getData().add(new BarChart.Data<>(stat.getStats(), stat.getValue()));
      }
      barChart.getData().add(series);
      barChart.getData().add(seriesTwo);
    }
  }
