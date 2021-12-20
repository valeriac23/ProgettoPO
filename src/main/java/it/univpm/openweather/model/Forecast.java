package it.univpm.openweather.model;

public class Forecast {
    private String main;
    private int visibilità;
    private double temp_MAX;
    private double temp_MIN;
    private double feels_like;
    private String dataora;

    public Forecast(){
        this.main = main;
        this.visibilità= visibilità;
        this.temp_MAX= temp_MAX;
        this.temp_MIN= temp_MIN;
        this.dataora = dataora;
    }

    public String getMain(){
        return main;
    }

    public void setMain(String main){
        this.main = main;
    }

    public int getVisibilità(){
        return visibilità;
    }

    public void setvisibilità(int visibilità){
        this.visibilità = visibilità;
    }

    public double getTemp_MAX() {
        return temp_MAX;
    }

    public void setTemp_MAX(double temp_MAX) {
        this.temp_MAX = temp_MAX;
    }

    public double getTemp_MIN() {

        return temp_MIN;
    }

    public void setTemp_MIN(double temp_MIN) {

        this.temp_MIN = temp_MIN;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }
    public String getTime(){
        return dataora;
    }

    public void setTime(int time) {
        this.dataora = dataora;
    }

    @Override
    public String toString() {
        return "data e ora=" + dataora + "main=" + main + ", visibilità=" + visibilità + ", temp_max="
                + temp_MAX + ", temp_min=" + temp_MIN + ", feels_like=" + feels_like + "";
    }

}
