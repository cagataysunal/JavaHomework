package com.example.javahomework;

import com.example.javahomework.model.Customer;
import com.example.javahomework.model.Datasource;
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


public class AddCustomerController {

    private final Customer customer = new Customer();
    @FXML
    private TextField companyTitle;
    @FXML
    private TextField taxAdmin;
    @FXML
    private TextField taxNum;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField city;
    @FXML
    private TextField district;
    @FXML
    private TextField address;
    @FXML
    private Label validatorMessage;

    public void onRegisterButtonPress() {

        if (validateField(companyTitle)) return;
        if (validateField(taxAdmin)) return;
        if (validateField(taxNum)) return;
        if (validateField(email)) return;
        if (validateField(phone)) return;
        if (validateField(city)) return;
        if (validateField(district)) return;
        if (validateField(address)) return;

        customer.setTitle(companyTitle.getText().trim().toLowerCase());
        customer.setTaxAdministration(taxAdmin.getText().trim().toLowerCase());
        customer.setTaxNumber(taxNum.getText().trim().toLowerCase());
        customer.setEmail(email.getText().trim().toLowerCase());
        customer.setPhone(phone.getText().trim().toLowerCase());
        customer.setCity(city.getText().trim().toLowerCase());
        customer.setDistrict(district.getText().trim().toLowerCase());
        customer.setAddress(address.getText().trim().toLowerCase());


        if (Datasource.getInstance().registerCustomer(customer)) {
            validatorMessage.setText("Customer added!");
            clearFields();
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

    public void clearFields() {
        companyTitle.clear();
        taxAdmin.clear();
        taxNum.clear();
        email.clear();
        phone.clear();
        city.clear();
        district.clear();
        address.clear();
    }


    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 1280, 720));
        stage.show();
    }

}
