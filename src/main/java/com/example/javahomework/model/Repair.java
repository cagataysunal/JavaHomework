package com.example.javahomework.model;

public class Repair {
    private int _id;
    private int product;
    private int customer;
    private String faultDescription;
    private int technician;
    private String dateTime;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public String getFaultDescription() {
        return faultDescription;
    }

    public void setFaultDescription(String faultDescription) {
        this.faultDescription = faultDescription;
    }

    public int getTechnician() {
        return technician;
    }

    public void setTechnician(int technician) {
        this.technician = technician;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
