package com.example.javahomework.model.equipment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class SparePartHelper {

    private final Map<String, ObservableList<String>> sparePartMap;
    private static SparePartHelper sparePartHelper = null;

    private SparePartHelper() {

        sparePartMap = new HashMap<>();


        sparePartMap.put("Toshiba", FXCollections.observableArrayList("toshibaSpare1", "toshibaSpare2", "toshibaSpare3"));
        sparePartMap.put("Zebra", FXCollections.observableArrayList("zebraSpare1", "zebraSpare2", "zebraSpare3"));
        sparePartMap.put("OEM", FXCollections.observableArrayList("oemSpare1", "oemSpare2", "oemSpare3"));
    }

    public static SparePartHelper getInstance() {
        if (sparePartHelper == null) sparePartHelper = new SparePartHelper();
        return sparePartHelper;
    }

    public Map<String, ObservableList<String>> getTerminalMap() {
        return sparePartMap;
    }
}
