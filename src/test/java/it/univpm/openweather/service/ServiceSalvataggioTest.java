package it.univpm.openweather.service;

import it.univpm.openweather.model.Citta;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceSalvataggioTest {

    private Citta city;
    private String name;
    @BeforeEach
    void setUp() throws JSONException, URISyntaxException {
        ServiceAPICall serviceAPICall = new ServiceAPICall();
        JSONObject objCity = serviceAPICall.getCity("Rome");
        JSONObject getCity = objCity.getJSONObject("city");
        name = getCity.getString("name");
        city = new Citta("Rome");
        city.setNome(name);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCityInfo() {
        assertEquals("Rome",city.getNome());
    }
}