package com.rockncode.Models;

import com.rockncode.Exceptions.ConcertNotAvailableException;
import com.rockncode.Exceptions.InsufficientFundsException;
import com.rockncode.Exceptions.AlbumNotAvailableException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concert {
	private LocalDate date;
	private String ubication;
	private int ticketsAvailable;
	private int ticketsSold;
	private double ticketPrice;
	private int capacity;
	private String status;
	private List<Song> songs;
	private List<Fanatic> fanatics;

	public Concert(List<Song> songs, LocalDate date, String ubication, int capacity, int ticketsAvailable,
			double ticketPrice,
			String status) {
		this.songs = songs;
		this.date = date;
		this.ubication = ubication;
		this.ticketsAvailable = ticketsAvailable;
		this.ticketsSold = 0;
		this.ticketPrice = ticketPrice;
		this.capacity = capacity;
		this.status = status;
		this.fanatics = new ArrayList<Fanatic>();
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

	public String getStatus() {
		return status;
	}

	public List<Fanatic> getFanatics() {
		return fanatics;
	}

	public double getTicketPrice() {
		return ticketPrice;
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

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFanatics(List<Fanatic> fanatics) {
		this.fanatics = fanatics;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
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

	public boolean addTicketSold(Fanatic fanatic, int quantity) throws InsufficientFundsException, ConcertNotAvailableException {
		if (this.getTicketsAvailable() >= quantity) {
			if (fanatic.getBalance() < this.ticketPrice * quantity) {
				throw new InsufficientFundsException("Fondos insuficientes para comprar los boletos.");
			} else {
				this.setTicketsSold(this.getTicketsSold() + quantity);
				this.setTicketsAvailable(this.getTicketsAvailable() - quantity);
				this.fanatics.add(fanatic);
				System.out.println("Tickets vendidos: " + quantity);
				return true;
			}
		} else {
			throw new ConcertNotAvailableException("Tickets no disponibles.");
		}
	}



	public String show() {
		return String.format("%s - %s - Available Tickets: %s - Estado: %s",
				ubication, date, ticketsAvailable, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Fecha del concierto: ").append(date).append("\n");
		sb.append("Ubicación: ").append(ubication).append("\n");
		sb.append("Entradas disponibles: ").append(ticketsAvailable).append("\n");
		sb.append("Entradas vendidas: ").append(ticketsSold).append("\n");
		sb.append("Capacidad: ").append(capacity).append("\n");
		sb.append("Estado: ").append(status).append("\n");

		sb.append("Canciones:\n");
		for (Song song : songs) {
			sb.append("  - ").append(song.getName()).append("\n");
		}

		sb.append("Fanáticos asistentes:\n");
		for (Fanatic fanatic : fanatics) {
			sb.append("  - ").append(fanatic.getName()).append("\n");
		}

		return sb.toString();
	}
}
