package com.example.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String city);
}
