package it.univpm.openweather.model;

import it.univpm.openweather.model.filter.Forecast;

import java.util.Vector;

public class Citta {
    private String nome;
    private long idcitta;
    private Vector<DatiVento> SpeedVento;

    public Citta(String nome, long idcitta){
        this.nome = nome;
        this.idcitta = idcitta;
        this.SpeedVento = new Vector<DatiVento>();
    }


    public Citta() {
        super();
    }


    /* Metodo che restituisce il nome della città
       */
    public String getNome() {

        return nome;
    }

    /* Metodo che setta il nome della città
         */
    public void setNome(String name)
    {

        this.nome = name;
    }

    /*
    metodo che restituisce l'id della città'
     */
    public long getidcitta() {

        return idcitta;
    }
        /*Metodo che setta l'id della città

         */
        public void setidcitta(long id) {

            this.idcitta = id;
        }

        public Vector<DatiVento> getVelVento () {
            return SpeedVento;
        }

        public void setVelVento(Vector<DatiVento> vector) {
            this.SpeedVento = vector;
        }

    public void setForecast(Vector<Forecast> vector1) {

    }
}

