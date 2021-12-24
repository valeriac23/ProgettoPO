package it.univpm.openweather.Stats;

import java.util.Vector;
import it.univpm.openweather.model.Valori;
//import it.univpm.openweather.model.Forecast;
//import com.ConfrontoSpeedVento.exceptions.dateException;
//import com.ConfrontoSpeedVento.exceptions.vectorNullException;
//import com.ConfrontoSpeedVento.exceptions.wrongDateException;

public class TempStats implements Valori{

        private Vector<Double> wind = new Vector<Double>();
        private double media;
        private static double ValoreMax;
        private static double ValoreMin;
        private static double ValoreMedio;
        private static double ValoreVar;


        public static Double Massimi(Vector<Double> wind){

            Double max_SpeedVento = wind.get(0);

            for(int i = 0; i<wind.size(); i++){
                if(max_SpeedVento < wind.get(i))
                    max_SpeedVento = wind.get(i);
            }
            return max_SpeedVento;
        }

        public static Double Minimi(Vector<Double> wind){
            Double min_SpeedVento = wind.get(0);

            for(int i = 0; i<wind.size(); i++){
                if(min_SpeedVento < wind.get(i))
                    min_SpeedVento = wind.get(i);
            }
            return min_SpeedVento;

        }

        public static double Medium(Vector<Double> wind){

            Double sum = 0.0;
            double media;

            for(int i = 0 ; i < wind.size(); i++){
                sum += wind.get(i);
            }
            media = sum / wind.size();
            return media;
        }

        public static double Variance(Vector<Double> wind){
            double var = 0;
            double varianza;
            for( double w : wind){
                var += (w - media)*(w- media);
            }
           varianza = var / (wind.size()-1);


            return varianza;
        }


    @Override
    public void getValori(double valore) {

    }

    @Override
        public void setValori(double valore) {

        }

    @Override
    public double getValori_max() {
        return 0;
    }

    @Override
    public static double getValori_min(Vector<Double> wind) {
        return 0;
    }

    @Override
    public double getValori_medium() {
        return 0;
    }

    @Override
    public double getValori_var() {
        return 0;
    }


    public static double getValori_max(Vector<Double> wind) {
            return ValoreMax;
        }



        public static double getValori_medium(Vector<Double> wind) {
            return ValoreMedio;
        }

        public static double getValori_var(Vector<Double> wind) {return ValoreVar;  }
    }

}
