package it.univpm.openweather.exceptions;

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
