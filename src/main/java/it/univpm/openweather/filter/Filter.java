package it.univpm.openweather.filter;

public class Filter extends Periodicità{

    private double temp_max;
    private double temp_min;
    private double fells_like;
    private double temp_day;

    public Filter(String giorno, String settimna,String fascia, double temp_max,double temp_min, double temp_day,double fells_like) {

        super(giorno,settimna,fascia);
        this.temp_max=temp_max;
        this.temp_min=temp_min;
        this.fells_like=fells_like;
        this.temp_day=temp_day;
    }

    public double getTempMax(double temp_max){return temp_max;}

    public double getTempMin(double temp_min) {
        return temp_min;
    }

    public double getFeelsLike(double feel_like) {
        return feel_like;
    }

    public double getTempDay(double temp_day) {return temp_day;}


}
