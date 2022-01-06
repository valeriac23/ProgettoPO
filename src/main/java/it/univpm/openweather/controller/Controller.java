package it.univpm.openweather.controller;

import it.univpm.openweather.service.ServiceAppImpl;
import it.univpm.openweather.service.ServiceFilterStats;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    ServiceAppImpl service;

    @GetMapping(value = "/speed/")
    public ResponseEntity<Object> getVisibility(@RequestParam String cityName) throws JSONException {
        ResponseEntity<Object> objectResponseEntity;
        objectResponseEntity = new ResponseEntity<>(service.getForecast(cityName).toString(), HttpStatus.OK);
        return objectResponseEntity;
    }
    @Autowired
    ServiceFilterStats service1;
    @GetMapping(value="/save")
    public String save(@RequestParam String cityName) throws IOException, JSONException {
        String file = service1.salvataggio(cityName);

        return "E' stato salvato il file: " + file;

    }
    @GetMapping(value = "/savehour")
    public String saveEveryHour(@RequestParam String cityName) throws IOException,JSONException{
        service1.salvataggio(cityName);
        return "Il file si sta aggiornando...";
    }

}
