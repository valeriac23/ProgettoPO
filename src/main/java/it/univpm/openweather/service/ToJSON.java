 package it.univpm.openweather.service;

 import it.univpm.openweather.model.Citta;
 import it.univpm.openweather.model.filter.Forecast;
 import org.json.JSONArray;
 import org.json.JSONException;
 import org.json.JSONObject;

 import java.net.URISyntaxException;
 import java.util.Vector;

 import static it.univpm.openweather.model.filter.TempStats.*;
 /**
  * Questa classe restituisce tutti i JSON
  * @author Valeria Cannone
  * @author Michele Costanzi
  */


 public class ToJSON extends Citta {


     Citta city = new Citta();
     ServiceStats serviceStats = new ServiceStats();
     /**
      * Questo metodo restituisce il JSON per i salvataggi
      * @param city
      */

     public JSONObject toJSON (Citta city) throws JSONException, URISyntaxException {


         JSONObject listobj = new JSONObject();
         try{


             listobj.put("Name", city.getNome());
             listobj.put("Id", city.getidcitta());

             JSONArray MainArr = new JSONArray();

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

             }

             listobj.put("JSON-DATI ",MainArr);

             return listobj;
         }catch (StackOverflowError e){ e.printStackTrace();}

         JSONObject test = new JSONObject();
         test.put("Errore","errore stack");
         return test;

     }

     /**
      * Questo metodo restituisce il JSON per le statistiche
      * @param obj
      * @param sceltaGiorno
      */

     public JSONObject statsToJSON(Citta obj, int sceltaGiorno) throws Exception {


         JSONArray arrayDati = new JSONArray();
         JSONObject statistiche = new JSONObject();
         JSONObject dati = new JSONObject();

         Vector<Double> temp = new Vector<>(obj.getForecasts().size());
         Vector<Double> temp_max = new Vector<>(obj.getForecasts().size());
         Vector<Double> temp_min = new Vector<>(obj.getForecasts().size());
         Vector<Double> feels_like = new Vector<>(obj.getForecasts().size());

         for(int i = 0; i < obj.getForecasts().size();i++){
             Forecast counter = obj.getForecasts().get(i);

             temp.add(counter.getTemp());
             temp_max.add(counter.getTemp_MAX());
             temp_min.add(counter.getTemp_MIN());
             feels_like.add(counter.getFeels_like());
         }

         statistiche.put("Nome città",obj.getNome());
         statistiche.put("Numero di giorni scelti",sceltaGiorno);
         dati.put("Valore massimo", Massimi(temp_max));
         dati.put("Valore minimo", Minimi(temp_min));
         dati.put("Valore medio della temperatura percepita", Medium(feels_like));
         dati.put("Varianza della temperatura percepita",Variance(feels_like));
         dati.put("Valore medio della temperatura reale",Medium(temp));
         dati.put("Varianza di temperatura reale", Variance(temp));

         arrayDati.put(dati);
         statistiche.put("Statistiche", arrayDati);

         return statistiche;
     }

 }
