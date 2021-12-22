package it.univpm.openweather.service;

import it.univpm.openweather.model.Citta;
import org.json.JSONArray;
import org.json.JSONObject;

public interface Service {

    public abstract JSONObject getCity(String city);
    public abstract JSONArray getInfo(String city);
    public abstract String salvataggioFile(String city);
    public abstract String salvataggioOra(String city);
    public abstract Citta getWind(String Città);

}
