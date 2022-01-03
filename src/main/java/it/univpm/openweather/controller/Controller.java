package it.univpm.openweather.controller;

import it.univpm.openweather.service.ServiceAppImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
