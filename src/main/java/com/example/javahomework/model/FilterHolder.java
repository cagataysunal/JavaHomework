package com.example.javahomework.model;

public class FilterHolder {
    private static final FilterHolder instance = new FilterHolder();

    private FilterHolder() {
    }

    public static FilterHolder getInstance() {
        return instance;
    }

    private String customerName;
    private String model;
    private String serialNumber;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
