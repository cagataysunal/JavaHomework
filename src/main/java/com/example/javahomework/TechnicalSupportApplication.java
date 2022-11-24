package com.example.javahomework;

import com.example.javahomework.model.Datasource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class TechnicalSupportApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        if (!(Datasource.getInstance().open())) {
            System.out.println("Couldn't connect to the database.");
            Platform.exit();
        } else {
            Datasource.getInstance().createTablesIfNotExists();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
            primaryStage.setTitle("Technical Support");
            primaryStage.setScene(new Scene(root, 800, 500));
            primaryStage.show();
        }
    }

    @Override
    public void stop() {
        Datasource.getInstance().close();
    }


    public static void main(String[] args) {
        launch(args);
    }

}