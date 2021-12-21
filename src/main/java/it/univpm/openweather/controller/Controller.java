package it.univpm.openweather.controller;

import it.univpm.openweather.service.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    ServiceModel service = new ServiceModel();

    @GetMapping(value = "/test")
    public ResponseEntity<Object> getVisibility(@RequestParam String cityName) {
        return new ResponseEntity<> (service.getInfo(cityName), HttpStatus.OK);
    }

}
