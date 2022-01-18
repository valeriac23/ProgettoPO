package it.univpm.openweather.model;

import it.univpm.openweather.model.filter.Forecast;

import java.util.Vector;

public class Citta {
    private String nome;
    private long id;
    private Vector<Forecast> forecasts;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Citta(String nome, long id) {
        this.nome = nome;
        this.id = id;

    }

    public Citta(String nome){
        this.nome=nome;
        this.id= 0;
    }

    public Citta(){
        super();
    }


    public String getNome() {

        return nome;
    }


    public void setNome(String name)
    {

        this.nome = name;
    }


    public long getidcitta() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Citta{" +
                "nome= ' " + nome + '\'' +
                ", id= " + id +
                ", Forecasts = " + forecasts +
                ", data ='" + data + '\'' +
                '}';
    }

    public Vector<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecast(Vector<Forecast> forecasts) {
            this.forecasts = forecasts;

    }




}

