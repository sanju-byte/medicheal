package com.helxir.medicheal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.helxir.medicheal.entity.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	User findByConfirmationToken(String confirmationToken);

	List<User> findAll();
}