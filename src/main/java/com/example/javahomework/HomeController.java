package com.example.javahomework;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class HomeController {
    Parent root;
    Scene scene;

    public void onLoginButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login_form.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }

    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register_form.fxml")));
        scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
}
