package com.example.javahomework;

import com.example.javahomework.model.Datasource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class AddTechnicianController {
    @FXML
    private TextField name;
    @FXML
    private Label validatorMessage;
    Parent root;
    Scene scene;

    public void onRegisterButtonPress() {
        if (validateField(name)) return;

        if (Datasource.getInstance().registerTechnician(name.getText().trim())) {
            validatorMessage.setText("Technician Added!");
            clearFields();
        } else {
            validatorMessage.setText("SQL Error!");
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
        name.clear();
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
}
