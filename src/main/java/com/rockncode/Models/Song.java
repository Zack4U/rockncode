package com.rockncode.Models;

import java.time.LocalDate;

public class Song {
    private String name;
    private String genre;
    private LocalDate realease;
    private Album album;

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

    public LocalDate getRealease() {
        return realease;
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

    public void setRealease(LocalDate realease) {
        this.realease = realease;
    }

    /**
     * Custom Methods
     */
}
