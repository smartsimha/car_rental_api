package com.ty.carrentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapi.dto.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findAdminByEmail(String Email);
}
