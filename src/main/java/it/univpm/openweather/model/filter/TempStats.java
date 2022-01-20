package it.univpm.openweather.model.filter;

import java.util.Vector;


public class TempStats extends Forecast {

    private Vector<Double> wind = new Vector<>();
    private Vector<Double> SpeedVector = new Vector<>();
    private Vector<Double> VectorMax = new Vector<>();
    private Vector<Double> VectorMin = new Vector<>();
    private Vector<Double> TempVector = new Vector<>();
    private Vector<Double> FL_Vector = new Vector<>();
    private static double media;
    private double max_SpeedVento;
    private double min_SpeedVento;
    private double varianza;


        private static double ValoreTemp;
        private static double ValoreMax;
        private static double ValoreMin;
        private static double ValoreMedio;
        private static double ValoreVar;



    public static Double Massimi(double ValoreMax){
            Vector<Double> wind = new Vector<>();


            Double max_SpeedVento = wind.get(0);

            for(int i = 0; i<wind.size(); i++){
                if(max_SpeedVento < wind.get(i))
                    max_SpeedVento = wind.get(i);
            }
            return max_SpeedVento;

    }

   /* public double max (Vector<Double> wind){
        max_SpeedVento = Collections.max(wind);
        return max_SpeedVento;

    }*/

    private Vector<Double> VectorMax() {
        VectorMax().add(max_SpeedVento);
        return VectorMax();
    }

    public static Double Minimi(double temp_min){
             Vector<Double> wind = new Vector <>();

            Double min_SpeedVento = wind.get(0);

            for(int i = 0; i<wind.size(); i++){
                if(min_SpeedVento < wind.get(i))
                    min_SpeedVento = wind.get(i);
            }
            return min_SpeedVento;


        }

        private Vector<Double> VectorMin() {
             VectorMin().add(min_SpeedVento);
              return VectorMin();
         }

        public static Double Medium(double temp_medium){
            Vector<Double> wind = new Vector <>();

            Double sum = 0.0;
            double media;

            for(int i = 0 ; i < wind.size(); i++){
                sum += wind.get(i);
            }
            media = sum / wind.size();
            return media;
        }

          private Vector<Double> VectorMedium() {
            VectorMedium().add(media);
            return VectorMedium();
    }

        public static Double Variance(double variance) {

            Vector<Double> wind = new Vector <>();
            double var = 0;
            double varianza;
            for (double w : wind) {
                var += (w - media) * (w - media);
            }
            varianza = var / (wind.size() - 1);


            return varianza;
        }

         private Vector<Double> VectorVariance() {
            VectorVariance().add(varianza);
             return VectorVariance();
        }

    public static double getValori_max(Vector<Double> wind) {
        return ValoreMax;
    }

    public static double getValori_min(Vector<Double> wind) {
        return ValoreMin;
    }

    public static double getValori_medium(Vector<Double> wind) {
        return ValoreMedio;
    }

    public static double getValori_var(Vector<Double> wind) {
        return ValoreVar;
    }

    public static double getValori_temp(Vector<Double> wind) {
        return ValoreTemp;
    }

    private Vector<Double> wind() {
        return wind();
    }
    
    public Vector<Double> SpeedVector(){
        return SpeedVector();
    }

    public Vector<Double> vectorMin(){
       return vectorMin();
    }

    public Vector<Double> vectorMax() {
        return VectorMax();
    }

    public Vector<Double> vectorVariance(){
        return VectorVariance();
    }


}
