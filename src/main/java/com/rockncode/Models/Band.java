package com.rockncode.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public List<Concert> getConcerts() {
        return concerts;
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

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
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
     * @throws Exception
     */
    public boolean deleteMember(String name) throws Exception {
        Member member = getMember(name);
        if (member == null) {
            throw new Exception("El miembro " + name + " no existe en esta banda");
        }
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

    public Concert scheduleConcert(LocalDate date) throws Exception {
        if (!checkDate(date)) {
            throw new Exception("Fecha no valida");
        }
        List<Song> songs = this.scheduleSongs();

        if (songs.size() == 0) {
            System.out.println("Ninguna cancion seleccionada");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual es la ubicación del lugar?");
        String ubication = sc.nextLine();
        System.out.println("¿Cual es la capacidad del lugar?");
        int capacity = sc.nextInt();
        System.out.println("¿Cuántos tickts estaran disponibles?");
        int ticketsAvailable = sc.nextInt();
        System.out.println("¿Qué precio tendran los tickets?");
        double ticketPrice = sc.nextDouble();

        Concert concert = new Concert(songs, date, ubication, capacity, ticketsAvailable, ticketPrice, "Programado");
        this.concerts.add(concert);
        return concert;

    }

    private boolean checkDate(LocalDate date) {
        for (Concert concert : this.concerts) {
            if (concert.getDate().equals(date)) {
                return false;
            }
        }
        return true;
    }

    private List<Song> scheduleSongs() {
        Scanner sc = new Scanner(System.in);
        List<Song> songs = new ArrayList<>();
        boolean input = true;
        System.out.println("Seleccionar canciones...................");
        do {
            System.out.println("--------- SELECT ALBUM -------------");
            System.out.println("0. [FINISH]");
            int ca = 1;
            for (Album album : this.albums) {
                System.out.println(ca + ". " + album.show());
                ca++;
            }
            int indexAlbum = sc.nextInt();
            if (indexAlbum > 0 && indexAlbum <= this.albums.size()) {
                System.out.println("--------- SELECT SONG -------------");
                System.out.println("0. [RETURN]");
                int cs = 1;
                for (Song song : this.albums.get(indexAlbum - 1).getSongs()) {
                    System.out.println(cs + ". " + song.show());
                    cs++;
                }
                int indexSong = sc.nextInt();
                if (indexSong > 0 && indexSong <= this.albums.get(indexAlbum - 1).getSongs().size()) {
                    songs.add(this.albums.get(indexAlbum - 1).getSongs().get(indexSong - 1));
                } else if (indexSong == 0) {
                    input = true;
                } else {
                    System.out.println("Invalid Song");
                }
            } else if (indexAlbum == 0) {
                input = false;
            } else {
                System.out.println("Invalid Song");
            }
        } while (input);
        return songs;
    }

    public Album scheduleAlbum(String name, LocalDate date) {
        List<Song> songs = this.launchAlbum(date);
        Album album = new Album(name, date, songs);
        this.albums.add(album);
        return album;
    }

    public List<Song> launchAlbum(LocalDate date) {
        List<Song> songs = new ArrayList<Song>();
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("--------- NEW SONG -------------");
            System.out.println("[ESPACIO EN BLANCO PARA FINALIZAR]");
            System.out.println("Nombre de la cancion: ");
            String name = sc.nextLine();
            if (name.length() == 0) {
                return songs;
            }
            System.out.println("Genero de la cancion: ");
            String genre = sc.nextLine();
            Song song = new Song(name, genre, date);
            songs.add(song);
        } while (true);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre de la banda: ").append(name).append("\n");
        sb.append("Género: ").append(genre).append("\n");
        sb.append("Historia: ").append(history).append("\n");

        sb.append("Miembros:\n");
        for (Member member : members) {
            sb.append("  - ").append(member.getName()).append("\n");
        }

        sb.append("Albumes:\n");
        for (Album album : albums) {
            sb.append("  - ").append(album.getName()).append("\n");
        }

        sb.append("Conciertos:\n");
        for (Concert concert : concerts) {
            sb.append("  - ").append(concert.toString()).append("\n");
        }

        return sb.toString();
    }
}
