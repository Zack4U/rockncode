package com.rockncode;

import org.junit.Test;

import com.rockncode.Models.Band;
import com.rockncode.Models.Concert;
import com.rockncode.Models.Fanatic;
import com.rockncode.Models.Song;
import com.rockncode.Exceptions.ConcertNotAvailableException;
import com.rockncode.Exceptions.InsufficientFundsException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FanaticTest {

    @Test
    public void testBuyTicketWithInsufficientFunds() {
        // Configuración de prueba
        Band band = new Band("Test Band");
        Fanatic fanatic = new Fanatic("Test Fanatic", "test@email.com", "Test Location", "Test Social");

        // Asegurarse de que haya conciertos disponibles en la banda
        List<Song> songs = new ArrayList<>(); // Asegúrate de tener canciones para la lista
        LocalDate date = LocalDate.now(); // Otra configuración según tu lógica
        String location = "Test Location";
        int capacity = 100;
        int ticketsAvailable = 50;
        double ticketPrice = 20.0;
        String status = "Activo";

        Concert concert = new Concert(songs, date, location, capacity, ticketsAvailable, ticketPrice, status);
        band.getConcerts().add(concert);

        // Asegurarse de que el fanático tenga fondos insuficientes
        double insufficientFunds = ticketPrice - 1; // Establecer un valor menor que el precio del boleto
        fanatic.setBalance(insufficientFunds);

        // Crear un fanático que intenta comprar un boleto
        try {
            fanatic.buyTicket(band);
            // Si no se lanzó ninguna excepción, la prueba falla
            fail("Se esperaba InsufficientFundsException, pero no se lanzó ninguna excepción.");
        } catch (ConcertNotAvailableException | InsufficientFundsException e) {
            // Asegurarse de que se lanzó la excepción correcta
            assertEquals("Fondos insuficientes", e.getMessage());
        } catch (Exception e) {
            // Manejar otras excepciones si es necesario
            fail("Se lanzó una excepción inesperada: " + e.getMessage());
        }
    }

}
