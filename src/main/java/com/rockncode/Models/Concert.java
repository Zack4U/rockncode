package com.rockncode.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concert {
    private LocalDate date;
    private String ubication;
    private int ticketsAvailable;
    private int ticketsSold;
    private int capacity;
    private String status;
    private List<Song> songs;

    public Concert(List<Song> songs, LocalDate date, String ubication, int capacity, int ticketsAvailable,
            String status) {
        this.songs = songs;
        this.date = date;
        this.ubication = ubication;
        this.ticketsAvailable = ticketsAvailable;
        this.ticketsSold = 0;
        this.capacity = capacity;
        this.status = status;

    }

    /*
     * Getter and Setters
     */

    public int getCapacity() {
        return capacity;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public int getTicketsAvailable() {
        return ticketsAvailable;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public String getUbication() {
        return ubication;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setTicketsAvailable(int ticketsAvailable) {
        this.ticketsAvailable = ticketsAvailable;
    }

    public void setTicketsSold(int ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    /**
     * Custom Methods
     */

    public Song getSong(String name) {
        for (Song song : songs) {
            if (song.getName().equals(name)) {
                return song;
            }
        }
        return null;
    }

    public boolean addSong(Song song) {
        return this.songs.add(song);
    };

    public boolean removeSong(Song song) {
        return this.songs.remove(song);
    }

    public void addTicketSold() throws Exception {
        if (this.getTicketsAvailable() > 0) {
            this.setTicketsSold(this.getTicketsSold() + 1);
            this.setTicketsAvailable(this.getTicketsAvailable() - 1);
        } else {
            throw new Exception("Tickets no disponibles");
        }
    }

    public void addTicketSold(int quantity) throws Exception {
        if (this.getTicketsAvailable() >= quantity) {
            this.setTicketsSold(this.getTicketsSold() + quantity);
            this.setTicketsAvailable(this.getTicketsAvailable() - quantity);
        } else {
            throw new Exception("Tickets no disponibles");
        }
    }
}
