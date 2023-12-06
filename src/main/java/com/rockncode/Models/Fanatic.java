package com.rockncode.Models;

import com.rockncode.Exceptions.AlbumNotAvailableException;
import com.rockncode.Exceptions.ConcertNotAvailableException;
import com.rockncode.Exceptions.InsufficientFundsException;
import com.rockncode.Exceptions.MerchandisingNotAvailableException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Fanatic {
    private String name;
    private String email;
    private String ubication;
    private String socialNetworks;
    private double balance;
    private List<Concert> concerts;

    public Fanatic(String name, String email, String ubication, String socialNetworks) {
        this.name = name;
        this.email = email;
        this.ubication = ubication;
        this.socialNetworks = socialNetworks;
        this.balance = 0.0;
    }

    // Getters and Setters

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

    // Custom Methods

    public void addFunds(double quantity) {
        this.balance = this.balance + quantity;
    }

    public boolean buyTicket(Band band) throws ConcertNotAvailableException, InsufficientFundsException {
        List<Concert> concerts = band.getConcerts();
        Scanner sc = new Scanner(System.in);

        // Verificar si hay conciertos disponibles
        if (concerts.isEmpty()) {
            throw new ConcertNotAvailableException("No hay conciertos disponibles para la compra de boletos.");
        }

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

                    if (quantity > 0) {
                        concert.addTicketSold(this, quantity);
                        return true;
                    } else {
                        System.out.println("Debe elegir al menos 1 ticket.");
                    }
                } while (true);
            } else {
                System.out.println("Concierto invalido");
            }
        } while (true);
    }

    public boolean buyAlbum(Band band) throws AlbumNotAvailableException, InsufficientFundsException {
        List<Album> albums = band.getAlbums();
        Scanner sc = new Scanner(System.in);

        // Verificar si hay albunes disponibles
        if (albums.isEmpty()) {
            throw new AlbumNotAvailableException("No hay albunes disponibles para la compra.");
        }

        do {
            System.out.println("............ SELECT ALBUM .............");
            System.out.println("0. [ATRAS]");

            for (int i = 0; i < albums.size(); i++) {
                System.out.println((i + 1) + ". " + albums.get(i).show());
            }

            int option = sc.nextInt();

            if (option == 0) {
                return false;
            } else if (option > 0 && option <= albums.size()) {
                Album album = albums.get(option - 1);

                do {
                    System.out.println("¿Cuantos albunes desea?");
                    int quantity = sc.nextInt();

                    if (quantity > 0) {
                        album.buyAlbum(this, quantity);
                        return true;
                    } else {
                        System.out.println("Debe elegir al menos 1 album.");
                    }
                } while (true);
            } else {
                System.out.println("Album invalido");
            }
        } while (true);
    }

    public boolean writeReview(Band band) throws AlbumNotAvailableException {
        List<Album> albums = band.getAlbums();
        Scanner sc = new Scanner(System.in);

        // Verificar si hay albunes disponibles
        if (albums.isEmpty()) {
            throw new AlbumNotAvailableException("No hay albunes disponibles para la review.");
        }

        do {
            System.out.println("............ SELECT ALBUM .............");
            System.out.println("0. [ATRAS]");

            for (int i = 0; i < albums.size(); i++) {
                System.out.println((i + 1) + ". " + albums.get(i).show());
            }

            int option = sc.nextInt();

            if (option == 0) {
                return false;
            } else if (option > 0 && option <= albums.size()) {
                Album album = albums.get(option - 1);

                do {
                    System.out.println("Escriba la reseña");
                    String review = sc.nextLine();

                    if (!review.isEmpty()) {
                        album.addReview(review);
                        return true;
                    } else {
                        System.out.println("Debe escribir algo");
                    }
                } while (true);
            } else {
                System.out.println("Album invalido");
            }
        } while (true);
    }

    public boolean buyMerchandising(Band band) throws MerchandisingNotAvailableException, InsufficientFundsException {
        List<Item> items = band.getMerchandising();
        Scanner sc = new Scanner(System.in);
        Map<Item, Integer> orders = new HashMap<Item, Integer>();

        // Verificar si hay items disponibles
        if (items.isEmpty()) {
            throw new MerchandisingNotAvailableException("No hay items disponibles para la compra.");
        }

        do {
            System.out.println("............ SELECT ITEM .............");
            System.out.println("0. [FINALIZAR]");

            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).show());
            }

            int option = sc.nextInt();

            if (option == 0) {
                break;
            } else if (option > 0 && option <= items.size()) {
                Item item = items.get(option - 1);

                do {
                    System.out.println("¿Cuantos desea?");
                    int quantity = sc.nextInt();

                    if (quantity > 0) {
                        orders.put(item, quantity);
                        break;
                    } else {
                        System.out.println("Debe elegir al menos 1 item.");
                    }
                } while (true);
            } else {
                System.out.println("Item invalido");
            }
        } while (true);
        System.out.println("Ingrese la direccion de entrega");
        String address = sc.nextLine();
        Order order = new Order(band.getOrders().size() + 1, orders, this, address, "Pedido Realizado");
        band.addOrder(order);
        return true;
    }

    // -----------------------------------------------------------------------------------------------------

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
