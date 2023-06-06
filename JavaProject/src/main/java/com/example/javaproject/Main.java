package com.example.javaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        primaryStage.setTitle("Blood Donation");
        primaryStage.setScene(new Scene(root,700,467));
        primaryStage.show();

    }



    public static void main(String[] args) {
        Array.index.add(1);
        launch();
    }
}