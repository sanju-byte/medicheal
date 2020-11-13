package com.helxir.medicheal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.helxir.medicheal.entity.City;
import com.helxir.medicheal.repository.CityRepository;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Cacheable(value = "getCitiesByState", key = "#stateId")
    public Iterable<City> getCitiesByState(Long stateId) {
        return cityRepository.findCitiesByState_Id(stateId);
    }

}
