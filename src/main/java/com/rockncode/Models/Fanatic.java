package com.rockncode.Models;

import java.util.List;
import java.util.ArrayList;

public class Fanatic {
    private String name;
    private String email;
    private String ubication;
    private String socialNetworks;
    private List<Concert> concerts;

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
}
