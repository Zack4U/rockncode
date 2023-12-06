package com.rockncode.Models;

import com.rockncode.Exceptions.ConcertNotAvailableException;
import com.rockncode.Exceptions.InsufficientFundsException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FanaticTest {

    private Fanatic testFanatic;
    private Band testBand;
    private Concert testConcert;

    @Before
    public void setUp() {
        // Crear Fanatic de prueba
        testFanatic = new Fanatic("Test Fanatic", "test@example.com", "Test Location", "Test Social Media");

        // Crear Band de prueba
        testBand = new Band("Test Band");  // Usar el constructor existente

        // Crear Concert de prueba
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Test Song", "Test Genre", null));
        testConcert = new Concert(songs, null, "Test Location", 100, 50, 25.0, "Active");
    }




    @Test
    public void testGetConcerts() {
        assertNull(testFanatic.getConcerts());
    }

    @Test
    public void testGetEmail() {
        assertEquals("test@example.com", testFanatic.getEmail());
    }

    @Test
    public void testGetName() {
        assertEquals("Test Fanatic", testFanatic.getName());
    }

    @Test
    public void testGetSocialNetworks() {
        assertEquals("Test Social Media", testFanatic.getSocialNetworks());
    }

    @Test
    public void testGetUbication() {
        assertEquals("Test Location", testFanatic.getUbication());
    }

    @Test
    public void testGetBalance() {
        assertEquals(0.0, testFanatic.getBalance(), 0.01);
    }

    @Test
    public void testSetConcerts() {
        List<Concert> concerts = new ArrayList<>();
        concerts.add(testConcert);
        testFanatic.setConcerts(concerts);
        assertEquals(concerts, testFanatic.getConcerts());
    }

    @Test
    public void testSetEmail() {
        testFanatic.setEmail("new_email@example.com");
        assertEquals("new_email@example.com", testFanatic.getEmail());
    }

    @Test
    public void testSetName() {
        testFanatic.setName("New Fanatic Name");
        assertEquals("New Fanatic Name", testFanatic.getName());
    }

    @Test
    public void testSetSocialNetworks() {
        testFanatic.setSocialNetworks("New Social Media");
        assertEquals("New Social Media", testFanatic.getSocialNetworks());
    }

    @Test
    public void testSetUbication() {
        testFanatic.setUbication("New Location");
        assertEquals("New Location", testFanatic.getUbication());
    }

    @Test
    public void testSetBalance() {
        testFanatic.setBalance(50.0);
        assertEquals(50.0, testFanatic.getBalance(), 0.01);
    }

    @Test
    public void testAddFunds() {
        testFanatic.addFunds(30.0);
        assertEquals(30.0, testFanatic.getBalance(), 0.01);
    }

    @Test
    public void testBuyTicket() throws ConcertNotAvailableException, InsufficientFundsException {
        // Configuración de concierto y banda
        List<Concert> concerts = new ArrayList<>();
        concerts.add(testConcert);
        testBand.setConcerts(concerts);
        testFanatic.setBalance(100.0);

        assertTrue(testFanatic.buyTicket(testBand));
        assertEquals(1, testConcert.getTicketsSold());
        assertEquals(75.0, testFanatic.getBalance(), 0.01);
    }

    @Test(expected = ConcertNotAvailableException.class)
    public void testBuyTicketConcertNotAvailable() throws ConcertNotAvailableException, InsufficientFundsException {
        testFanatic.buyTicket(testBand);  // Intentar comprar boleto sin conciertos disponibles
    }

    @Test(expected = InsufficientFundsException.class)
    public void testBuyTicketInsufficientFunds() throws ConcertNotAvailableException, InsufficientFundsException {
        // Configuración de concierto y banda
        List<Concert> concerts = new ArrayList<>();
        concerts.add(testConcert);
        testBand.setConcerts(concerts);

        testFanatic.buyTicket(testBand);  // Intentar comprar boleto sin fondos suficientes
    }

    @Test
    public void testToString() {
        String expected = "Nombre del fanático: Test Fanatic\n" +
                "Email: test@example.com\n" +
                "Ubicación: Test Location\n" +
                "Redes sociales: Test Social Media\n" +
                "Conciertos asistidos:\n" +
                "  - No ha asistido a ningún concierto\n";
        assertEquals(expected, testFanatic.toString());
    }
}
