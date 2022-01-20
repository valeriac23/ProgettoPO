package it.univpm.openweather.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Vector;

@Service
public class ServiceStats {
    private static ToJSON tj;

    public JSONObject readSave(String cityName,int sceltaGiorno){
        String rotta = System.getProperty("user.dir")+ "\\src\\main\\resources\\"+ cityName + "_SalvataggioOgniOra.json";
        File file = new File(rotta);
        String name = null;

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            JSONTokener tokener = new JSONTokener(bufferedReader);
            JSONObject objRitorno = new JSONObject();

            while(bufferedReader.readLine() != null){
                JSONObject lettura = new JSONObject(tokener);
                JSONObject arrayFile = lettura.getJSONObject("JSON-DATI");
                String nome = lettura.getString("Name");
                long id = lettura.getLong("Id");
                JSONObject counter;
                Vector<Double> vSpeed = new Vector<>(arrayFile.length());
                Vector<Double> vFeelsLike = new Vector<>(arrayFile.length());
                Vector<Double> vTempMin = new Vector<>(arrayFile.length());
                Vector<Double> vTempMax = new Vector<>(arrayFile.length());
                Vector<Double> vTemp = new Vector<>(arrayFile.length());

                int lunghezza = sceltaGiorno * 8;
                for(int i = 0; i < lunghezza; i++)
                {
                    counter = (JSONObject) arrayFile.get(String.valueOf(i));
                    JSONObject main = counter.getJSONObject("Main");
                    vSpeed.add(main.getDouble("Speed"));
                    vFeelsLike.add(main.getDouble("Feels_Like"));
                    vTemp.add(main.getDouble("Temp"));
                    vTempMax.add(main.getDouble("Temp_max"));
                    vTempMin.add(main.getDouble("Temp_min"));
                }
                bufferedReader.close();

                objRitorno.put("name",name);
                objRitorno.put("id",id);
                objRitorno.put("giorno",sceltaGiorno);
                objRitorno.put("vSpeed",vSpeed);
                objRitorno.put("vFeelsLike",vFeelsLike);
                objRitorno.put("vTemp",vTemp);
                objRitorno.put("vTempMax",vTempMax);
                objRitorno.put("vTempMin",vTempMin);

                return objRitorno;


            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    public JSONObject returnObj(String cityName, int sceltaGiorno) throws Exception {
        JSONObject objFile = readSave(cityName,sceltaGiorno);
        JSONObject objReturn = tj.statsToJSON(objFile);

        return objReturn;
    }
}
