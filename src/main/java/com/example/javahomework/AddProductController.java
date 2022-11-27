package com.example.javahomework;

import com.example.javahomework.model.Datasource;
import com.example.javahomework.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AddProductController {
    private Product product;
    @FXML
    private TextField manufacturer;
    @FXML
    private TextField category;
    @FXML
    private TextField model;
    @FXML
    private TextField description;
    @FXML
    private Label validatorMessage;

    public void initialize() {
        product = new Product();
    }

    public void onRegisterButtonPress() {

        if (validateField(description)) {
            return;
        }
        if (validateField(manufacturer)) {
            return;
        }
        if (validateField(category)) {
            return;
        }
        if (validateField(model)) {
            return;
        }


        product.setManufacturer(manufacturer.getText().toLowerCase());
        product.setCategory(category.getText().toLowerCase());
        product.setModel(model.getText().toLowerCase());
        product.setDescription(description.getText().toLowerCase());


        if (Datasource.getInstance().registerProduct(product)) {
            validatorMessage.setText("Product added!");
        }


    }

    public boolean validateField(TextField field) {
        if (field.getText().trim().isEmpty()) {
            validatorMessage.setText("Please fill all fields.");
            return true;
        } else
            return false;
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 1280, 720));
        stage.show();
    }


}
