package com.helxir.medicheal.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.helxir.medicheal.entity.State;

@Repository
public interface StateRepository extends PagingAndSortingRepository<State, Long> {

	List<State> findStatesByCountry_Id(Long countryId);
}
