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

import com.helxir.medicheal.entity.State;
import com.helxir.medicheal.serviceImpl.StateService;
import com.helxir.medicheal.validator.annotations.CountryId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/state")
public class StateController {

	private static final Logger log = LoggerFactory.getLogger(StateController.class);

    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping(value = "all")
    public Iterable<State> getAllStates(@Valid @CountryId @RequestParam Long countryId) {
        log.info("Country id requested {}", countryId);
        return stateService.getStatesByCountry(countryId);
    }
}
