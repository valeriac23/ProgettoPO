package it.univpm.openweather.filter;

public class Filter {


    private double temp_max;
    private double temp_min;
    private double feels_like;
    private double temp_day;

    public Filter( double temp_max,double temp_min, double temp_day,double feels_like) {


        this.temp_max=temp_max;
        this.temp_min=temp_min;
        this.feels_like = feels_like;
        this.temp_day=temp_day;
    }

    public double getTempMax(double temp_max){return temp_max;}

    public double getTempMin(double temp_min) {
        return temp_min;
    }

    public double getFeelsLike(double feels_like) {
        return feels_like;
    }

    public double getTempDay(double temp_day) {return temp_day;}


}
