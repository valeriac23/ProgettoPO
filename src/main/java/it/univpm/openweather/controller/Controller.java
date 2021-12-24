package it.univpm.openweather.controller;

import it.univpm.openweather.model.Citta;
import it.univpm.openweather.service.ServiceModel;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

@RestController
public class Controller {
    @Autowired
    ServiceModel service;

    @GetMapping(value = "/test/")
    public ResponseEntity<Object> getVisibility(@RequestParam String cityName) throws JSONException {
        ResponseEntity<Object> objectResponseEntity;
        objectResponseEntity = new ResponseEntity<>(service.getInfo(cityName), HttpStatus.OK);
        return objectResponseEntity;
    }

}
