package com.rockncode.Models;

public class Item {
    private String name;
    private String category;
    private String description;
    private double price;
    private int disponibility;

    public Item(String name, String category, String despcription, double price, int disponibility) {
        this.name = name;
        this.category = category;
        this.description = despcription;
        this.price = price;
        this.disponibility = disponibility;
    }

    /*
     * Getters and Setters
     */

    public String getCategory() {
        return category;
    }

    public String getdescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
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

    public void addStock(int stock) {
        this.setDisponibility(this.getDisponibility() + stock);
    }

    public void itemSold(int sale) {
        this.setDisponibility(this.getDisponibility() - sale);
    }

    public String show() {
        return String.format("%s - %s - Price: %.2f - %s - Disponibility: %d",
                name, category, price, description, disponibility);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(name).append("\n");
        sb.append("Categoria: ").append(category).append("\n");
        sb.append("description: ").append(description).append("\n");
        sb.append("Precio: $").append(price).append("\n");
        sb.append("Disponibles: ").append((disponibility != 0) ? getDisponibility() : "Sin stock").append("\n");
        return sb.toString();

    }
}
