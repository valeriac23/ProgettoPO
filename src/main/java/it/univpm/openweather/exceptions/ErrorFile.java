package it.univpm.openweather.exceptions;
/***
 * Questa classe fa da eccezzione quando esiste un errore nel file creando un messaggio
 * @author Michele Costanzi
 * @author Valeria Cannone
 *
 */
public class ErrorFile extends Exception{

    public static String messaggio;

    public ErrorFile(String message) {
        super(message);
        this.messaggio=message;
    }

    public String getMessaggio(){
        messaggio = "File non eseguito";
        return messaggio;
    }
}
