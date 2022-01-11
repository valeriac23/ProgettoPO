package it.univpm.openweather.service;

import it.univpm.openweather.model.*;
import it.univpm.openweather.model.filter.*;

import java.time.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.*;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ServiceSalvataggio {
    private static String api_key = "06d32b64e3cb4b1823645e35975b7053";
    private Object nome;


    public JSONObject getCity(String city) throws URISyntaxException, JSONException {
        JSONObject obj;
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + api_key;
        /*try {
            URI uri = new URI(url);*/

        RestTemplate rt = new RestTemplate();

        obj = new JSONObject(rt.getForObject(url,String.class));
        /*} catch (URISyntaxException e) {
            e.printStackTrace();
        }*/
        return obj;
    }

    public Citta getCityInfo(String cityName) throws JSONException, URISyntaxException {

        JSONObject objCity = getCity(cityName);


        Citta city = new Citta();
        DatiVento datiVento = new DatiVento();
        Forecast forecast = new Forecast();





        double speed;
        JSONObject getWind = objCity.getJSONObject("wind");
        speed = getWind.getDouble("speed");
        datiVento.setVelVento(speed);

        double temp = 0,feels_like = 0,temp_min = 0,temp_max = 0;
        JSONObject getMain = objCity.getJSONObject("main");
        for(int i = 0; i < getMain.length();i++){
            temp = getMain.getDouble("temp");
            feels_like = getMain.getDouble("feels_like");
            temp_max = getMain.getDouble("temp_max");
            temp_min = getMain.getDouble("temp_min");
        }
        forecast.setTemp(temp);
        forecast.setFeels_like(feels_like);
        forecast.setTemp_MAX(temp_max);
        forecast.setTemp_MIN(temp_min);


        String name;
        name = objCity.getString("name");
        long id;
        id = objCity.getLong("id");


        city.setNome(name);
        city.setidcitta(id);

        Vector<DatiVento> vector = new Vector<DatiVento>(getWind.length());
        vector.add(datiVento);

        city.setVelVento(vector);

        Vector<Forecast> vector1 = new Vector<>(getMain.length());
        vector1.add(forecast);
        city.setForecast(vector1);

        return city;



    }

    public JSONObject toJSON (Citta city) throws JSONException {
        JSONObject listobj = new JSONObject();
        listobj.put("name", city.getNome());
        listobj.put("idcittà", city.getidcitta());

        for (int i = 0; i < city.getVelVento().size(); i++) {
            listobj.put("data", (city.getVelVento()).get(i).getDataora());
            listobj.put("velocità", (city.getVelVento()).get(i).getVelVento());
        }

        Forecast fct = new Forecast();
        JSONArray MainArr = new JSONArray();
        JSONObject Mainlist = new JSONObject();
        Mainlist.put("data", (fct.getTime()));
        Mainlist.put("main", (fct.getMain()));
        Mainlist.put("temp", (fct.getTemp()));
        Mainlist.put("temp_max", (fct.getTemp_MAX()));
        Mainlist.put("temp_min", (fct.getTemp_MIN()));
        Mainlist.put("feels_like", (fct.getFeels_like()));
        MainArr.put(Mainlist);
        Mainlist.put("Main", MainArr);

        return Mainlist;

    }


    public String salvataggio(String cityName) throws JSONException, URISyntaxException {

        Citta city = getCityInfo(cityName);

        JSONObject objCity = toJSON(city);

        LocalDate today = LocalDate.now();

        String nomeFile = cityName+"-"+today;

        String rotta = System.getProperty("user.dir")+"\\" + nomeFile+".txt";

        try{
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(rotta)));

            output.println(objCity.toString());
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rotta;


    }

    public void  salvataggioOgniOra (String namecity){
        String rotta = System.getProperty("user.dir")+ "src/main/java/"+ namecity + "salvataggioOra.json";
        File file = new File(rotta);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Citta city = getCityInfo(namecity);

                    JSONObject objCity = toJSON(city);

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                try{
                    if(!file.exists()){
                        file.createNewFile();
                    }


                    FileWriter fileWriter = new FileWriter(file,true);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


                    Currency objCity = null;
                    bufferedWriter.write(objCity.toString());
                    bufferedWriter.write("\n");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,0,36000);

    }
}







