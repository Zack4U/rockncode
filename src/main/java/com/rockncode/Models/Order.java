package com.rockncode.Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private double total;
    private String address;
    private String status;
    private Fanatic fanatic;
    private List<Item> items;

    /*
     * Getters and Setters
     */

    public String getAddress() {
        return address;
    }

    public Fanatic getClient() {
        return fanatic;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public double getTotal() {
        return total;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClient(Fanatic fanatic) {
        this.fanatic = fanatic;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
