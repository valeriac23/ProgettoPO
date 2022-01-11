package it.univpm.openweather.service;
import java.net.*;
import java.lang.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ServiceSpeed{

    private static String api_key = "06d32b64e3cb4b1823645e35975b7053";
    private String city;



    public JSONObject getCity(String city) throws JSONException,URISyntaxException {
        this.city = city;
        JSONObject obj;
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + api_key;

        RestTemplate rt = new RestTemplate();
        //URI uri = new URI(url);

        obj =  new JSONObject(rt.getForObject(url,String.class));
        System.out.println(obj);

        return obj;


    }


    public JSONObject getForecast(String city) throws JSONException, URISyntaxException {
        JSONObject objCity = getCity(city);
        JSONObject objReturn = new JSONObject();
        JSONArray arrayReturn = new JSONArray();
        JSONObject obj = new JSONObject();
        JSONObject counter;
        String dt_txt;
        double speed;

        JSONArray arrayWeather = objCity.getJSONArray("list");

        for(int i = 0;i < arrayWeather.length();i++ ){
            counter = (JSONObject) arrayWeather.get(i);
            JSONObject wind = counter.getJSONObject("wind");
            speed = wind.getDouble("speed");
            dt_txt = counter.getString("dt_txt");

            obj.put("Vento(Speed)",speed);
            obj.put("Data",dt_txt);


            arrayReturn.put(obj);
        }



        objReturn.put("Tempo Vento",arrayReturn);
        System.out.println(objReturn);

        return objReturn;


    }
}
