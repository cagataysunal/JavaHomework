package com.example.javahomework;

import com.example.javahomework.model.AlertHelper;
import com.example.javahomework.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class RegistrationFormController {
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField emailField;
    @FXML
    private Button submitButton;
    private Parent root;
    private Scene scene;

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) throws IOException {

        Window owner = submitButton.getScene().getWindow();

        if (nameField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your name");
            return;
        }
        if (emailField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your email id");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
            return;
        }
        Datasource.getInstance().registerAccount(nameField.getText(), emailField.getText(), passwordField.getText());
        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", "Welcome " + nameField.getText());
        switchToMenu(event);
    }

    @FXML
    private void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }

    @FXML
    private void onHomeButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
}