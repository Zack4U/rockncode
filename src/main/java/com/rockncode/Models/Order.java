package com.rockncode.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rockncode.Exceptions.InsufficientFundsException;

public class Order {
    private int id;
    private double total;
    private String address;
    private String status;
    private Fanatic fanatic;
    private Map<Item, Integer> items;

    public Order(int id, Map<Item, Integer> items, Fanatic fanatic, String address, String status)
            throws InsufficientFundsException {
        this.items = items;
        this.fanatic = fanatic;
        this.address = address;
        this.status = status;
        this.total = this.calculateTotal(items);
        this.id = id;
        this.buy(fanatic, total);
    }

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

    public Fanatic getFanatic() {
        return fanatic;
    }

    public Map<Item, Integer> getItems() {
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

    public void setFanatic(Fanatic fanatic) {
        this.fanatic = fanatic;
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = items;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double calculateTotal(Map<Item, Integer> items) {
        double sum = 0.0;

        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();

            double cost = item.getPrice() * quantity;

            sum += cost;
        }

        return sum;
    }

    private boolean buy(Fanatic fan, double total) throws InsufficientFundsException {
        if (fanatic.getBalance() < total) {
            throw new InsufficientFundsException("Fondos insuficientes para los productos");
        } else {
            this.setStatus("Pedido Confirmado");
            System.out.println("Pedido Confirmado");
            return true;
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Fanatic: ").append(fanatic.getName()).append("\n");
        sb.append("Items:\n");
        for (Map.Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            sb.append("  - ").append(item.getName()).append(" : ").append(quantity).append("\n");
        }
        sb.append("Total: ").append(total).append("\n");
        sb.append("Address: ").append(address).append("\n");
        sb.append("Status: ").append(status).append("\n");

        return sb.toString();

    }
}
