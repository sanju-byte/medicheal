package com.helxir.medicheal.service;

import java.util.List;

import com.helxir.medicheal.entity.Admin;
import com.helxir.medicheal.entity.User;

public interface AdminService {
	public List<Admin> findByRole(String user);

	public Admin findByEmail(String user);
	
	public List<Admin> findAll();

	public void save(Admin admin);
	
}
