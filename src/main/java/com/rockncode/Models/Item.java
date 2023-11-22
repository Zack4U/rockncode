package com.rockncode.Models;

public class Item {
    private String name;
    private String category;
    private String descripcion;
    private double price;
    private int disponibility;

    /*
     * Getters and Setters
     */

    public String getCategory() {
        return category;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDisponibility() {
        return disponibility;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDisponibility(int disponibility) {
        this.disponibility = disponibility;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
