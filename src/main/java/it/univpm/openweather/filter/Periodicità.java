package it.univpm.openweather.filter;

import java.util.Vector;

public class Periodicità {

    private String giorno;
    private String settimana;
    private String fascia;



    public Periodicità(String giorno, String settimana,String fascia) {
        this.giorno=giorno;
        this.settimana=settimana;
        this.fascia=fascia;
    }


    public String getGiorno(String giorno){return giorno; }

    public String getSettimana(String settimana){
        return settimana;
    }

    public Vector<String> dayFive(Vector<String> giorno) {return giorno;}











}
