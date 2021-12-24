package it.univpm.openweather.model;

import java.util.Vector;

public class Citta {
    private String nome;
    private long idcittà;
    private String country;
    private Vector<DatiVento> SpeedVento = new Vector<DatiVento>();

    public Citta() {
        super();
    }

    public Citta(String nome, long idcittà, String country) {
        this.nome = nome;
        this.idcittà = idcittà;
        this.country = country;
        this.SpeedVento = new Vector<DatiVento>();
    }

    public Citta(String nome) {
        this.nome = nome;
        this.idcittà = 0;
        this.country = null;
        this.SpeedVento = null;
    }


    /* Metodo che restituisce il nome della città
     */
    public String getNome() {

        return nome;
    }

    /* Metodo che setta il nome della città
     */
    public void setNome() {
        this.nome = nome;
    }

    /*
    metodo che restituisce l'id della città'
     */
    public long getidcittà() {

        return idcittà;
    }

    /*Metodo che setta l'id della città

     */
    public void setidcittà() {

        this.idcittà = idcittà;
    }

    public Vector<DatiVento> getVelVento() {

        return SpeedVento;
    }

    public void setVelVento(Vector<DatiVento> array) {
        this.SpeedVento = SpeedVento;
    }

    public String toStringVector() {
        String vettore = "";
        for (int i = 0; i < SpeedVento.size(); i++)
            vettore += SpeedVento.get(i).toString();
        return vettore;
    }

    @Override
    public String toString() {
        return "id=" + idcittà + ", name=" + nome + ", VelVentoArray=" + toStringVector() + "";

    }
}


