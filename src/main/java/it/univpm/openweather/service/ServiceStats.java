package it.univpm.openweather.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Service
public class ServiceStats {

    public void readSave(String cityName){
        String rotta = System.getProperty("user.dir")+ "src/main/java/"+ cityName + "salvataggioOra.json";
        File file = new File(rotta);
        String name = null;

        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            JSONTokener tokener = new JSONTokener(bufferedReader);

            while(bufferedReader.readLine() != null){
                JSONObject main = new JSONObject(tokener);
                JSONArray array = main.getJSONArray("Main");

                for(int i = 0;i < array.length();i++){
                    JSONObject counter = (JSONObject) array.get(i);
                    counter.getString("Main");
                    counter.getDouble("velocità");
                    counter.getDouble("temp");
                    counter.getDouble("temp_max");
                    counter.getDouble("temp_min");
                    counter.getDouble("fells_like");
                }

                bufferedReader.close();




            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
