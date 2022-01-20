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

@RestController
public class Controller {

    @Autowired
    ServiceSpeed service;

    @GetMapping(value = "/speed")
    public ResponseEntity<Object> getVisibility(@RequestParam String cityName) throws JSONException, URISyntaxException,CittaNonTrovata {
        ResponseEntity<Object> objectResponseEntity;
        JSONObject obj = service.getForecast(cityName);
        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);

    }
    @Autowired
    ServiceSalvataggio service1;
    @GetMapping(value="/save")
    public String save(@RequestParam String cityName) throws JSONException, URISyntaxException, CittaNonTrovata {
        String file = service1.salvataggio(cityName);

        return "E' stato salvato il file: " + file;

    }
    @GetMapping(value = "/savehour")
    public String saveEveryHour(@RequestParam String cityName) throws ErrorFile, CittaNonTrovata{
        String string = service1.salvataggioOgniOra(cityName);
        return string;
    }
    @Autowired
    ServiceStats service2;
    @GetMapping(value = "/hour/stats")
    public ResponseEntity<Object> get(@RequestParam String cityName, @RequestParam int sceltaGiorno) throws Exception,GiornoNonDisponibile, ErrorFile, CittaNonTrovata {
        String salvataggioFile = service1.salvataggioOgniOra(cityName);
        Citta read = service2.readSave(cityName,sceltaGiorno);
        JSONObject obj = service2.returnObj(cityName,sceltaGiorno);

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }
    @GetMapping(value = "/stats")
    public ResponseEntity<Object> get2(@RequestParam String cityName, @RequestParam int sceltaGiorno) throws Exception, CittaNonTrovata, GiornoNonDisponibile {
        Citta read = service2.readSave(cityName,sceltaGiorno);
        JSONObject obj = service2.returnObj(cityName,sceltaGiorno);


        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }



}
