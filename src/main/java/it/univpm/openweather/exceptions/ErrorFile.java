package it.univpm.openweather.exceptions;

public class ErrorFile extends Exception{

    public static String messaggio;

    public ErrorFile(String message) {
        super(message);
        this.messaggio=message;
    }

    public String getMessaggio(){
        messaggio = "File non eseguitp";
        return messaggio;
    }
}
