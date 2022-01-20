package it.univpm.openweather.service;

import it.univpm.openweather.model.Citta;
import it.univpm.openweather.model.filter.Forecast;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Vector;

@Service
public class ServiceStats {
    private static ToJSON tj = new ToJSON();

    public Citta readSave(String cityName,int sceltaGiorno){
        String rotta = System.getProperty("user.dir")+ "\\src\\main\\resources\\"+ cityName + "_SalvataggioOgniOra.json";
        File file = new File(rotta);
        String name = null;

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            JSONTokener tokener = new JSONTokener(bufferedReader);
            JSONObject objRitorno = new JSONObject();
            Citta city = new Citta(cityName);

            while(bufferedReader.readLine() != null){
                JSONObject lettura = new JSONObject(tokener);
                JSONArray arrayFile = lettura.getJSONArray("JSON-DATI ");

                city.setNome(lettura.getString("Name"));
                city.setId(lettura.getLong("Id"));
                Vector<Forecast> vf = new Vector<>(arrayFile.length());

                JSONObject counter;


                int lunghezza = sceltaGiorno * 8;
                for(int i = 0; i < lunghezza; i++)
                {
                    Forecast forecast = new Forecast();
                    counter = (JSONObject) arrayFile.get(i);
                    JSONObject main = counter.getJSONObject("Main");
                    forecast.setSpeed(main.getDouble("Speed"));
                    forecast.setFeels_like(main.getDouble("Feels_Like"));
                    forecast.setTemp(main.getDouble("Temp"));
                    forecast.setTemp_MAX(main.getDouble("Temp_max"));
                    forecast.setTemp_MIN(main.getDouble("Temp_min"));
                    vf.add(forecast);
                }
                city.setForecast(vf);
                objRitorno.put("Citta",city);
                bufferedReader.close();

                System.out.println(objRitorno);

                return city;


            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public JSONObject returnObj(String cityName, int sceltaGiorno) throws Exception {
        Citta objFile = readSave(cityName,sceltaGiorno);
        JSONObject objReturn = tj.statsToJSON(objFile);

        return objReturn;
    }
}
