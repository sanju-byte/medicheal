package com.helxir.medicheal.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helxir.medicheal.entity.State;
import com.helxir.medicheal.serviceImpl.StateService;
import com.helxir.medicheal.validator.annotations.StateId;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StateIdValidator implements ConstraintValidator<StateId, Long> {
	private final StateService stateService;

	private static final Logger log = LoggerFactory.getLogger(StateIdValidator.class);

	public StateIdValidator(StateService stateService) {
		this.stateService = stateService;
	}

	@Override
	public boolean isValid(Long stateId, ConstraintValidatorContext constraintValidatorContext) {
		final Optional<State> stateOptional = stateService.findStateById(stateId);
		log.info("State for {} found {}", stateId, stateOptional.isPresent());
		return stateOptional.isPresent();
	}
}
