package com.example.javahomework;

import com.example.javahomework.model.Datasource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class TechnicalSupportApplication extends Application {
    Datasource datasource = new Datasource();

    @Override
    public void start(Stage primaryStage) throws Exception {
        datasource.open();
        datasource.createTablesIfNotExists();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        primaryStage.setTitle("Technical Support");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void stop() {
        datasource.close();
    }
}