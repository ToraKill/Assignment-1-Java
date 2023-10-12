package com.example.st200486894labweek2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
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

  @FXML
  private Label title;

  @FXML
  private AnchorPane anchor;

  @FXML
  private Button seeChart;


  @FXML
  void viewChart(ActionEvent event) throws IOException {
    SceneChanger.changeScenes(event, "table-view.fxml");
  }

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
      barChart.setTitle("Insurence Claims");
//using series to form barchart
      barChart.getData().addAll(DBUtility.getBarChartData());
    }
  }
