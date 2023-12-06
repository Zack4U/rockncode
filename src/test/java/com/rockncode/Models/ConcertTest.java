package com.rockncode.Models;

import com.rockncode.Exceptions.ConcertNotAvailableException;
import com.rockncode.Exceptions.InsufficientFundsException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConcertTest {

    private Concert testConcert;
    private List<Song> testSongs;

    @Before
    public void setUp() {
        // Crear canciones de prueba
        Song song1 = new Song("Song 1", "Genre 1", LocalDate.now());
        Song song2 = new Song("Song 2", "Genre 2", LocalDate.now());
        Song song3 = new Song("Song 3", "Genre 3", LocalDate.now());

        // Crear lista de canciones de prueba
        testSongs = new ArrayList<>();
        testSongs.add(song1);
        testSongs.add(song2);
        testSongs.add(song3);

        // Crear concierto de prueba
        testConcert = new Concert(testSongs, LocalDate.now(), "Location 1", 100, 50, 25.0, "Active");
    }

    @Test
    public void testGetCapacity() {
        assertEquals(100, testConcert.getCapacity());
    }

    @Test
    public void testGetDate() {
        assertEquals(LocalDate.now(), testConcert.getDate());
    }

    @Test
    public void testGetSongs() {
        assertEquals(testSongs, testConcert.getSongs());
    }

    @Test
    public void testGetTicketsAvailable() {
        assertEquals(50, testConcert.getTicketsAvailable());
    }

    @Test
    public void testGetTicketsSold() {
        assertEquals(0, testConcert.getTicketsSold());
    }

    @Test
    public void testGetUbication() {
        assertEquals("Location 1", testConcert.getUbication());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Active", testConcert.getStatus());
    }

    @Test
    public void testGetFanatics() {
        assertNotNull(testConcert.getFanatics());
        assertTrue(testConcert.getFanatics().isEmpty());
    }

    @Test
    public void testGetTicketPrice() {
        assertEquals(25.0, testConcert.getTicketPrice(), 0.01);
    }

    @Test
    public void testSetCapacity() {
        testConcert.setCapacity(150);
        assertEquals(150, testConcert.getCapacity());
    }

    @Test
    public void testSetDate() {
        LocalDate newDate = LocalDate.now().plusDays(1);
        testConcert.setDate(newDate);
        assertEquals(newDate, testConcert.getDate());
    }

    @Test
    public void testSetSongs() {
        List<Song> newSongs = new ArrayList<>();
        newSongs.add(new Song("New Song", "New Genre", LocalDate.now()));
        testConcert.setSongs(newSongs);
        assertEquals(newSongs, testConcert.getSongs());
    }

    @Test
    public void testSetTicketsAvailable() {
        testConcert.setTicketsAvailable(30);
        assertEquals(30, testConcert.getTicketsAvailable());
    }

    @Test
    public void testSetTicketsSold() {
        testConcert.setTicketsSold(10);
        assertEquals(10, testConcert.getTicketsSold());
    }

    @Test
    public void testSetUbication() {
        testConcert.setUbication("New Location");
        assertEquals("New Location", testConcert.getUbication());
    }

    @Test
    public void testSetStatus() {
        testConcert.setStatus("Inactive");
        assertEquals("Inactive", testConcert.getStatus());
    }

    @Test
    public void testSetFanatics() {
        List<Fanatic> newFanatics = new ArrayList<>();
        Fanatic fanatic = new Fanatic("Fanatic 1", "fanatic@example.com", "Location 1", "Social Media");
        newFanatics.add(fanatic);
        testConcert.setFanatics(newFanatics);
        assertEquals(newFanatics, testConcert.getFanatics());
    }

    @Test
    public void testSetTicketPrice() {
        testConcert.setTicketPrice(30.0);
        assertEquals(30.0, testConcert.getTicketPrice(), 0.01);
    }

    @Test
    public void testAddSong() {
        Song newSong = new Song("New Song", "New Genre", LocalDate.now());
        assertTrue(testConcert.addSong(newSong));
        assertTrue(testConcert.getSongs().contains(newSong));
    }

    @Test
    public void testRemoveSong() {
        Song songToRemove = testSongs.get(0);
        assertTrue(testConcert.removeSong(songToRemove));
        assertFalse(testConcert.getSongs().contains(songToRemove));
    }

    @Test
    public void testAddTicketSold() throws InsufficientFundsException, ConcertNotAvailableException {
        Fanatic testFanatic = new Fanatic("Test Fanatic", "test@example.com", "Test Location", "Test Social Media");
        assertTrue(testConcert.addTicketSold(testFanatic, 2));
        assertEquals(2, testConcert.getTicketsSold());
        assertEquals(48, testConcert.getTicketsAvailable());
        assertTrue(testConcert.getFanatics().contains(testFanatic));
    }

    @Test(expected = InsufficientFundsException.class)
    public void testAddTicketSoldInsufficientFunds() throws InsufficientFundsException, ConcertNotAvailableException {
        Fanatic testFanatic = new Fanatic("Test Fanatic", "test@example.com", "Test Location", "Test Social Media");
        // Configuración de saldo insuficiente
        testFanatic.setBalance(10.0);
        testConcert.addTicketSold(testFanatic, 2);
    }

    @Test(expected = ConcertNotAvailableException.class)
    public void testAddTicketSoldConcertNotAvailable() throws InsufficientFundsException, ConcertNotAvailableException {
        // Configuración de entradas agotadas
        testConcert.setTicketsAvailable(0);
        Fanatic testFanatic = new Fanatic("Test Fanatic", "test@example.com", "Test Location", "Test Social Media");
        testConcert.addTicketSold(testFanatic, 1);
    }

    @Test
    public void testShow() {
        String expected = "Location 1 - " + LocalDate.now() + " - Available Tickets: 50 - Estado: Active";
        assertEquals(expected, testConcert.show());
    }

    @Test
    public void testToString() {
        String expected = "Fecha del concierto: " + LocalDate.now() + "\n" +
                "Ubicación: Location 1\n" +
                "Entradas disponibles: 50\n" +
                "Entradas vendidas: 0\n" +
                "Capacidad: 100\n" +
                "Estado: Active\n" +
                "Canciones:\n" +
                "  - Song 1\n" +
                "  - Song 2\n" +
                "  - Song 3\n" +
                "Fanáticos asistentes:\n";
        assertEquals(expected, testConcert.toString());
    }
}
