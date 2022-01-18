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
             System.out.println(listobj);
             return listobj;
         }catch (StackOverflowError e){ e.printStackTrace();}

         JSONObject test = new JSONObject();
         test.put("Errore","errore stack");
         return test;

     }


     public JSONObject statsToJSON(String cityName, String dataInizio, String dataFine) throws Exception {

         JSONObject obj = new JSONObject();
         JSONObject dati = new JSONObject();
         Vector<Double> wind = wind ();
         dati.put("Valore massimo", Massimi(wind));
         dati.put("Valore minimo", Minimi(wind));
         dati.put("Valore medio",Medium(wind));
         dati.put("Varianza", Variance(wind));

         obj.put("Nome città", cityName);
         obj.put("Data inizio", dataInizio);
         obj.put("Data fine", dataFine);
         obj.put("Statistiche temperature vento", dati);

         return obj;
     }

     private Vector<Double> wind() {
         return wind();
     }



 }
