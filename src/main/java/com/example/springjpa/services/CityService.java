package com.example.springjpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjpa.model.City;
import com.example.springjpa.model.Country;
import com.example.springjpa.pojos.CityRequest;
import com.example.springjpa.repository.CityRepository;
import com.example.springjpa.repository.CountryRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepo;

    @Autowired
    private CountryRepository countryRepo;

    public List<City> getAllCities() {
        return cityRepo.findAll();
    }

    public City saveCity(City city) {
        return cityRepo.save(city);
    }

    public City getCitiesByname(String city) {
        return cityRepo.findByName(city);
    }

    public City addCity(CityRequest cityRequest) {
        Country country = countryRepo.findById(cityRequest.countryId);
        if (country != null) {
            City city = new City();
            city.setName(cityRequest.name);
            city.setCode(cityRequest.code);
            city.setCountryId(cityRequest.countryId);

            cityRepo.save(city);

            return city;
        }
        return null;
    }
}
