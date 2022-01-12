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

    /*public Citta getCityInfo(String cityName) throws JSONException, URISyntaxException {

        JSONObject objCity = getCity(cityName);

        Citta city = new Citta();
        DatiVento datiVento = new DatiVento();
        Forecast forecast = new Forecast();

        JSONObject getMain = objCity.getJSONObject("main");
        for(int i = 0; i < getMain.length();i++){
            JSONObject counter = getMain.getJSONObject(String.valueOf(i));
            forecast.setTemp(counter.getDouble("temp"));
            forecast.setFeels_like(counter.getDouble("feels_like"));
            forecast.setTemp_MAX(counter.getDouble("temp_min"));
            forecast.setTemp_MIN(counter.getDouble("temp_max"));
        }

        JSONObject prova = new JSONObject();
        JSONObject getWind = objCity.getJSONObject("wind");
        datiVento.setVelVento(getWind.getDouble("speed"));
        prova.put("Speed",getWind.getDouble("speed"));
        System.out.println(prova);

        city.setNome(objCity.getString("name"));
        city.setId(objCity.getLong("id"));

        Vector<DatiVento> vectorVento = new Vector<DatiVento>(getWind.length());
        vectorVento.add(datiVento);
        city.setVelVento(vectorVento);

        Vector<Forecast> vectorForecast = new Vector<>(getMain.length());
        vectorForecast.add(forecast);
        city.setForecast(vectorForecast);

        System.out.println(city);

        return city;



    }*/
    public Citta getCityInfo(String cityName) throws JSONException, URISyntaxException {
        JSONObject objCity = getCity(cityName);
        Citta city = new Citta(cityName);

        long id = objCity.getLong("id");
        String name = objCity.getString("name");

        city.setId(id);
        city.setNome(name);

        return city;
    }

    public Citta getCityFilter(String cityName) throws JSONException, URISyntaxException {
        JSONObject objCity = getCity(cityName);
        Citta city = new Citta(cityName);
        city = getCityInfo(cityName);

        Forecast forecast = new Forecast();
        JSONObject getMain = objCity.getJSONObject("main");
        forecast.setTemp(getMain.getDouble("temp"));
        forecast.setFeels_like(getMain.getDouble("feels_like"));
        forecast.setTemp_MIN(getMain.getDouble("temp_min"));
        forecast.setTemp_MAX(getMain.getDouble("temp_max"));

        Vector<Forecast> vectorF = new Vector<Forecast>(getMain.length());
        vectorF.add(forecast);


        city.setForecast(vectorF);



        return city;
    }

    public JSONObject getCurrent(String cityName) throws JSONException, URISyntaxException {
        JSONObject objReturn = new JSONObject();
        JSONArray array = new JSONArray();
        JSONObject obj = new JSONObject();

        JSONObject getCity = getCity(cityName);
        JSONObject getMain = getCity.getJSONObject("main");
        JSONObject counter;

        obj.put("Nome",getCity.getString("name"));
        obj.put("Id",getCity.getLong("id"));


        for (int i = 0; i < getMain.length(); i++){
            obj.put("Temp", getMain.getDouble("temp"));
            obj.put("Feels Like",getMain.getDouble("feels_like"));
            obj.put("Temp min",getMain.getDouble("temp_min"));
            obj.put("Temp max",getMain.getDouble("temp_max"));

        }
        JSONObject getWind = getCity.getJSONObject("wind");
        for(int i = 0; i < getWind.length();i++){
            obj.put("Speed",getWind.getDouble("speed"));
        }

        array.put(obj);

        objReturn.put("Weather",array);

        return objReturn;
    }

    public JSONObject toJSON (Citta city) throws JSONException, URISyntaxException {
        JSONObject listobj = new JSONObject();

        listobj.put("name", city.getNome());
        listobj.put("idcittà", city.getidcitta());

        /*for (int i = 0; i < city.getVelVento().size(); i++) {
            DatiVento counter = city.getVelVento().get(i);
            //listobj.put("data", (city.getVelVento()).get(i).getDataora()); // getDataOra da fare in Citta
            listobj.put("velocità", (counter.getVelVento()));
        }*/

        Forecast fct = new Forecast();

        JSONArray MainArr = new JSONArray();
        JSONObject Mainlist = new JSONObject();

        //Mainlist.put("data", (fct.getTime()));

        for(int i = 0; i < city.getForecasts().size();i++){
            Forecast counter = city.getForecasts().get(i);
            Mainlist.put("temp", (counter.getTemp()));
            Mainlist.put("temp_max", (counter.getTemp_MAX()));
            Mainlist.put("temp_min", (counter.getTemp_MIN()));
            Mainlist.put("feels_like", (counter.getFeels_like()));
            MainArr.put(Mainlist);
            Mainlist.put("Main", MainArr);
        }

        listobj.put("JSON dati ",Mainlist);
        System.out.println(listobj);

        return listobj;

    }


    public String salvataggio(String cityName) throws JSONException, URISyntaxException {

        Citta city = getCityFilter(cityName);
        JSONObject object = new JSONObject();
        object = toJSON(city);



        LocalDate today = LocalDate.now();

        String nomeFile = cityName+"-"+today;

        String rotta = System.getProperty("user.dir")+"//" + nomeFile+".txt";

        try{
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(rotta)));


            output.println(object.toString());
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return rotta;


    }

    public String  salvataggioOgniOra (String cityName) throws JSONException,URISyntaxException{
        String rotta = System.getProperty("user.dir")+ "src/main/java/"+ cityName + "salvataggioOra.json";
        File file = new File(rotta);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                JSONObject current = new JSONObject();
                JSONObject actual = new JSONObject();
                try {
                    current = getCurrent(cityName);
                    actual = current.getJSONObject(String.valueOf(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

                /*try {
                    objCity = toJSON(cityName);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }*/


                try{
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file,true);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    bufferedWriter.write(actual.toString());
                    bufferedWriter.write("\n");
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,0,3600000);

        return "Salvato in " + rotta;

    }
}







