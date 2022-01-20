package it.univpm.openweather.exceptions;
/***
 * Questa classe fa da eccezzione quando la città non è disponibile creando un messaggio
 * @author Michele Costanzi
 * @author Valeria Cannone
 *
 */

public class CittaNonTrovata extends Exception{


    private static String messaggio;

    public CittaNonTrovata(String message) {
        super(message);
        this.messaggio=message;
    }

    public String getMessaggio() {

        messaggio= "Città non trovata...Ritenta...";
        return messaggio;
    }




}
