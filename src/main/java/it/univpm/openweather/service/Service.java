package it.univpm.openweather.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface Service {

    public abstract JSONObject getCity(String city);
    public abstract JSONArray getInfo(String city);
    public abstract String salvataggioFile(String city);
    public abstract String salvataggioOra(String city);

}
