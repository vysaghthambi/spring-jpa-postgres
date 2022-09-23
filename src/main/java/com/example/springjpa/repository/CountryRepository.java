package com.example.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    Country findById(Long id);
}
