package it.univpm.openweather.exceptions;

public class GiornoNonDisponibile extends Exception {

    private static String messaggio;

    public GiornoNonDisponibile(String message){
        super(message);
        this.messaggio = messaggio;
    }


    public String getMessaggio(){
        messaggio = "Il giorno inserito non è valido";
        return messaggio;
    }


}
