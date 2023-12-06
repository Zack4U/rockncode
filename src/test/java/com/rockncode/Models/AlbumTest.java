package com.rockncode.Models;

import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AlbumTest {

    @Test
    public void testAddSong() {
        // Crear un álbum de prueba
        Album testAlbum = new Album("Test Album", LocalDate.now(), new ArrayList<>());

        // Crear una canción de prueba sin asociarla a un álbum
        Song song1 = new Song("Song 1", "Rock", LocalDate.now());

        // Agregar la canción al álbum
        assertTrue(testAlbum.addSong(song1));

        // Verificar que la canción está en el álbum
        assertTrue(testAlbum.getSongs().contains(song1));
    }
}

