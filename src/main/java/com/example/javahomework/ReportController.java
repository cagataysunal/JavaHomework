package com.example.javahomework;

import com.example.javahomework.model.Datasource;
import com.example.javahomework.model.Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
}
