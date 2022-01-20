package it.univpm.openweather.service;

import it.univpm.openweather.model.Citta;
import it.univpm.openweather.model.filter.Forecast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.*;

import java.util.Vector;
/**
 * Questa classe legge i dati salvati da un file e restituisce un JSONObject con le statistiche
 * @author Valeria Cannone
 * @author Michele Costanzi
 */


@Service
public class ServiceStats {
    private static ToJSON tj = new ToJSON();
    /**
     * Questo metodo legge dal file salvato e prende in input i dati resettandoli nella classe Citta
     * @param cityName
     * @param sceltaGiorno
     */


    public Citta readSave(String cityName,int sceltaGiorno) throws JSONException {
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

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }
    /**
     * Questo metodo restituisce un JSONObject di statistiche richiamando la classe ToJSON
     * @param cityName
     * @param sceltaGiorno
     */


        public JSONObject returnObj(String cityName, int sceltaGiorno) throws Exception {
        Citta objFile = readSave(cityName,sceltaGiorno);
        JSONObject objReturn = tj.statsToJSON(objFile,sceltaGiorno);

        return objReturn;
    }
}
