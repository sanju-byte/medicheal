package com.helxir.medicheal.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.helxir.medicheal.entity.Country;
import com.helxir.medicheal.repository.CountryRepository;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Cacheable(value = "findCountryById", key = "#countryId")
    public Optional<Country> findCountryById(Long countryId) {
        return countryRepository.findById(countryId);
    }
    
    @Cacheable(value = "findCountryById", key = "#countryId")
    public Optional<Country> findCountryByShortName(String shortName) {
        return countryRepository.findByShortName(shortName);
    }

    @Cacheable(value = "getCountries")
    public Iterable<Country> getCountries() {
        return countryRepository.findAll();
    }

}
