package it.univpm.openweather.model.filter;

public class Forecast  {

    private double speed;
    private double temp;
    private double temp_MAX;
    private double temp_MIN;
    private double feels_like;
    private String dataora;

    public Forecast() {

        this.speed = speed;
        this.temp = temp;
        this.temp_MAX = temp_MAX;
        this.temp_MIN = temp_MIN;
        this.feels_like = feels_like;
        this.dataora = dataora;
    }
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTemp() {
        return temp;
    }

    public String getDataora() {
        return dataora;
    }

    public void setDataora(String dataora) {
        this.dataora = dataora;
    }

    public void setTemp(double temp) {
        this.temp = temp;
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

    @Override
    public String toString() {
        return "Forecast{" +
                "speed= " + speed +
                ", temp= " + temp +
                ", temp_MAX= " + temp_MAX +
                ", temp_MIN= " + temp_MIN +
                ", feels_like= " + feels_like +
                ", dataora= '" + dataora + '\'' +
                '}';
    }


}