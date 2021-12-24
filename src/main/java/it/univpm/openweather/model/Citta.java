package it.univpm.openweather.model;

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
    public void setNome()
    {

        this.nome = nome;
    }

    /*
    metodo che restituisce l'id della città'
     */
    public long getidcitta() {

        return idcitta;
    }
        /*Metodo che setta l'id della città

         */
        public void setidcitta() {

            this.idcitta = idcitta;
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

