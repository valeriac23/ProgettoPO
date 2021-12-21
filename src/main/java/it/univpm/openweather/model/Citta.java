package it.univpm.openweather.model;

import java.util.Vector;

public class Citta {
    private String nome;
    private long idcittà;
    private Vector<DatiVento> SpeedVento;

    public Citta(String nome, long idcittà){
        this.nome = nome;
        this.idcittà = idcittà;
        this.SpeedVento = new Vector<DatiVento>();
    }

    public Citta() {

    }


    /* Metodo che restituisce il nome della città
       */
    public String getNome() {

        return nome;
    }

    /* Metodo che setta il nome della città
         */
    public void setNome()
    {

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

        public Vector<DatiVento> getVelVento () {
            return SpeedVento;
        }

        public void setVelVento () {
            this.SpeedVento = SpeedVento;
        }
    }
       /* public String toStringVector () {
            String toReturn = "";
            for (int i = 0; i < VelVento.size(); i++)
                toReturn += VelVento.get(i).toString();
            return toReturn;
        }

        @Override
        public String toString () {
            return "id=" + id + ", name=" + name + ", VelVentoArray=" + toStringVector() + "";
        }
*/

