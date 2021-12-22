package it.univpm.openweather.service;

import it.univpm.openweather.model.Citta;
import it.univpm.openweather.model.Forecast;
import it.univpm.openweather.service.ServiceFilter;
import it.univpm.openweather.model.DatiVento;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Vector;

@Service
public class ServiceFilter{
    private static String api_key = "06d32b64e3cb4b1823645e35975b7053";
    private Object nome;


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
    public JSONObject getCityWeather(String city) throws JSONException {

        JSONObject obj;
        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid="+api_key;

        RestTemplate rt = new RestTemplate();

        obj = new JSONObject(rt.getForObject(url, String.class));

        return obj;

    }

    @Override
    public JSONObject getTempInfo(String Citta)
    {
        JSONObject temperatura = new JSONObject();

        String url = url + Citta + "&appid=" +  api_key;

        RestTemplate rt = new RestTemplate();

        try {
            temperatura = new JSONObject(rt.getForObject(url, String.class));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return temperatura;
    }

      public Citta getWind(String Citta) throws JSONException {

        JSONObject obj = getTempInfo(Citta);
        JSONObject main = obj.getJSONObject("main");

        Citta city = new Citta(String Citta);
        city = getTempInfo(String nome);

        Forecast temp = new Forecast();

        Vector<Forecast> vector = new Vector<Forecast>(main.length());
        vector.add(temp);

        city.setMain(vector);

        return city;
    }


    @Override
    public Citta getCityInfo(String nome) throws JSONException {
        JSONObject object = getTempInfo(String Citta);
        Citta city = new Citta(nome);
        int id=0;
        String cityObj=null;

        for(int i=0; i<object.length(); i++)
        {
            cityObj = (String) object.get("name");

            id = (int) object.get("id");
        }

        city.setNome(cityObj);
        city.setIdOpenW(id);

        return city;
    }



