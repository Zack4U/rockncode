package com.rockncode.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Album {
	private String name;
	private LocalDate release;
	private List<String> reviews;
	private int sales;
	private List<String> topHits;
	private List<Song> songs;

	public Album(String name, LocalDate release, List<Song> songs) {
		this.name = name;
		this.release = release;
		this.songs = songs;
		this.reviews = new ArrayList<String>();
		this.sales = 0;
		this.topHits = new ArrayList<String>();
		for (Song s : this.songs) {
			s.setAlbum(this);
		}
	}

	/*
	 * Getters and Setters
	 */

	public String getName() {
		return name;
	}

	public LocalDate getRelease() {
		return release;
	}

	public List<String> getReview() {
		return reviews;
	}

	public int getSales() {
		return sales;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public List<String> getTopHits() {
		return topHits;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRelease(LocalDate release) {
		this.release = release;
	}

	public void setReview(List<String> review) {
		this.reviews = review;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public void setTopHits(List<String> topHits) {
		this.topHits = topHits;
	}

	/**
	 * Custom methods
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

	public void addSale() {
		this.setSales(getSales() + 1);
	}

	public void addSale(int quantity) {
		this.setSales(getSales() + quantity);
	}

	public void addReview(String review) {
		this.reviews.add(review);
	}

	public void addTopHit(String hit) {
		this.topHits.add(hit);
	}

	public boolean deleteTopHit(String hit) {
		return this.topHits.remove(hit);
	}

	public String show() {
		return String.format("%s - %s - %d",
				name, release, songs.size());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nombre del álbum: ").append(name).append("\n");
		sb.append("Fecha de lanzamiento: ").append(release).append("\n");
		sb.append("Canciones:\n");
		for (int i = 0; i < songs.size(); i++) {
			sb.append("  ").append(i + 1).append(". ").append(songs.get(i).getName()).append("\n");
		}
		sb.append("Ventas: ").append(sales).append("\n");
		sb.append("Reseñas: ").append(reviews.isEmpty() ? "Sin reseñas" : reviews).append("\n");
		sb.append("Éxitos: ").append(topHits.isEmpty() ? "Sin éxitos" : topHits).append("\n");
		return sb.toString();
	}
}
