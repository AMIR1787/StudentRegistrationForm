package com.example.studentregistrationform;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 700, 420);


        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}