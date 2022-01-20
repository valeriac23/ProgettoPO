package it.univpm.openweather.service;

import it.univpm.openweather.model.Citta;
import it.univpm.openweather.model.filter.Forecast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
public class ServiceSalvataggio extends ServiceAPICall {


    public Citta getCityInfo(String cityName) throws JSONException, URISyntaxException {
        JSONObject objCity = getCity(cityName);
        Citta city = new Citta(cityName);
        JSONObject counter;
        long id = 0;
        String name = null, dt_txt = null;
        try {

            JSONObject getCity = objCity.getJSONObject("city");
            id = getCity.getLong("id");
            name = getCity.getString("name");
            JSONArray arrayCity = objCity.getJSONArray("list");
            for (int i = 0; i < arrayCity.length(); i++) {
                counter = objCity.getJSONObject(String.valueOf(i));
                dt_txt = counter.getString("dt_txt");

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        city.setId(id);
        city.setNome(name);
        city.setData(dt_txt);

        return city;
    }

    public Citta getCityFilter(String cityName) throws JSONException, URISyntaxException {
        JSONObject objCity = getCity(cityName);
        Citta city = new Citta(cityName);
        city = getCityInfo(cityName);

        JSONObject counter;

        JSONArray arrayCity = objCity.getJSONArray("list");

        Vector<Forecast> vectorF = new Vector<Forecast>(arrayCity.length());

        try {

            for (int i = 0; i < arrayCity.length(); i++) {
                Forecast forecast = new Forecast();
                counter = arrayCity.getJSONObject(i);
                JSONObject getWind = counter.getJSONObject("wind");
                forecast.setSpeed(getWind.getDouble("speed"));
                forecast.setDataora(counter.getString("dt_txt"));
                JSONObject getMain = counter.getJSONObject("main");
                forecast.setTemp(getMain.getDouble("temp"));
                forecast.setFeels_like(getMain.getDouble("feels_like"));
                forecast.setTemp_MIN(getMain.getDouble("temp_min"));
                forecast.setTemp_MAX(getMain.getDouble("temp_max"));

                vectorF.add(forecast);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        city.setForecast(vectorF);

        return city;
    }


    public String salvataggio(String cityName) throws JSONException, URISyntaxException {

        Citta city = getCityFilter(cityName);

        LocalDate today = LocalDate.now();

        String nomeFile = cityName + "-" + today;

        String rotta = System.getProperty("user.dir")+ "\\src\\main\\resources\\"+ nomeFile + ".json";

        try {

            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(rotta)));

            JSONObject object = new JSONObject();
            ToJSON tj = new ToJSON();
            object = tj.toJSON(city);

            System.out.println(object);

            output.println(object.toString());
            output.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        return rotta;


    }

    public String salvataggioOgniOra(String cityName){
        String rotta = System.getProperty("user.dir")+ "\\src\\main\\resources\\"+ cityName + "_SalvataggioOgniOra.json";

        File file = new File(rotta);

        TimerTask tk = new TimerTask() {
            @Override
            public void run() {

                try{

                    Citta city = getCityFilter(cityName);
                    ToJSON tj = new ToJSON();
                    JSONObject obj = tj.toJSON(city);

                    if(!file.exists()){
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file,true);

                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    fileWriter.write(obj.toString() + "\n");
                    fileWriter.close();

                }catch (IOException | JSONException | URISyntaxException e){e.printStackTrace();}

            }
        };

        Timer timer = new Timer();
        timer.schedule(tk,0,3600000);

        return "Il file -" + rotta + "- si sta aggiornando";

    }
}