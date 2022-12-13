package com.example.javahomework;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

    private Parent root;
    private Scene scene;
    public void onHomeButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }

    public void switchToCustomerOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_customer.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);

    }

    public void switchToProductOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_product.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }

    public void switchToRepairOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_repair.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);

    }

    public void switchToReport(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("report_input.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }

    public void switchToTechnicianOptions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add_technician.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
}
