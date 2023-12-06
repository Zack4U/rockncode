package com.rockncode.Models;

import static org.junit.Assert.*;
        import org.junit.Test;
        import java.time.LocalDate;
        import java.util.ArrayList;
        import java.util.List;

public class SongTest {

    @Test
    public void testGetAlbum() {
        Album testAlbum = new Album("Test Album", LocalDate.now(), new ArrayList<>());
        Song testSong = new Song("Test Song", "Rock", LocalDate.now(), testAlbum);

        assertEquals(testAlbum, testSong.getAlbum());
    }

    @Test
    public void testGetGenre() {
        Song testSong = new Song("Test Song", "Rock", LocalDate.now());

        assertEquals("Rock", testSong.getGenre());
    }

    @Test
    public void testGetName() {
        Song testSong = new Song("Test Song", "Rock", LocalDate.now());

        assertEquals("Test Song", testSong.getName());
    }

    @Test
    public void testGetRelease() {
        LocalDate releaseDate = LocalDate.now();
        Song testSong = new Song("Test Song", "Rock", releaseDate);

        assertEquals(releaseDate, testSong.getrelease());
    }

    @Test
    public void testSetAlbum() {
        Album testAlbum = new Album("Test Album", LocalDate.now(), new ArrayList<>());
        Song testSong = new Song("Test Song", "Rock", LocalDate.now());

        testSong.setAlbum(testAlbum);

        assertEquals(testAlbum, testSong.getAlbum());
    }

    @Test
    public void testSetGenre() {
        Song testSong = new Song("Test Song", "Rock", LocalDate.now());

        testSong.setGenre("Pop");

        assertEquals("Pop", testSong.getGenre());
    }

    @Test
    public void testSetName() {
        Song testSong = new Song("Test Song", "Rock", LocalDate.now());

        testSong.setName("New Song");

        assertEquals("New Song", testSong.getName());
    }

    @Test
    public void testSetRelease() {
        LocalDate releaseDate = LocalDate.now();
        Song testSong = new Song("Test Song", "Rock", LocalDate.now());

        testSong.setrelease(releaseDate);

        assertEquals(releaseDate, testSong.getrelease());
    }

    @Test
    public void testShow() {
        Album testAlbum = new Album("Test Album", LocalDate.now(), new ArrayList<>());
        Song testSong = new Song("Test Song", "Rock", LocalDate.now(), testAlbum);

        assertEquals("Test Song - Rock - " + LocalDate.now() + " - Test Album", testSong.show());
    }

    @Test
    public void testToString() {
        Album testAlbum = new Album("Test Album", LocalDate.now(), new ArrayList<>());
        Song testSong = new Song("Test Song", "Rock", LocalDate.now(), testAlbum);

        String expectedString = "Nombre de la canción: Test Song\n" +
                "Género: Rock\n" +
                "Fecha de lanzamiento: " + LocalDate.now() + "\n" +
                "Álbum: Test Album\n";

        assertEquals(expectedString, testSong.toString());
    }
}
