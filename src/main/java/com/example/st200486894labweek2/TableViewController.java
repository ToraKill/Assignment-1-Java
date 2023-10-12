package com.example.st200486894labweek2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class TableViewController {

    @FXML
    private TableColumn<Stat, Integer> eyeds;


    @FXML
    private TableColumn<Stat, Double> valuess;

    @FXML
    private TableColumn<Stat, Integer> yearss;

    @FXML
    private Button seechart;

    @FXML
    private AnchorPane root;


    @FXML
    private TableView<Stat> tableviewss;


   private ArrayList<Stat> allStats;

    @FXML
    void initialize()
    {

        allStats = DBUtility.getStats();
//set the data into the table
        eyeds.setCellValueFactory(new PropertyValueFactory<>("id"));
        valuess.setCellValueFactory(new PropertyValueFactory<>("value"));
        yearss.setCellValueFactory(new PropertyValueFactory<>("year"));
        tableviewss.getItems().addAll(allStats);
    }

    @FXML
    void viewData(ActionEvent event) throws IOException {
    SceneChanger.changeScenes(event,"hello-view.fxml");
    }



}