 package it.univpm.openweather.service;

 import it.univpm.openweather.model.Citta;
 import it.univpm.openweather.model.filter.Forecast;
 import org.json.JSONArray;
 import org.json.JSONException;
 import org.json.JSONObject;

 import java.net.URISyntaxException;
 import java.util.Vector;

 import static it.univpm.openweather.model.filter.TempStats.*;

 public class ToJSON extends ServiceSalvataggio {

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
