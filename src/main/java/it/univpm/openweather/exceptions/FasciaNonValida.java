package it.univpm.openweather.exceptions;

public class FasciaNonValida extends Exception{

    public static String messaggio;

    public FasciaNonValida(String message) {
        super(message);
        this.messaggio=message;
    }

    public String getMessaggio(){
        messaggio = "Fascia oraria non valida";
        return messaggio;
    }
}
