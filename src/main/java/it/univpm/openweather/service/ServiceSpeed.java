package it.univpm.openweather.service;
import java.net.*;
import java.lang.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ServiceSpeed extends ServiceAPICall{




    public JSONObject getForecast(String cityName) throws JSONException, URISyntaxException {
        JSONObject objCity = getCity(cityName);
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
