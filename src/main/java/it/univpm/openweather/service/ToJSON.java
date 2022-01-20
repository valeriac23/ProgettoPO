 package it.univpm.openweather.service;

 import it.univpm.openweather.model.Citta;
 import it.univpm.openweather.model.filter.Forecast;
 import org.json.JSONArray;
 import org.json.JSONException;
 import org.json.JSONObject;

 import java.net.URISyntaxException;
 import java.util.Vector;

 import static it.univpm.openweather.model.filter.TempStats.*;

 public class ToJSON extends Citta {


     Citta city = new Citta();
     ServiceStats serviceStats = new ServiceStats();

     public JSONObject toJSON (Citta city) throws JSONException, URISyntaxException {


         JSONObject listobj = new JSONObject();
         try{


             listobj.put("Name", city.getNome());
             listobj.put("Id", city.getidcitta());


             JSONArray MainArr = new JSONArray();

             //Mainlist.put("data", (fct.getTime()));

             for(int i = 0; i < city.getForecasts().size();i++){


                 JSONObject Mainlist = new JSONObject();
                 JSONObject main = new JSONObject();
                 Forecast counter = new Forecast();

                 counter = city.getForecasts().get(i);
                 Mainlist.put("Data",(counter.getDataora()));
                 Mainlist.put("Speed",(counter.getSpeed()));
                 Mainlist.put("Temp", (counter.getTemp()));
                 Mainlist.put("Temp_max", (counter.getTemp_MAX()));
                 Mainlist.put("Temp_min", (counter.getTemp_MIN()));
                 Mainlist.put("Feels_Like", (counter.getFeels_like()));

                 main.put("Main",Mainlist);
                 MainArr.put(main);
                 //Mainlist.put("Main", MainArr);
             }



             listobj.put("JSON-DATI ",MainArr);
             System.out.println("La lunghezza dell'array è: " + MainArr.length());
             System.out.println(listobj);
             return listobj;
         }catch (StackOverflowError e){ e.printStackTrace();}

         JSONObject test = new JSONObject();
         test.put("Errore","errore stack");
         return test;

     }


     public JSONObject statsToJSON(Citta obj) throws Exception {



         JSONObject dati = new JSONObject();
         Vector<Double> speed = new Vector<>(obj.getForecasts().size());
         System.out.println("Get forecast:  " + obj.getForecasts().toString());
         for(int i = 0; i < obj.getForecasts().size();i++){
             Forecast counter = obj.getForecasts().get(i);
             speed.add(counter.getSpeed());
         }


         //dati.put("Valore massimo", Massimi(getValori_max()));
         //dati.put("Valore minimo", Minimi(getValori_min(wind)));
         dati.put("Valore medio",Medium(speed));
         //dati.put("Varianza", Variance(getValori_var(wind)));

         //obj.put("Nome città",0);

         //obj.put("Statistiche temperature vento", dati);
         System.out.println("Dati speed: " + dati);

         return dati;
     }

     private Vector<Double> wind() {
         return wind();
     }



 }
