package it.univpm.openweather.controller;

import it.univpm.openweather.exceptions.CittaNonTrovata;
import it.univpm.openweather.exceptions.ErrorFile;
import it.univpm.openweather.exceptions.GiornoNonDisponibile;
import it.univpm.openweather.model.Citta;
import it.univpm.openweather.service.ServiceSalvataggio;

import it.univpm.openweather.service.ServiceSpeed;
import it.univpm.openweather.service.ServiceStats;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.net.URISyntaxException;
/***
 * Questa classe è il controller e serve per le rotte da digitare su postman
 * @author Valeria Cannone
 * @author Michele Costanzi
 */

@RestController
public class Controller {

    @Autowired
    ServiceSpeed service;

    /**
     * Questo metodo è tipo get e serve per ottenere i dati relativi allo speed
     * @param cityName
     */

    @GetMapping(value = "/speed")
    public ResponseEntity<Object> getVisibility(@RequestParam String cityName) throws JSONException, URISyntaxException,CittaNonTrovata {
        ResponseEntity<Object> objectResponseEntity;
        JSONObject obj = service.getForecast(cityName);
        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);

    }
    @Autowired
    ServiceSalvataggio service1;
    /***
     * Questo metodo di tipo get serve per generare un file json con i dati relativi alla città richiesta
     * @param cityName
     */

    @GetMapping(value="/save")
    public String save(@RequestParam String cityName) throws JSONException, URISyntaxException, CittaNonTrovata {
        String file = service1.salvataggio(cityName);

        return "E' stato salvato il file: " + file;

    }
    /***
     * Questo metodo get serve serve per generare e salvare ogni ora i dati della città richiesta
     * @param cityName
     */

    @GetMapping(value = "/savehour")
    public String saveEveryHour(@RequestParam String cityName) throws ErrorFile, CittaNonTrovata{
        String string = service1.salvataggioOgniOra(cityName);
        return string;
    }
    @Autowired
    ServiceStats service2;
    /**
     * Questo metodo  serve per ottenere le statistiche di una città salvando in un file json
     * @param cityName
     * @param sceltaGiorno
     */

    @GetMapping(value = "/hour/stats")
    public ResponseEntity<Object> get(@RequestParam String cityName, @RequestParam int sceltaGiorno) throws Exception,GiornoNonDisponibile, ErrorFile, CittaNonTrovata {
        String salvataggioFile = service1.salvataggioOgniOra(cityName);
        Citta read = service2.readSave(cityName,sceltaGiorno);
        JSONObject obj = service2.returnObj(cityName,sceltaGiorno);

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }
    /**
     * Questo metodo serve per ottenere le statistiche di una città da un file json
     * @param sceltaGiorno
     * @param cityName
     */

    @GetMapping(value = "/stats")
    public ResponseEntity<Object> get2(@RequestParam String cityName, @RequestParam int sceltaGiorno) throws Exception, CittaNonTrovata, GiornoNonDisponibile {
        Citta read = service2.readSave(cityName,sceltaGiorno);
        JSONObject obj = service2.returnObj(cityName,sceltaGiorno);

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }



}
