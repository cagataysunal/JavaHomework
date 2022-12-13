package com.example.javahomework;

import com.example.javahomework.model.Datasource;
import com.example.javahomework.model.FilterHolder;
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

import java.io.IOException;
import java.util.Objects;

public class ReportController {
    @FXML
    private TableView<Report> reportTableView;
    @FXML
    private TableColumn<Report, String> titleCol;
    @FXML
    private TableColumn<Report, String> categoryCol;
    @FXML
    private TableColumn<Report, String> manufacturerCol;
    @FXML
    private TableColumn<Report, String> modelCol;
    @FXML
    private TableColumn<Report, String> serialCol;
    @FXML
    private TableColumn<Report, String> faultCol;
    @FXML
    private TableColumn<Report, String> dateCol;
    @FXML
    private TableColumn<Report, String> technicianCol;
    FilterHolder filterHolder = FilterHolder.getInstance();

    ObservableList<Report> reports;

    private String serialNumber;
    private String model;
    private String customerName;

    public void initialize() {
        getFilteredData();
        reports = FXCollections.observableArrayList(Datasource.getInstance().getReport(customerName, model, serialNumber));
        loadData();
        reportTableView.setItems(reports);
    }

    public void loadData() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("customerTitle"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("productCategory"));
        manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("productManufacturer"));
        modelCol.setCellValueFactory(new PropertyValueFactory<>("productModel"));
        serialCol.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        faultCol.setCellValueFactory(new PropertyValueFactory<>("faultDescription"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("repairDate"));
        technicianCol.setCellValueFactory(new PropertyValueFactory<>("technicianName"));
    }

    private void getFilteredData() {
        customerName = filterHolder.getCustomerName();
        model = filterHolder.getModel();
        serialNumber = filterHolder.getSerialNumber();
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
        Scene scene = ((Node) event.getSource()).getScene();
        scene.setRoot(root);
    }
}
