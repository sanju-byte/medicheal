package com.helxir.medicheal.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.helxir.medicheal.entity.Country;
import com.helxir.medicheal.serviceImpl.CountryService;
import com.helxir.medicheal.validator.annotations.CountryId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountryIdValidator implements ConstraintValidator<CountryId, Long> {

	private static final Logger log = LoggerFactory.getLogger(CountryIdValidator.class);

	@Autowired
	private CountryService countryService;

	@Override
	public boolean isValid(Long countryId, ConstraintValidatorContext constraintValidatorContext) {
		final Optional<Country> country = countryService.findCountryById(countryId);
		log.info("Country for {} found {}", countryId, country.isPresent());
		return country.isPresent();
	}
}
