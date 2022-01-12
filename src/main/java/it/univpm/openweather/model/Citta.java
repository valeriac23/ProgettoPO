package it.univpm.openweather.model;

import it.univpm.openweather.model.filter.Forecast;

import java.util.Vector;

public class Citta {
    private String nome;
    private long id;
    private Vector<DatiVento> speedVento;
    private Vector<Forecast> forecasts;

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

    public Vector<DatiVento> getVelVento () {
        return speedVento;
    }
    public void setVelVento(Vector<DatiVento> speedVento) {

        this.speedVento = speedVento;
    }

    public Vector<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecast(Vector<Forecast> forecasts) {
            this.forecasts = forecasts;

    }

    @Override
    public String toString() {
        return "Citta{"+ "nome='" + nome + '\'' + ", id=" + id
                + ", speedVento=" + speedVento + ", forecasts=" + forecasts + '}';
    }
}

