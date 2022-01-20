package it.univpm.openweather.exceptions;
/***
 * Questa classe fa da eccezzione quando il giorno selezionato non è disponibile creando un messaggio
 * @author Michele Costanzi
 * @author Valeria Cannone
 *
 */
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
