package com.example.javahomework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductOptionsController {
    @FXML
    private ComboBox<String> categoryBox;
    @FXML
    private ComboBox<String> manufacturerBox;

    public void initialize() {
        ObservableList<String> categoryList = FXCollections.observableArrayList(
                "Terminal",
                "Printer",
                "Panel PC",
                "Spare Part",
                "Service"
        );
        ObservableList<String> manufacturerList = FXCollections.observableArrayList(
                "Zebra",
                "Toshiba",
                "OEM"
        );
        categoryBox.getItems().setAll(categoryList);
        manufacturerBox.getItems().setAll(manufacturerList);
    }

    public void onBoxSelect() {

        if (!categoryBox.getSelectionModel().isEmpty()) {
            String selectedCategory = categoryBox.getValue();
        }
        if (!manufacturerBox.getSelectionModel().isEmpty()) {
            String selectedManufacturer = manufacturerBox.getValue();
        }


    }

    public void onSearchButtonClick() {

        if (categoryBox.getValue() == "Terminal") {

        }

    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
    }
}
