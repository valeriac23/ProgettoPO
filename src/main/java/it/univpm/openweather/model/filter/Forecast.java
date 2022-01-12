package it.univpm.openweather.model.filter;

import java.util.Vector;

public class Forecast /*implements Valori*/ {
    private Vector<Double> wind = new Vector<Double>();


    private double temp;
    private double temp_MAX;
    private double temp_MIN;

    private double feels_like;

    private String dataora;

    public Forecast(){

        this.temp = temp;
        this.temp_MAX= temp_MAX;
        this.temp_MIN= temp_MIN;
        this.feels_like = feels_like;
        this.dataora = dataora;
    }

    public double getTemp() {
        return temp;
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
    public String getTime(){
        return dataora;
    }

    public void setTime(int time) {
        this.dataora = dataora;
    }


    @Override
    public String toString() {
        return "data e ora=" + dataora + ", temp_max="
                + temp_MAX + ", temp_min=" + temp_MIN + ", feels_like=" + feels_like;
    }

    /*public Vector<Double> getValoriVECTOR() {

        return this.wind;
    }

      public void setValori(Double valore) {

          try {
              this.wind.add(valore);

              this.temp_MAX = TempStats.getValori_max(this.wind);

              this.temp_MIN = TempStats.getValori_min(this.wind);

              this.temp_media = TempStats.getValori_medium(this.wind);

              this.varianza = TempStats.getValori_var(this.wind);

          } catch(ArrayIndexOutOfBoundsException ArrayExc) {
                System.out.println("Errore con indici del vettore");
                System.out.println(ArrayExc);
            } catch(Exception e) {
                System.out.println("Errore generico");
                System.out.println(e);
            }
    }

    @Override
    public void getValori(double valore) {

    }

    @Override
    public void setValori(double valore) {
        try {
            this.wind.add(valore);

            this.temp_MAX = TempStats.getValori_max(this.wind);

            this.temp_MIN = TempStats.getValori_min(this.wind);

            this.temp_media = TempStats.getValori_medium(this.wind);

            this.varianza = TempStats.getValori_var(this.wind);

        } catch(ArrayIndexOutOfBoundsException ArrayExc) {
            System.out.println("Errore con indici del vettore");
            System.out.println(ArrayExc);
        } catch(Exception e) {
            System.out.println("Errore generico");
            System.out.println(e);
        }
    }

    @Override
    public double getValori_max() {
        return temp_MAX;
    }

    @Override
    public double getValori_min() {
        return temp_MIN;
    }

    @Override
    public double getValori_medium() {
        return temp_media;
    }

    @Override
    public double getValori_var() {
        return varianza;
    }

    public double setTemp(double temp) {
        return temp;

    }

    public double getTemp() {
        return temp;
    }*/
}