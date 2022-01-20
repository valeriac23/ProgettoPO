package it.univpm.openweather.model.filter;

import java.util.Vector;


public class TempStats extends Forecast {

    private Vector<Double> wind = new Vector<>();
    //private Vector<Double> speed = new Vector<>();
    private Vector<Double> temp_max = new Vector<>();
    private Vector<Double> temp_min = new Vector<>();
    private Vector<Double> temp = new Vector<>();
    private Vector<Double> feels_like = new Vector<>();
    private Vector<Double> varianza = new Vector<>();
    private static double media;



    public static Double Massimi(Vector<Double> temp_max) {

        Double max_SpeedVento = temp_max.get(0);

        for (int i = 0; i < temp_max.size(); i++) {
            if (max_SpeedVento < temp_max.get(i))
                max_SpeedVento = temp_max.get(i);
        }
        return max_SpeedVento;

    }

   /* public double max (Vector<Double> wind){
        max_SpeedVento = Collections.max(wind);
        return max_SpeedVento;

    }*/

   /* private Vector<Double> VectorMax() {
        VectorMax().add(max_SpeedVento);
        return VectorMax();
    }*/

    public static Double Minimi(Vector<Double> temp_min) {

        Double min_SpeedVento = temp_min.get(0);

        for (int i = 0; i < temp_min.size(); i++) {
            if (min_SpeedVento < temp_min.get(i))
                min_SpeedVento = temp_min.get(i);
        }
        return min_SpeedVento;


    }

   /* private Vector<Double> VectorMin() {
        VectorMin().add(min_SpeedVento);
        return VectorMin();
    }*/

    public static Double Medium(Vector<Double> wind) {

        Double sum = 0.0;
        double media;

        for (int i = 0; i < wind.size(); i++) {
            sum += wind.get(i);
        }
        media = sum / wind.size();
        return media;
    }

    /*private Vector<Double> VectorMedium() {
        VectorMedium().add(media);
        return VectorMedium();
    }*/

    public static Double Variance(Vector<Double> wind) {

        double var = 0;
        double varianza;
        for (double w : wind) {
            var += (w - media) * (w - media);
        }
        varianza = var / (wind.size() - 1);


        return varianza;
    }

    /*private Vector<Double> VectorVariance() {
        VectorVariance().add(varianza);
        return VectorVariance();
    }*/
}