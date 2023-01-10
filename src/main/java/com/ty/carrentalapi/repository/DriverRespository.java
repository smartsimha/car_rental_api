package com.ty.carrentalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carrentalapi.dto.Driver;

public interface DriverRespository extends JpaRepository<Driver, Integer> {
	public Driver findDriverByDl(String dl);
	
}
