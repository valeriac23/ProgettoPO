package it.univpm.openweather.service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.stereotype.Service;

@Service
public class ServiceModel {


    private static String api_key = "06d32b64e3cb4b1823645e35975b7053";

    public JSONObject getCity(String city) {
        JSONObject obj = new JSONObject();
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid="+api_key;
        try {
            URI uri = new URI(url);
            RestTemplate rt = new RestTemplate();

            obj = rt.getForObject(uri, JSONObject.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return obj;

    }


    public org.json.simple.JSONArray getInfo(String city) {
        JSONObject jo =  getCity(city);
        JSONArray ja = new org.json.simple.JSONArray();
        JSONParser jsonParser= new JSONParser();
        JSONArray list = (JSONArray) jo.get("list");
        //JSONObject main = (JSONObject) list.get("main");
        double temp,temp_min,temp_max,feels_like,temp_kf;
        JSONObject o = null;
       try{


               JSONObject obj = new JSONObject();

               temp = (double) o.get("temp");
               System.out.println(temp);
               obj.put("Tempo",temp);
               temp_max = (double) o.get("tem_max");
               System.out.println(temp_max);
               obj.put("Temperatura massima", temp_max);
               temp_min = (double) o.get("temp_min");
               System.out.println(temp);
               obj.put("Temperatura minima",temp_min);
               feels_like = (double) o.get("feels_like");
               System.out.println(feels_like);
               obj.put("Temperatura percepita",feels_like);
               temp_kf = (double) o.get("temp_kf");
               System.out.println(temp_kf);
               obj.put("Temperatura kf",temp_kf);

               ja.add(obj);


       }catch (Exception e){
           System.out.println("Errore");
       }



        return ja;
    }


    public String salvataggioFile(String city) {
        return null;

    }


    public String salvataggioOra(String city) {
        return null;
    }
}
