package it.univpm.openweather.service;

import it.univpm.openweather.model.Citta;
import it.univpm.openweather.model.filter.Forecast;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Vector;

@Service
public class ServiceFilterStats {
    private static String api_key = "06d32b64e3cb4b1823645e35975b7053";
    private Object nome;


    public JSONObject getCity(String city) {
        JSONObject obj = new JSONObject();
        String url = "api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_key;
        try {
            URI uri = new URI(url);
            RestTemplate rt = new RestTemplate();

            obj = rt.getForObject(uri, JSONObject.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public Citta getCityInfo(String name){

        JSONObject objCity = getCity(name);


        Citta city = new Citta();
        return city;



    }
}







