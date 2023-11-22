package com.rockncode.Models;

import java.time.LocalDate;

public class Song {
    private String name;
    private String genre;
    private LocalDate release;
    private Album album;

    public Song(String name, String genre, LocalDate date) {
        this.name = name;
        this.genre = genre;
        this.release = date;
        this.album = null;
    }

    public Song(String name, String genre, LocalDate date, Album album) {
        this.name = name;
        this.genre = genre;
        this.release = date;
        this.album = album;
    }

    /**
     * Getters and Setters
     */

    public Album getAlbum() {
        return album;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public LocalDate getrelease() {
        return release;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setrelease(LocalDate release) {
        this.release = release;
    }

    /**
     * Custom Methods
     */

    public String show() {
        return String.format("%s - %s - %s - %s",
                name, genre, release, album != null ? album.getName() : "");
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Nombre de la canción: ").append(name).append("\n");
        sb.append("Género: ").append(genre).append("\n");
        sb.append("Fecha de lanzamiento: ").append(release).append("\n");
        sb.append("Álbum: ").append((album != null) ? album.getName() : "Sin álbum asociado").append("\n");
        return sb.toString();

    }
}
