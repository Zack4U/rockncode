package com.rockncode.Models;

import java.util.ArrayList;
import java.util.List;

public class Band {
    private String name;
    private String genre;
    private String history;
    private List<Member> members;
    private List<Album> albums;
    private List<Concert> concerts;

    public Band(String name) {
        this.name = name;
        this.genre = "";
        this.history = "";
        this.members = new ArrayList<Member>();
        this.albums = new ArrayList<Album>();
        this.concerts = new ArrayList<Concert>();
    }

    /**
     * Getters and Setters
     */
    public String getGenre() {
        return genre;
    }

    public String getHistory() {
        return history;
    }

    public List<Member> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    /**
     * Custom Methods
     */

    /**
     * Get member throw its name
     * 
     * @param name
     * @return member info
     */
    public Member getMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    /**
     * Delete member from the band
     * 
     * @param name
     * @return boolean
     */
    public boolean deleteMember(String name) {
        Member member = getMember(name);
        return this.members.remove(member);
    }

    /**
     * Add member to the band
     * 
     * @param member
     * @return boolean
     */
    public boolean addMember(Member member) {
        return this.members.add(member);
    };
}
