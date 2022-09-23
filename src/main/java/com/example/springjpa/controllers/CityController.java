package com.example.springjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.model.City;
import com.example.springjpa.pojos.CityRequest;
import com.example.springjpa.services.CityService;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/hello")
    public String getHello() {
        return "Hello User";
    }

    @GetMapping("/cities")
    public ResponseEntity<?> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PostMapping("/cities")
    public ResponseEntity<?> addCity(@RequestBody City city) {
        try {
            City _city = cityService.saveCity(city);
            return new ResponseEntity<>(_city, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cities/{cityName}")
    public ResponseEntity<?> getCitiesByName(@PathVariable("cityName") String city) {
        return new ResponseEntity<>(cityService.getCitiesByname(city), HttpStatus.OK);
    }

    @PostMapping("/cities/add")
    public ResponseEntity<?> saveCity(@RequestBody CityRequest cityRequest) {
        City _city = cityService.addCity(cityRequest);
        return new ResponseEntity<>(_city, HttpStatus.OK);
    }

}
