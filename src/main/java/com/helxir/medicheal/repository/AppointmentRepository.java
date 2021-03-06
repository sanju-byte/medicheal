package com.helxir.medicheal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helxir.medicheal.entity.Appointment;


@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	
}