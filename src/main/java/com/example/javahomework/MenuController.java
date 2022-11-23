package com.example.javahomework;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

    private Stage stage;
    private Parent root;


    public void switchToCustomerOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("customer_options.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Customer Options");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();

    }

    public void switchToProductOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("product_options.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Product Options");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();

    }

    public void switchToRepairOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("repair_options.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Repair Options");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();

    }
}
