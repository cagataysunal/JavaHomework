package com.example.javahomework;

import com.example.javahomework.model.Datasource;
import com.example.javahomework.model.Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ReportController {
    @FXML
    private TableView<Report> reportTableView;
    @FXML
    private TableColumn<Report, String> titleCol;
    @FXML
    private TableColumn<Report, String> catCol;
    @FXML
    private TableColumn<Report, String> manCol;
    @FXML
    private TableColumn<Report, String> modCol;
    @FXML
    private TableColumn<Report, String> dateCol;
    @FXML
    private TableColumn<Report, String> techCol;

    ObservableList<Report> reports = FXCollections.observableArrayList(Datasource.getInstance().getReport());

    public void initialize() {
        loadData();
        reportTableView.setItems(reports);
    }

    public void loadData() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("customerTitle"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
        manCol.setCellValueFactory(new PropertyValueFactory<>("productManufacturer"));
        modCol.setCellValueFactory(new PropertyValueFactory<>("productModel"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("repairDate"));
        techCol.setCellValueFactory(new PropertyValueFactory<>("technicianName"));
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menu");
        stage.setScene(new Scene(root, 1280, 720));
        stage.show();
    }
}
