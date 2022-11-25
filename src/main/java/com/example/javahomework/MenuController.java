package com.example.javahomework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    protected void onHomeButtonClick(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }

    public void switchToCustomerOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_customer.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Customer Options");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();

    }

    public void switchToProductOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_product.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Product Options");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();

    }

    public void switchToRepairOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_repair.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Repair Options");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();

    }
}
