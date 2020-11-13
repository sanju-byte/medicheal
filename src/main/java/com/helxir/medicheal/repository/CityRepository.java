package com.helxir.medicheal.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.helxir.medicheal.entity.City;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    List<City> findCitiesByState_Id(Long stateId);
}
