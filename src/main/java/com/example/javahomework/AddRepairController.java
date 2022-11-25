package com.example.javahomework;

import com.example.javahomework.model.Customer;
import com.example.javahomework.model.Datasource;
import com.example.javahomework.model.Repair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AddRepairController {

    @FXML
    private ComboBox<String> categoryBox;
    @FXML
    private ComboBox<String> manufacturerBox;
    @FXML
    private ComboBox<String> modelBox;
    @FXML
    private TextField client;
    @FXML
    private TextField faultDescription;
    @FXML
    private ComboBox<String> technicianBox;
    @FXML
    private Label validatorMessage;
    private Repair repair;
    private Customer customer;


    String selectedCategory;
    String selectedManufacturer;
    ObservableList<String> categoryList =
            FXCollections.observableArrayList(Datasource.getInstance().getProductCategoryNames());
    ObservableList<String> manufacturerList =
            FXCollections.observableArrayList(Datasource.getInstance().getProductManufacturerNames());
    ObservableList<String> modelList;


    public void initialize() {
        manufacturerBox.getItems().setAll(manufacturerList);
        categoryBox.getItems().setAll(categoryList);
    }

    public void onBoxSelect() {
        if (!(manufacturerBox.getSelectionModel().isEmpty() || categoryBox.getSelectionModel().isEmpty())) {
            selectedCategory = categoryBox.getSelectionModel().getSelectedItem();
            selectedManufacturer = manufacturerBox.getSelectionModel().getSelectedItem();
            modelList =
                    FXCollections.observableArrayList(Datasource.getInstance()
                            .getProductModels(selectedManufacturer, selectedCategory));
            modelBox.getItems().setAll(modelList);
        }
    }

    public void onRegisterButtonPress() {

        if (validateField(faultDescription)) {
            return;
        }
        if (validateField(client)) {
            return;
        }
        // TODO: Register repairs.


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
        stage.setScene(new Scene(root, 800, 500));
        stage.setTitle("Menu");
        stage.show();
    }
}
