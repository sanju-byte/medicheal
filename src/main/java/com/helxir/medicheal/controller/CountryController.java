package com.helxir.medicheal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helxir.medicheal.entity.Country;
import com.helxir.medicheal.serviceImpl.CountryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "all")
    public Iterable<Country> getAllCountries() {
        return countryService.getCountries();
    }
    
    @GetMapping
    public Optional<Country> getCountryByShortName(@RequestParam String countryShortName) {
        return countryService.findCountryByShortName(countryShortName);
    }
}
