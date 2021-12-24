package it.univpm.openweather.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import java.net.URI;
import java.net.URISyntaxException;


@Service
public class ServiceModel {


    private static String api_key = "06d32b64e3cb4b1823645e35975b7053";

    public JSONObject getCity(String city) throws JSONException {
        JSONObject obj;
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + api_key;
       // try {
            //URI uri = new URI(url);
            RestTemplate rt = new RestTemplate();

            obj = new JSONObject(rt.getForObject(url,String.class));
        //} catch (URISyntaxException e) {
           // e.printStackTrace();
       // }
        return obj;

    }


    public JSONArray getInfo(String city) throws JSONException {
        JSONObject obCity = getCity(city);
        JSONArray ja = new JSONArray();
        JSONArray array = obCity.getJSONArray("list");
        JSONObject counter = new JSONObject();
        int visibility;
        String date;

        for(int i=0; i < array.length();i++){
            JSONObject obj = new JSONObject();
            obj = array.getJSONObject(i);
            visibility =  obj.getInt("visibility");
            obj.put("Visibilità",visibility);
            date = obj.getString("dt_txt");
            obj.put("Data",date);
            ja.put(obj);


        }

        return ja;


    }
    public JSONArray getInfoMain(String city) throws JSONException {
        JSONObject obj = getCity(city);
        JSONArray ja = new JSONArray();

        return ja;
    }


    public String salvataggioFile(String city) {
        return null;

    }


    public String salvataggioOra(String city) {
        return null;
    }
}



