package it.univpm.openweather.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CittaTest {
    private Citta city;

    @AfterEach
    void tearDown() {

    }

    @BeforeEach
    void setUp() {
        city = new Citta("Roma",5134295);
    }

    @Test
    void getNome() {
        assertEquals("Roma",city.getNome());
    }

    @Test
    void getidcitta() {
        assertEquals(5134295,city.getidcitta());
    }
}