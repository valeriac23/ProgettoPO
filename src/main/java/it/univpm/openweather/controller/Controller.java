package it.univpm.openweather.controller;


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

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    ServiceSpeed service;

    @GetMapping(value = "/speed/")
    public ResponseEntity<Object> getVisibility(@RequestParam String cityName) throws JSONException, URISyntaxException {
        ResponseEntity<Object> objectResponseEntity;
        JSONObject obj = service.getForecast(cityName);

        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);

    }
    @Autowired
    ServiceSalvataggio service1;
    @GetMapping(value="/save")
    public String save(@RequestParam String cityName) throws IOException, JSONException, URISyntaxException {
        String file = service1.salvataggio(cityName);

        return "E' stato salvato il file: " + file;

    }
    @GetMapping(value = "/savehour")
    public String saveEveryHour(@RequestParam String cityName) throws IOException, JSONException, URISyntaxException {
        String string = service1.salvataggioOgniOra(cityName);
        return "Il file si sta aggiornando..." + string;
    }
    @Autowired
    ServiceStats service2;
    @GetMapping(value = "/hour/stats")
    public ResponseEntity<Object> get(@RequestParam String cityName, @RequestParam int sceltaGiorno) throws Exception {
        String salvataggioFile = service1.salvataggioOgniOra(cityName);
        JSONObject obj = service2.returnObj(cityName,sceltaGiorno);
        System.out.println(obj.toString());
        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }
    @GetMapping(value = "/stats")
    public ResponseEntity<Object> get2(@RequestParam String cityName, @RequestParam int sceltaGiorno) throws Exception {
        JSONObject obj = service2.returnObj(cityName,sceltaGiorno);
        System.out.println(obj.toString());
        return new ResponseEntity<>(obj.toString(), HttpStatus.OK);
    }



}
