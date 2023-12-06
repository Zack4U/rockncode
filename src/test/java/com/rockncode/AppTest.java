package com.rockncode;

import com.rockncode.Exceptions.AlbumNotAvailableException;
import com.rockncode.Models.*;
import org.junit.Test;

import com.rockncode.Exceptions.ConcertNotAvailableException;
import com.rockncode.Exceptions.InsufficientFundsException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {
    public static void main(String[] args) {
        // Crear una banda con un concierto programado
        Band band = createBandWithConcert();

        // Crear un fanático
        Fanatic fanatic = new Fanatic("John Doe", "john@example.com", "City", "SocialNetworks");

        // Darle fondos al fanático
        fanatic.addFunds(100.0);

        // Simular la interacción del usuario - Compra de boletos
        try {
            boolean compraExitosa = fanatic.buyTicket(band);
            if (compraExitosa) {
                System.out.println("Compra de boletos realizada con éxito.");
            } else {
                System.out.println("La compra de boletos no se completó.");
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Error: Fondos insuficientes - " + e.getMessage());
        } catch (ConcertNotAvailableException e) {
            System.out.println("Error: Tickets no disponibles - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error durante la compra de boletos: " + e.getMessage());
        }

        // Simular la interacción del usuario - Programación de álbum
        try {
            // Supongamos que "nombreAlbum" es el nombre del álbum
            String nombreAlbum = "nombreAlbum";

            // Supongamos que "fechaAlbum" es la fecha del álbum
            LocalDate fechaAlbum = LocalDate.now();

            // Supongamos que "price" es el precio del álbum
            double precio = 2000.0;

            // Programar un álbum y obtener la información del álbum creado
            Album album = band.scheduleAlbum(nombreAlbum, fechaAlbum, precio);

            // Mostrar por consola la información del álbum
            System.out.println("Álbum programado: " + album.toString());
        } catch (AlbumNotAvailableException e) {
            System.out.println("Error: Álbum no disponible - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error durante la programación del álbum: " + e.getMessage());
        }
    }

    private static Band createBandWithConcert() {
        // Crear una banda con un concierto programado
        Band band = new Band("Test Band");
        band.setGenre("Rock");
        band.setHistory("A great band with a test concert.");

        // Crear un concierto programado
        List<Song> songs = new ArrayList<>();
        Concert concert = new Concert(songs, LocalDate.now().plusDays(7), "Test Location", 100, 50, 20.0, "Activo");

        // Agregar el concierto a la lista de conciertos de la banda
        band.getConcerts().add(concert);

        return band;
    }
}
