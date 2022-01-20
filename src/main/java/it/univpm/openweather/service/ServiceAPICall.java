package it.univpm.openweather.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class ServiceAPICall {

    private String cityName;
    private static String api_key = "06d32b64e3cb4b1823645e35975b7053";

    public JSONObject getCity(String cityName) throws JSONException,URISyntaxException {
        this.cityName = cityName;
        JSONObject obj;
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + api_key;

        RestTemplate rt = new RestTemplate();
        URI uri = new URI(url);

        obj =  new JSONObject(rt.getForObject(uri,String.class));
        System.out.println(obj);

        return obj;


    }

}
