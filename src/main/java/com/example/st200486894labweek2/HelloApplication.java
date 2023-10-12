package com.example.st200486894labweek2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //"hello-view.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("table-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BarChart/TableView!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
