package com.helxir.medicheal.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helxir.medicheal.entity.City;
import com.helxir.medicheal.serviceImpl.CityService;
import com.helxir.medicheal.validator.annotations.StateId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/city")
public class CityController {

	private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "all")
    public Iterable<City> getAllStates(@Valid @StateId @RequestParam Long stateId) {
        log.info("StateId id requested {}", stateId);
        return cityService.getCitiesByState(stateId);
    }
}
