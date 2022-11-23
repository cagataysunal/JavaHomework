package com.example.javahomework.model.equipment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class PanelPCHelper {

    private final Map<String, ObservableList<String>> panelMap;
    private static PanelPCHelper panelPCHelper = null;

    private PanelPCHelper() {
        panelMap = new HashMap<>();
        panelMap.put("Toshiba", FXCollections.observableArrayList(
                "toshibaPanel1", "toshibaPanel2", "toshibaPanel3"
        ));
        panelMap.put("Zebra", FXCollections.observableArrayList(
                "zebraPanel1", "zebraPanel2", "zebraPanel3"
        ));
        panelMap.put("OEM", FXCollections.observableArrayList(
                "oemPanel1", "oemPanel2", "oemPanel3"
        ));
    }

    public static PanelPCHelper getInstance() {
        if (panelPCHelper == null)
            panelPCHelper = new PanelPCHelper();
        return panelPCHelper;
    }

    public Map<String, ObservableList<String>> getPanelMap() {
        return panelMap;
    }
}
