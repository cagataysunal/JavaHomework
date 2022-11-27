package com.example.javahomework;

import com.example.javahomework.model.*;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AddRepairController {

    @FXML
    private ComboBox<String> categoryBox;
    @FXML
    private ComboBox<String> manufacturerBox;
    @FXML
    private ComboBox<String> modelBox;
    @FXML
    private ComboBox<String> clientBox;
    @FXML
    private TextField faultDescription;
    @FXML
    private ComboBox<String> technicianBox;
    @FXML
    private Label validatorMessage;
    private final List<Customer> customers = Datasource.getInstance().getCustomers();
    private final List<Technician> technicians = Datasource.getInstance().getTechnicians();


    String selectedCategory;
    String selectedManufacturer;
    ObservableList<String> categoryList =
            FXCollections.observableArrayList(Datasource.getInstance().getProductCategoryNames());
    ObservableList<String> manufacturerList =
            FXCollections.observableArrayList(Datasource.getInstance().getProductManufacturerNames());
    ObservableList<String> modelList;
    ObservableList<String> clientList =
            FXCollections.observableArrayList(customers
                    .stream().map(Customer::getTitle).collect(Collectors.toList()));
    ObservableList<String> technicianList =
            FXCollections.observableArrayList(technicians
                    .stream().map(Technician::getName).collect(Collectors.toList()));


    public void initialize() {
        manufacturerBox.getItems().setAll(manufacturerList);
        categoryBox.getItems().setAll(categoryList);
        clientBox.getItems().setAll(clientList);
        technicianBox.getItems().setAll(technicianList);
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
        Customer customer = Datasource.getInstance().getCustomerByName(clientBox.getValue());
        int customerId = customer.get_id();
        Product product = Datasource.getInstance().getProductByName(modelBox.getValue());
        int productId = product.get_id();
        String description = faultDescription.getText();
        Technician technician = Datasource.getInstance().getTechnicianByName(technicianBox.getValue());
        int technicianId = technician.get_id();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = dtf.format(localDateTime);

        Repair repair = new Repair();

        repair.setCustomer(customerId);
        repair.setProduct(productId);
        repair.setFaultDescription(description);
        repair.setTechnician(technicianId);
        repair.setDateTime(date);

        if (Datasource.getInstance().registerRepair(repair)) {
            validatorMessage.setText("Repair added!");
        } else {
            validatorMessage.setText("SQL Error.");
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
        stage.setScene(new Scene(root, 1280, 720));
        stage.setTitle("Menu");
        stage.show();
    }
}
