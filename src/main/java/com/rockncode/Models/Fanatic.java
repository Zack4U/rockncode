package com.rockncode.Models;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Fanatic {
    private String name;
    private String email;
    private String ubication;
    private String socialNetworks;
    private List<Concert> concerts;
    private double balance;

    public Fanatic(String name, String email, String ubication, String socialNetworks) {
        this.name = name;
        this.email = email;
        this.ubication = ubication;
        this.socialNetworks = socialNetworks;
        this.concerts = new ArrayList<>();
        this.balance = 0.0;
    }

    /*
     * Getters and Setters
     */

    public List<Concert> getConcerts() {
        return concerts;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSocialNetworks() {
        return socialNetworks;
    }

    public String getUbication() {
        return ubication;
    }

    public double getBalance() {
        return balance;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSocialNetworks(String socialNetworks) {
        this.socialNetworks = socialNetworks;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
     * Custom Methods
     */

    public void addFunds(double quantity) {
        this.balance = this.balance + quantity;
    }

    public boolean buyTicket(Band band) throws Exception {
        List<Concert> concerts = band.getConcerts();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("............ SELECT CONCERT .............");

            System.out.println("0. [ATRAS]");
            for (int i = 0; i < concerts.size(); i++) {
                System.out.println((i + 1) + ". " + concerts.get(i).show());
            }
            int option = sc.nextInt();
            if (option == 0) {
                return false;
            } else if (option > 0 && option <= concerts.size()) {
                Concert concert = concerts.get(option - 1);
                do {
                    System.out.println("¿Cuantos tickets desea?");
                    int quantity = sc.nextInt();

                    if (quantity > 1) {
                        return concert.addTicketSold(this, quantity);
                    } else if (quantity == 1) {
                        return concert.addTicketSold(this);
                    } else {
                        System.out.println("Debe elegir mas de 1 ticket");
                    }
                } while (true);
            } else {
                System.out.println("Concierto invalido");
            }

        } while (true);
    }

    public boolean addFunds() {
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        if (amount > 0) {
            this.setBalance(this.getBalance() + amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del fanático: ").append(name).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Ubicación: ").append(ubication).append("\n");
        sb.append("Redes sociales: ").append(socialNetworks).append("\n");

        sb.append("Conciertos asistidos:\n");
        if (concerts.isEmpty()) {
            sb.append("  - No ha asistido a ningún concierto\n");
        } else {
            for (Concert concert : concerts) {
                sb.append("  - ").append(concert.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}
