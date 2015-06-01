package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Runner extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        primaryStage.setTitle("FIRST TASK");
        primaryStage.setScene(new Scene(root, 850, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
