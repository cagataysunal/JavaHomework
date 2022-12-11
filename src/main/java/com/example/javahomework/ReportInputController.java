package com.example.javahomework;

import com.example.javahomework.model.Customer;
import com.example.javahomework.model.Datasource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReportInputController {
    @FXML
    private ComboBox<String> customerBox;
    @FXML
    private ComboBox<String> modelBox;
    @FXML
    private ComboBox<String> manufacturerBox;
    @FXML
    private ComboBox<String> categoryBox;
    @FXML
    private TextField serialNumber;
    private final List<Customer> customers = Datasource.getInstance().getCustomers();

    String selectedCategory;
    String selectedManufacturer;
    ObservableList<String> categoryList =
            FXCollections.observableArrayList(Datasource.getInstance().getProductCategoryNames());
    ObservableList<String> manufacturerList =
            FXCollections.observableArrayList(Datasource.getInstance().getProductManufacturerNames());
    ObservableList<String> modelList;
    ObservableList<String> clientList =
            FXCollections.observableArrayList(customers.stream().map(Customer::getTitle).collect(Collectors.toList()));
    FilterHolder filterHolder = FilterHolder.getInstance();

    public void initialize() {
        manufacturerBox.getItems().setAll(manufacturerList);
        categoryBox.getItems().setAll(categoryList);
        customerBox.getItems().setAll(clientList);
    }

    public void onBoxSelect() {
        if (!(manufacturerBox.getSelectionModel().isEmpty() || categoryBox.getSelectionModel().isEmpty())) {
            selectedCategory = categoryBox.getSelectionModel().getSelectedItem();
            selectedManufacturer = manufacturerBox.getSelectionModel().getSelectedItem();
            modelList =
                    FXCollections.observableArrayList(Datasource.getInstance().getProductModels(selectedManufacturer, selectedCategory));
            modelBox.getItems().setAll(modelList);
            modelBox.setDisable(false);
        }
    }

    public void onViewReportButtonPress(ActionEvent event) throws IOException {
        filterData(customerBox.getValue(), modelBox.getValue(), serialNumber.getText().trim());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("report.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 1280, 720));
        stage.setTitle("Menu");
        stage.show();
    }

    private void filterData(String customer, String model, String serialNumber) {
        filterHolder.setCustomerName(customer != null ? customer : "");
        filterHolder.setModel(model != null ? model : "");
        filterHolder.setSerialNumber(serialNumber);
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 1280, 720));
        stage.setTitle("Menu");
        stage.show();
    }
}
