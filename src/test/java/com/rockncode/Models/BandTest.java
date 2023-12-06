package com.rockncode.Models;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class BandTest {

    private Band testBand;

    @Before
    public void setUp() {
        // Este método se ejecuta antes de cada prueba
        // Puedes inicializar objetos o realizar otras configuraciones aquí
        testBand = new Band("Test Band");
    }

    @Test
    public void testAddMember() {
        Member member = new Member("John Doe", "Guitar", "10 years");

        // Prueba que el miembro se agregue correctamente
        assertTrue(testBand.addMember(member));

        // Prueba que el miembro esté presente en la lista de miembros
        assertTrue(testBand.getMembers().contains(member));
    }

    @Test
    public void testDeleteMember() {
        // Arrange
        Band testBand = new Band("Test Band");

        // Act and Assert
        try {
            boolean deleted = testBand.deleteMember("John Doe");
            assertFalse(deleted);
            // También puedes imprimir el estado de la banda para obtener más información
            System.out.println("Estado actual de la banda: " + testBand);
        } catch (Exception e) {
            // Maneja la excepción, puedes imprimir el mensaje de la excepción si lo deseas
            e.printStackTrace();
        }
    }




    @Test
    public void testSetGenre() {
        String newGenre = "New Genre";

        // Prueba que el género se cambie correctamente
        testBand.setGenre(newGenre);
        assertEquals(newGenre, testBand.getGenre());
    }

    @Test
    public void testSetHistory() {
        String newHistory = "New History";

        // Prueba que la historia se cambie correctamente
        testBand.setHistory(newHistory);
        assertEquals(newHistory, testBand.getHistory());
    }

    @Test
    public void testGetMembers() {
        Member member1 = new Member("John Doe", "Guitar", "10 years");
        Member member2 = new Member("Jane Doe", "Bass", "8 years");

        // Agrega miembros a la banda
        testBand.addMember(member1);
        testBand.addMember(member2);

        // Obtiene la lista de miembros y verifica que contiene los miembros agregados
        List<Member> members = testBand.getMembers();
        assertTrue(members.contains(member1));
        assertTrue(members.contains(member2));
    }

    // Agrega más métodos de prueba según sea necesario
}
